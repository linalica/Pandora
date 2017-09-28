package by.pandora.service;


import by.pandora.model.User;
import by.pandora.model.UserRole;

/**
 * Service class for {@link User}
 *
 * @author Gulevich Ulyana
 * @version 1.0
 */

public interface UserService {

    void update(User user);

    void save(User user);

    void delete(Long userId);

    User findByUsername(String username);

    User findById(Long id);

    String findLocaleByUsername(String username);

    UserRole findRoleByUsername(String username);

    String findUsernameById(Long id);

    Long findIdByUsername(String username);

    byte[] findAvatarByUsername(String username);

    byte[] findAvatarById(Long id);

    void updateLocaleByUsername(String username, String locale);

    void updateThemeByUsername(String username, String theme);

    void updateLastLoginByUsername(String username);

    void updateAvatarByUsername(String username, byte[] avatar);

    void verifyAccountByUsername(String username);

    void confirmRegistration(String verificationToken);

    void diluteUser(Long id);

    void banUser(Long id);

}
