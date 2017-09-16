package by.itransition.pandora.controller;

import by.itransition.pandora.service.UserService;
import by.itransition.pandora.service.UserServiceImpl;
import by.itransition.pandora.service.dto.UserListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserControllerAdmin {

    private final UserService userService = new UserServiceImpl();

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserListDto> finalAll() {
        return this.userService.findAll();
    }

}
