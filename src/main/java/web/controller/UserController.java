package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.model.UserActionEnum;
import web.service.UserService;
import web.service.action.UserActionDispatcher;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserActionDispatcher uad;

    @GetMapping(value = "/users")
    public String index(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("editingId", null);
        return "users";
    }

    @PostMapping(value = "/users")
    public String addUser(Model model, @RequestParam(name = "modify") UserActionEnum modify,
                          @RequestParam(name = "id", required = false) Long id,
                          @RequestParam(name = "name", required = false) String name,
                          @RequestParam(name = "second_name", required = false) String second_name,
                          @RequestParam(name = "years", required = false) Byte years,
                          @RequestParam(name = "sex", required = false) String sex) {
        if (modify == UserActionEnum.edit) {
            model.addAttribute("editingId", id);
            model.addAttribute("users", userService.getAllUsers());
            return "users";
        }

        User user = new User(name, second_name, years, sex);
        if (id != null) {
            user.setId(id);
        }
        uad.dispatch(modify, user);
        return "redirect:/users";
    }
}
