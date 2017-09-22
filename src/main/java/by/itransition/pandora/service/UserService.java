package by.itransition.pandora.service;


import by.itransition.pandora.model.User;
import by.itransition.pandora.model.UserRole;

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

    UserRole findRoleByUsername(String username);

    String findUsernameById(Long id);

    byte[] findAvatarByUsername(String username);

    void updateLocaleByUsername(String username, String locale);

    void updateThemeByUsername(String username, String theme);

    void updateLastLoginByUsername(String username);

    void updateAvatarByUsername(String username, byte[] avatar);

    void confirmRegistration(String verificationToken);

}
