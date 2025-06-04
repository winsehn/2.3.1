package web.service.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.model.UserModify;
import web.service.UserService;

@Component
public class DeleteUserHandler implements UserActionHandler {

    private UserService userService;

    @Autowired
    public DeleteUserHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserModify getUserModify() {
        return UserModify.delete;
    }

    @Override
    public void action(User user) {
        userService.deleteUser(user);
    }
}
