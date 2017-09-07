package by.itransition.pandora.service;


import by.itransition.pandora.model.User;

/**
 * Service class for {@link by.itransition.pandora.model.User}
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
