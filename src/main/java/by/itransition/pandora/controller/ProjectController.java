package by.itransition.pandora.controller;

import by.itransition.pandora.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */

@Controller
public class ProjectController {

    @RequestMapping(value = {"/project/newProject"}, method = RequestMethod.GET)
    public String newProject(Model model) {
        model.addAttribute("newProjectForm", new Project());
        System.out.println("newProject Get " + model);
        return "newProject";
    }

    @RequestMapping(value = {"/project/newProject"}, method = RequestMethod.POST)
    public String newProject(@ModelAttribute("newProjectForm") Project project, Principal principal) {
        System.out.println("newProject Post "+ project);

        return "main";
    }


}
