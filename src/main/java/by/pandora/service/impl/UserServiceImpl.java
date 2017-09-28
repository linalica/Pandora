package by.pandora.service.impl;

import by.pandora.model.User;
import by.pandora.model.UserRole;
import by.pandora.model.VerificationToken;
import by.pandora.repository.RegistrationRepository;
import by.pandora.repository.UserRepository;
import by.pandora.service.UserService;
import by.pandora.util.MailSender;
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
        userRepository.save(user);
    }

    @Override
    public void delete(Long userId) {
        userRepository.delete(userId);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
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
    public Long findIdByUsername(String username){
        return userRepository.findIdByUsername(username);
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
    public byte[] findAvatarById(Long id) {
        return userRepository.findAvatarById(id);
    }

    @Override
    public void updateLocaleByUsername(String username, String locale) {
        User user = findByUsername(username);
        user.setLocale(locale);
        update(user);
    }

    @Override
    public void verifyAccountByUsername(String username) {
        User user = findByUsername(username);
        user.setRole(UserRole.ROLE_VERIFIED);
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
            update(user);
            registrationRepository.delete(verificationToken.getId());
        }
    }

    @Override
    public void banUser(Long id) {
        User user = findById(id);
        user.setEnabled(false);
        update(user);
    }

    @Override
    public void diluteUser(Long id) {
        User user = findById(id);
        user.setEnabled(true);
        update(user);
    }


}
