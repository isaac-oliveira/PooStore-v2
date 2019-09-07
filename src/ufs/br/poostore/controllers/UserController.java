package ufs.br.poostore.controllers;

import ufs.br.poostore.consts.User;
import ufs.br.poostore.event.UserEvent;


/**
 *
 * @author isaac
 */
public class UserController {
    private static UserController instance = new UserController();
    private UserEvent userEvent;
    private User user;

    private UserController() {}

    public static UserController getInstance() {
        return instance;
    }

    public UserEvent getUserEvent() {
        return userEvent;
    }

    public void setUserEvent(UserEvent userEvent) {
        this.userEvent = userEvent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        if(user != null && userEvent != null) userEvent.onUserSelect(user);
    }

    public void userExit() {
        setUser(null);
        if(userEvent != null) userEvent.onUserExit();
    }
}
