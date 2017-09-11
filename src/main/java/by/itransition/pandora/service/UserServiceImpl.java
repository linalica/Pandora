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

        System.out.println("-- UserServiceImpl | save");
        System.out.println("user: " + user);

        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /*@Override
    public void setLastLoginTime(Timestamp lastLoginTime, String username) {
        userRepository.updateLastLoginTimeByUsername(lastLoginTime, username);
    }*/



    public void updateLastLoginByUsername(String username){

        User user = findByUsername(username);
        user.setLastLoginTime(Timestamp.valueOf(LocalDateTime.now()));
        save(user);

        System.out.println("-- UserServiceImpl | updateLastLoginByUsername");
        System.out.println("user: " + user);
    }
}
