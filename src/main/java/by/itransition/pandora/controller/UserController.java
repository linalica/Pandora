package by.itransition.pandora.controller;

import by.itransition.pandora.model.User;
import by.itransition.pandora.security.SecurityService;
import by.itransition.pandora.service.UserService;
import by.itransition.pandora.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */
@Controller
public class UserController {


    @Autowired
    private SecurityService securityService;

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
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        System.err.println("--- /registration ");
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        return "redirect:/main";
    }

    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String regitrationConfirm(String token) {
        System.err.println("--- /registrationConfirm " + token);
        userService.confirmRegistration(token);
        return "redirect:/main";
    }

}
