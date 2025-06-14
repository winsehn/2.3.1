package web.service.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.model.UserActionEnum;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class UserActionDispatcher {

    private final Map<UserActionEnum, UserActionHandler> handlersMap = new EnumMap<>(UserActionEnum.class);

    @Autowired
    public UserActionDispatcher(List<UserActionHandler> handlers) {
        for (UserActionHandler handler : handlers) {
            handlersMap.put(handler.getUserModify(), handler);
        }
    }

    public void dispatch(UserActionEnum userModify, User user) {
        UserActionHandler handler = handlersMap.get(userModify);
        if (handler == null) {
            throw new RuntimeException("No handler found for user modify: " + userModify);
        }
        handler.action(user);
    }
}
