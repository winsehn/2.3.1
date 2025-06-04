package web.service.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.model.UserModify;
import web.service.UserService;

@Component
public class UpdateUserHandler implements UserActionHandler {

    private UserService userService;

    @Autowired
    public UpdateUserHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserModify getUserModify() {
        return UserModify.update;
    }

    @Override
    public void action(User user) {
        userService.updateUser(user);
    }
}
