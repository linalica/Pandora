package by.itransition.pandora.service;

import by.itransition.pandora.model.User;
import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.service.dto.model.UserListDto;
import by.itransition.pandora.service.transformer.UserListTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private UserRepository userRepository;

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

    void updateLastLoginByUsername(String username);

    void updateLocaleByUsername(String username, String locale);
>>>>>>> actual-database
}
