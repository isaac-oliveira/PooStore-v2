package ufs.br.poostore.event;

import ufs.br.poostore.consts.User;

/**
 *
 * @author isaac
 */
public interface UserEvent {
    void onUserSelect(User user);
    void onUserExit();
}
