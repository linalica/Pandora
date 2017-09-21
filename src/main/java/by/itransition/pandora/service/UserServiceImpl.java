package by.itransition.pandora.service;

import by.itransition.pandora.model.User;
import by.itransition.pandora.model.UserRole;
import by.itransition.pandora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.ROLE_USER);
        user.setEnabled(true);
        user.setCreatingTime(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        user.setRole(UserRole.ROLE_USER);
        user.setEnabled(true);
        user.setCreatingTime(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public String findUsernameById(Long id) {
        return userRepository.findUsernameById(id);
    }

   /* public String findByUsername(String username) {
        return userRepository.findUsernameById(username);
    }
*/
    public UserRole findRoleByUsername(String username) {
        return userRepository.findRoleByUsername(username);
    }

    @Override
    public String findLocaleByUsername(String username) {
        return userRepository.findLocaleByUsername(username);
    }

    @Override
    public void updateLocaleByUsername(String username, String locale) {
        User user = findByUsername(username);
        user.setLocale(locale);
        update(user);
    }

    @Override
    public void updateThemeByUsername(String username, String theme) {
        User user = findByUsername(username);
        user.setTheme(theme);
        update(user);
    }

    @Override
    public void updateLastLoginByUsername(String username) {
        User user = findByUsername(username);
        user.setLastLoginTime(Timestamp.valueOf(LocalDateTime.now()));
        update(user);
    }

    @Override
    public void updateAvatarByUsername(String username, byte[] avatar) {
        User user = findByUsername(username);
        user.setAvatar(avatar);
        update(user);
    }

}
