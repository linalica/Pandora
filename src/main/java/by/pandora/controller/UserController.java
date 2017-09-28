package by.pandora.controller;

import by.pandora.model.User;
import by.pandora.service.UserService;
import by.pandora.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        return "redirect:/main";
    }


    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String registrationConfirm(String token) {
        userService.confirmRegistration(token);
        return "redirect:/main";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/searchUser", method = RequestMethod.GET)
    public String searchUser(String username, HttpServletRequest request) {
        request.getSession().setAttribute(ControllerConstants.USER_REQUIRED_KEY, userService.findByUsername(username));
        return "admin";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/banUser", method = RequestMethod.GET)
    public String banUser(Long userId, HttpServletRequest request) {
        userService.banUser(userId);
        request.getSession().setAttribute(ControllerConstants.USER_REQUIRED_KEY, userService.findById(userId));
        return "redirect:/admin";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/diluteUser", method = RequestMethod.GET)
    public String diluteUser(Long userId, HttpServletRequest request) {
        request.getSession().setAttribute(ControllerConstants.USER_REQUIRED_KEY, userService.findById(userId));
        userService.diluteUser(userId);
        return "redirect:/admin";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(Long userId, HttpServletRequest request) {
        request.getSession().removeAttribute(ControllerConstants.USER_REQUIRED_KEY);
        userService.delete(userId);
        return "redirect:/admin";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/verifyAccount", method = RequestMethod.GET)
    public String verifyAccount(Principal principal) {
        userService.verifyAccountByUsername(principal.getName());
        return "redirect:main";
    }
}
