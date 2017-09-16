package by.itransition.pandora.service.transformer;


import by.itransition.pandora.model.User;
import by.itransition.pandora.service.dto.AuthUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author i.katlinsky
 * @since 22.07.2016
 */
@Component
@RequiredArgsConstructor
public class AuthUserTransformer {

    public AuthUserDto makeDto(final User user) {
        AuthUserDto authUserDto = new AuthUserDto();

        authUserDto.setId(user.getId());
        authUserDto.setUsername(user.getUsername());
        authUserDto.setRole(user.getRole().name());

        return authUserDto;
    }

}
