package by.itransition.pandora.controller;

import by.itransition.pandora.model.User;
<<<<<<< HEAD
import by.itransition.pandora.repository.UserRepository;
import by.itransition.pandora.service.UserService;
=======
import by.itransition.pandora.model.Visitor;
import by.itransition.pandora.security.SecurityService;
import by.itransition.pandora.service.UserService;
import by.itransition.pandora.util.URIAnalyzer;
import by.itransition.pandora.validator.UserValidator;
>>>>>>> actual-database
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
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

<<<<<<< HEAD
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
=======
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout, HttpServletRequest request) {
       /* String username = securityService.findLoggedInUsername();
        System.err.println("-- username: " + username);
        userService.updateLastLoginByUsername(securityService.findLoggedInUsername());
        System.err.println("-- lastLogin: " + userService.findByUsername(securityService.findLoggedInUsername()).getLastLoginTime());*/

        request.getSession().setAttribute(ControllerConstants.LOCALE_KEY, ControllerConstants.DEFAULT_LOCALE);
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }
        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
>>>>>>> actual-database
    }

    @GetMapping(value = "/me")
    @ResponseStatus(value = HttpStatus.OK)
    public AuthUserDto me() {
        return authenticationService.getMe();
    }

<<<<<<< HEAD

    @Bean
    public CommandLineRunner bootstrap() {
        return (args) -> {
            System.out.println("--------------It is CommandLineRunner!");
        };
    }*/





=======
    @RequestMapping(value = "/locale", method = RequestMethod.GET)
    public String locale(/*Principal principal,*/ HttpServletRequest request, String locale) {
        String username = securityService.findLoggedInUsername();
        if (username != null) {
            userService.updateLocaleByUsername(securityService.findLoggedInUsername(), locale);
        }
        ((Visitor) request.getSession().getAttribute(ControllerConstants.VISITOR_KEY)).setLocale(locale);
        return "redirect:" + URIAnalyzer.getCurrentPage(request);
    }

}
>>>>>>> actual-database
