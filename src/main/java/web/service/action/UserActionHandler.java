package web.service.action;

import web.model.User;
import web.model.UserActionEnum;

public interface UserActionHandler {
    UserActionEnum getUserModify();

    void action(User User);
}
