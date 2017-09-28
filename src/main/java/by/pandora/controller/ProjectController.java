package by.pandora.controller;

import by.pandora.model.Objective;
import by.pandora.model.Project;
import by.pandora.model.SubscriptionStatus;
import by.pandora.service.ProjectService;
import by.pandora.service.UserService;
import by.pandora.validator.ProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectValidator projectValidator;

    @Autowired
    UserService userService;

    @Secured({"ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = {"/newProject"}, method = RequestMethod.GET)
    public String newProject(Model model) {
        model.addAttribute("newProjectForm", new Project());
        return "newProject";
    }

    @Secured({"ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = {"/newProject"}, method = RequestMethod.POST)
    public String newProject(@ModelAttribute("newProjectForm") Project projectForm, BindingResult bindingResult,
                             String projectMainObjectiveName, Double projectMainObjectivePrice, Principal principal) throws Exception {
        ArrayList<Objective> objectives = new ArrayList<>();
        objectives.add(new Objective(projectMainObjectiveName, projectMainObjectivePrice, true));
        projectForm.setObjectives(objectives);
        projectValidator.validate(projectForm, bindingResult);
        if (projectMainObjectiveName == null) {
            bindingResult.getModel().put("error", "This field is required.");
        }
        if (bindingResult.hasErrors()) {
            return "newProject";
        }
        projectService.addProject(projectForm, principal);
        return "redirect:main";
    }

    @Secured({"ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = {"/myProjects"}, method = RequestMethod.GET)
    public String myProjects(Model model, HttpServletRequest request, Principal principal) {
        List<Project> projectsList = projectService.findProjectsByCreatorIdForMain(
                userService.findIdByUsername(principal.getName()));
        request.setAttribute(ControllerConstants.PROJECT_LIST_KEY, projectsList);
        model.addAttribute(ControllerConstants.FORM_ADD_OBJECTIVE_KEY, new Objective());
        return "myProjects";
    }

    @RequestMapping(value = {"/project"}, method = RequestMethod.GET)
    public String project(HttpServletRequest request, HttpServletResponse response, Long projectId) throws IOException {
        if (projectId != null) {
            request.getSession().setAttribute(ControllerConstants.PROJECT_KEY, projectService.findFullById(projectId));
        }
        return "project";
    }

    @Secured({"ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = {"/addObject"}, method = RequestMethod.POST)
    public String addObject(@ModelAttribute(ControllerConstants.FORM_ADD_OBJECTIVE_KEY) Objective objectiveForm, Model model,
                            HttpServletRequest request, Principal principal, Long projectId) {
        projectService.addObjective(objectiveForm, projectId);
        List<Project> projectsList = projectService.findProjectsByCreatorIdForMain(
                userService.findIdByUsername(principal.getName()));
        request.setAttribute(ControllerConstants.PROJECT_LIST_KEY, projectsList);
        model.addAttribute(ControllerConstants.FORM_ADD_OBJECTIVE_KEY, new Objective());
        return "redirect:/myProjects";
    }

    @Secured({"ROLE_USER", "ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = {"/subscribe"}, method = RequestMethod.POST)
    public String subscribe(HttpServletRequest request, Long projectId, Principal principal) {
        projectService.addSubscriptionStateDependent(SubscriptionStatus.NEWS, principal, projectId);
        request.getSession().setAttribute(ControllerConstants.PROJECT_KEY, projectService.findFullById(projectId));
        return "redirect:/project";
    }

    @Secured({"ROLE_USER", "ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = {"/setMark"}, method = RequestMethod.GET)
    public String setMark(HttpServletRequest request, Long projectId, Principal principal, Integer value) {
        if (value <= 5 && value >= 1) {
            projectService.addMark(value, principal, projectId);
            request.getSession().setAttribute(ControllerConstants.PROJECT_KEY, projectService.findFullById(projectId));
        }
        return "redirect:/project";
    }

    @Secured({"ROLE_USER", "ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = {"/doPayment"}, method = RequestMethod.GET)
    public String doPayment(HttpServletRequest request, Long objectiveId, Principal principal) {
        if (principal == null) {
            return "redirect:/registration";
        }
        if (objectiveId == null) {
            return "redirect:/project";
        }
        request.setAttribute(ControllerConstants.PROJECT_KEY, projectService.findProjectByObjectiveId(objectiveId));
        request.setAttribute(ControllerConstants.OBJECTIVE_KEY, projectService.findObjectiveByObjectiveId(objectiveId));
        return "/doPayment";
    }

    @Secured({"ROLE_USER", "ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = {"/pay"}, method = RequestMethod.POST)
    public String pay(HttpServletRequest request,Long objectiveId, Principal principal,
                      String accountNumber, Double paymentAmount) {
        if (principal == null) {
            return "redirect:/registration";
        }
        if (objectiveId == null || accountNumber.length() != 16) {
            return "redirect:/project";
        }
        Project project =  (Project) request.getSession().getAttribute(ControllerConstants.PROJECT_KEY);
        request.getSession().setAttribute(ControllerConstants.PROJECT_KEY, projectService.findFullById(project.getId()));
        projectService.addPayment(objectiveId, paymentAmount);
        return "redirect:/project";
    }
}
