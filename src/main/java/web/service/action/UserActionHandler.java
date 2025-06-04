package web.service.action;

import web.model.User;
import web.model.UserModify;

public interface UserActionHandler {
    UserModify getUserModify();

    void action(User User);
}
