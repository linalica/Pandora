package by.itransition.pandora.controller;

import by.itransition.pandora.model.Visitor;
import by.itransition.pandora.repository.CommentRepository;
import by.itransition.pandora.repository.MarkRepository;
import by.itransition.pandora.repository.ObjectiveRepository;
import by.itransition.pandora.service.ProjectService;
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
    private ObjectiveRepository objectiveRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    UserService userService;


    @RequestMapping(value = {"/main", "/"}, method = RequestMethod.GET)
    public String main(Model model, String error, String logout, HttpServletRequest request) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        /*if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }*/
        return "main";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }


    @RequestMapping(value = "/theme", method = RequestMethod.GET)
    public String theme(Principal principal, HttpServletRequest request, String theme) {
        System.err.println("--- /theme: " + theme);
        if (principal != null) {
            String username = ((UserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername();
            userService.updateThemeByUsername(username, theme);
        }
        ((Visitor) request.getSession().getAttribute(ControllerConstants.VISITOR_KEY)).setTheme(theme);
        return "redirect:" + URIAnalyzer.getCurrentPage(request);
    }

    @RequestMapping(value = "/locale", method = RequestMethod.GET)
    public String locale(Principal principal, HttpServletRequest request, String locale) {

        /*if(principal!=null) {
            System.err.println("--- " + ((org.springframework.security.authentication.UsernamePasswordAuthenticationToken) principal)
                    .getAuthorities().toArray()[0]);
        }

        Project project = projectService.findById(new Long(1));
        System.err.println("--- " + project);

        Objective o = new Objective();
        o.setPrice(200.0);
        o.setName("new obj");
        o.setDescription("try to add obj");
        projectService.addObjective(o, new Long(1));

        Project project2 = projectService.findFullById(new Long(1));
        System.err.println("--- " + project2);
        System.err.println("--- " + project2.getObjectives());

        Project project3 = projectService.findFullById(new Long(2));
        System.err.println("--- " + project3);
        System.err.println("--- " + project3.getObjectives());*/

        if (principal != null) {
            String username = ((UserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername();
            userService.updateLocaleByUsername(username, locale);
        }
        ((Visitor) request.getSession().getAttribute(ControllerConstants.VISITOR_KEY)).setLocale(locale);
        return "redirect:" + URIAnalyzer.getCurrentPage(request);
    }

}
