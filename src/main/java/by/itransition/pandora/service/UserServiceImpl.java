package by.itransition.pandora.service;

import by.itransition.pandora.model.User;
import by.itransition.pandora.model.UserRole;
import by.itransition.pandora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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

        //TODO: remove this
        System.out.println("-- UserServiceImpl | save");
        System.out.println("user: " + user);
    }

    @Override
    public void update(User user) {
        user.setRole(UserRole.ROLE_USER);
        user.setEnabled(true);
        user.setCreatingTime(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(user);

        //TODO: remove this
        System.out.println("-- UserServiceImpl | update");
        System.out.println("user: " + user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public String findLocaleByUsername(String username) {
        return userRepository.findLocaleByUsername(username);
    }

    @Override
    public void updateLocaleByUsername(String username, String locale) { //TODO: updateLocaleLoginByUsername?
        User user = findByUsername(username);
        user.setLocale(locale);
        update(user);
    }

    @Override
    public void updateLastLoginByUsername(String username) { //TODO: updateLastLoginByUsername?
        User user = findByUsername(username);
        user.setLastLoginTime(Timestamp.valueOf(LocalDateTime.now()));
        update(user);
    }

    @Override
    public List<User> findInfo() {
        return userRepository.findInfo();
    }



}
