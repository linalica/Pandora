package by.itransition.pandora.service.transformer;

import by.itransition.pandora.model.User;
import by.itransition.pandora.service.dto.model.UserListDto;
import org.springframework.stereotype.Component;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
@Component
public class UserListTransformer {

    public UserListDto makeDto(final User user) {
        UserListDto dto = new UserListDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole().name());

        return dto;
    }
}
