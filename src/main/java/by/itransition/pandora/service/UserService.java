package by.itransition.pandora.service;

import by.itransition.pandora.model.User;
import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.service.dto.model.UserListDto;
import by.itransition.pandora.service.transformer.UserListTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    //@Autowired
    private UserListTransformer userListTransformer = new UserListTransformer();

    @Autowired
    private UserRepository userRepository;

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
}
