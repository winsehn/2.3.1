package web.service.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.model.UserActionEnum;
import web.service.UserService;

@Component
public class CreateUserHandler implements UserActionHandler {

    private UserService userService;

    @Autowired
    public CreateUserHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserActionEnum getUserModify() {
        return UserActionEnum.create;
    }

    @Override
    public void action(User user) {
        userService.addUser(user);
    }
}
