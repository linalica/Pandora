package by.itransition.pandora.controller;

import by.itransition.pandora.model.Visitor;
import by.itransition.pandora.service.UserService;
import by.itransition.pandora.util.URIAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/main", "/"}, method = RequestMethod.GET)
    public String main(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        return "main";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping(value = "/theme", method = RequestMethod.GET)
    public String theme(Principal principal, HttpServletRequest request, String theme) {
        if (principal != null) {
            String username = ((UserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername();
            userService.updateThemeByUsername(username, theme);
        }
        ((Visitor) request.getSession().getAttribute(ControllerConstants.VISITOR_KEY)).setTheme(theme);
        return "redirect:" + URIAnalyzer.getCurrentPage(request);
    }

    @RequestMapping(value = "/locale", method = RequestMethod.GET)
    public String locale(Principal principal, HttpServletRequest request, String locale) {
        if (principal != null) {
            String username = ((UserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername();
            userService.updateLocaleByUsername(username, locale);
        }
        ((Visitor) request.getSession().getAttribute(ControllerConstants.VISITOR_KEY)).setLocale(locale);
        return "redirect:" + URIAnalyzer.getCurrentPage(request);
    }

}
