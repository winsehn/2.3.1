package web.service.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.model.UserActionEnum;
import web.service.UserService;

@Component
public class UpdateUserHandler implements UserActionHandler {

    private UserService userService;

    @Autowired
    public UpdateUserHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserActionEnum getUserModify() {
        return UserActionEnum.update;
    }

    @Override
    public void action(User user) {
        userService.updateUser(user);
    }
}
