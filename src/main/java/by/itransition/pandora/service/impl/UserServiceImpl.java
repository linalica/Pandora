package by.itransition.pandora.service.impl;

import by.itransition.pandora.model.User;
import by.itransition.pandora.model.UserRole;
import by.itransition.pandora.model.VerificationToken;
import by.itransition.pandora.repository.RegistrationRepository;
import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.service.UserService;
import by.itransition.pandora.util.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

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
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.ROLE_USER);
        user.setEnabled(false);
        user.setCreatingTime(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(user);

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUserId(userRepository.findIdByUsername(user.getUsername()));
        verificationToken.setToken(UUID.randomUUID().toString());
        registrationRepository.save(verificationToken);

        new MailSender().sendVerificationEmail(user.getUsername(), verificationToken);
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

    @Override
    public String findUsernameById(Long id) {
        return userRepository.findUsernameById(id);
    }

    @Override
    public UserRole findRoleByUsername(String username) {
        return userRepository.findRoleByUsername(username);
    }

    @Override
    public String findLocaleByUsername(String username) {
        return userRepository.findLocaleByUsername(username);
    }

    @Override
    public byte[] findAvatarByUsername(String username) {
        return userRepository.findAvatarByUsername(username);
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

    @Transactional
    @Override
    public void confirmRegistration(String token){
        VerificationToken verificationToken = registrationRepository.findByToken(token);
        if(verificationToken != null) {
            User user = userRepository.findOne(verificationToken.getUserId());
            user.setEnabled(true);
            userRepository.save(user);
            registrationRepository.delete(verificationToken.getId());
        }
    }
}
