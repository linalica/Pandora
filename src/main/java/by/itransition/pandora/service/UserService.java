package by.itransition.pandora.service;


import by.itransition.pandora.model.User;

import java.util.List;

/**
 * Service class for {@link by.itransition.pandora.model.User}
 *
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

public interface UserService {

    void update(User user);

    void save(User user);

    User findByUsername(String username);

    String findLocaleByUsername(String username);

    void updateLocaleByUsername(String username, String locale);

    void updateLastLoginByUsername(String username);

    List<User> findInfo();

}
