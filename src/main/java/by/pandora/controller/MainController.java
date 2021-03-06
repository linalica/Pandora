package by.pandora.controller;

import by.pandora.model.Project;
import by.pandora.model.Visitor;
import by.pandora.service.ProjectService;
import by.pandora.service.UserService;
import by.pandora.util.URIAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

/**
 *
 *
 * @author Gulevich Ulyana
 * @version 1.0
 */

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = {"/main", "/"}, method = RequestMethod.GET)
    public String main(Model model, String error, HttpServletRequest request) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        List<Project> projectsPopular = projectService.findActiveProjectsAscFinishDateForMain();
        if (projectsPopular.size() > 3) {
            projectsPopular = projectsPopular.subList(0, 3);
        }
        List<Project> projectsExp = projectService.findActiveProjectsAscFinishDateForMain();
        if (projectsExp.size() > 3) {
            projectsExp = projectsExp.subList(0, 3);
        }
        List<Project> projectsLatest = projectService.findActiveProjectsAscCreatingDateForMain();
        if (projectsLatest.size() > 3) {
            projectsLatest = projectsLatest.subList(0, 3);
        }
        request.setAttribute(ControllerConstants.PROJECT_LIST_POPULAR_KEY, projectsPopular);
        request.setAttribute(ControllerConstants.PROJECT_LIST_EXPIRING_KEY, projectsExp);
        request.setAttribute(ControllerConstants.PROJECT_LIST_LATEST_KEY, projectsLatest);
        return "main";
    }

    @RequestMapping(value = "/theme", method = RequestMethod.GET)
    public String theme(Principal principal, HttpServletRequest request, String theme) {
        if (principal != null) {
            String username = principal.getName();
            userService.updateThemeByUsername(username, theme);
        }
        ((Visitor) request.getSession().getAttribute(ControllerConstants.VISITOR_KEY)).setTheme(theme);
        return "redirect:" + URIAnalyzer.getCurrentPage(request);
    }

    @RequestMapping(value = "/locale", method = RequestMethod.GET)
    public String locale(Principal principal, HttpServletRequest request, String locale) {
        if (principal != null) {
            String username = principal.getName();
            userService.updateLocaleByUsername(username, locale);
        }
        ((Visitor) request.getSession().getAttribute(ControllerConstants.VISITOR_KEY)).setLocale(locale);
        return "redirect:" + URIAnalyzer.getCurrentPage(request);
    }
}
