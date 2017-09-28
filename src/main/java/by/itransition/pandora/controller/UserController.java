package by.itransition.pandora.controller;

import by.itransition.pandora.model.User;
import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */


@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/lol",  method = RequestMethod.POST)
    String lol(String s) {
        User user = userRepository.findByUsername("proselyte5");
        System.out.println("POST lol: " + user);
        /*List<UserListDto> users = userService.findAll();
        Iterator<UserListDto> it = users.iterator();
        while(it.hasNext()){
            System.out.println("- | " + it.next());
        }*/

        return "Hello, my darling!";
    }

    @RequestMapping(value = "/lol",  method = RequestMethod.GET)
    String lol() {
        User user = userRepository.findByUsername("proselyte5");
        System.out.println("GET lol: " + user);
        /*List<UserListDto> users = userService.findAll();
        Iterator<UserListDto> it = users.iterator();
        while(it.hasNext()){
            System.out.println("- | " + it.next());
        }*/

        return "Hello, my darling!";
    }

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

}

/*
@PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    public LoginResponseDto login(@RequestBody final LoginRequestDto loginRequestDto) {

        return authenticationService.login(loginRequestDto);
    }

    @GetMapping(value = "/me")
    @ResponseStatus(value = HttpStatus.OK)
    public AuthUserDto me() {
        return authenticationService.getMe();
    }


    @Bean
    public CommandLineRunner bootstrap() {
        return (args) -> {
            System.out.println("--------------It is CommandLineRunner!");
        };
    }*/





