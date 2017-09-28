package by.itransition.pandora.service;

import by.itransition.pandora.model.User;
<<<<<<< HEAD
import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.service.dto.model.UserListDto;
import by.itransition.pandora.service.transformer.UserListTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
=======
import by.itransition.pandora.model.UserRole;
>>>>>>> new-start

<<<<<<< HEAD
@Service
public class UserService {
=======
/**
 * Service class for {@link by.itransition.pandora.model.User}
 *
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */
>>>>>>> actual-database

    //@Autowired
    private UserListTransformer userListTransformer = new UserListTransformer();

<<<<<<< HEAD
    @Autowired
    private UserRepository userRepository;
=======
    void update(User user);

    void save(User user);
>>>>>>> new-start

<<<<<<< HEAD
    //@Transactional(readOnly = true)
    public List<UserListDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserListDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserListDto dto = this.userListTransformer.makeDto(user);
            userDtoList.add(dto);
        }
        return userDtoList;
    }
=======
    User findByUsername(String username);

<<<<<<< HEAD
    void updateLastLoginByUsername(String username);

    void updateLocaleByUsername(String username, String locale);
>>>>>>> actual-database
=======
    String findLocaleByUsername(String username);

    UserRole findRoleByUsername(String username);

    String findUsernameById(Long id);

    byte[] findAvatarByUsername(String username);

    void updateLocaleByUsername(String username, String locale);

    void updateThemeByUsername(String username, String theme);

    void updateLastLoginByUsername(String username);

    void updateAvatarByUsername(String username, byte[] avatar);

    void confirmRegistration(String verificationToken);

>>>>>>> new-start
}
