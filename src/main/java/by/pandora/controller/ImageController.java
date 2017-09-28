package by.pandora.controller;

import by.pandora.service.ImageService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * Controller for images.
 *
 * @author Gulevich Ulyana
 * @version 1.0
 */
@Controller
public class ImageController {

    @Autowired
    ImageService imageService;

    private static final Logger LOGGER = LogManager.getLogger(ImageController.class);

    @RequestMapping(value = "/user/loadAvatar")
    public void loadAvatar(HttpServletResponse response, Principal principal) {
        try {
            response.getOutputStream().write(imageService.getAvatar(principal));
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Can`t load avatar from " + principal + " .", e);
        }
    }

    @RequestMapping(value = "/user/loadAvatarById/{userId}")
    public void loadAvatarById(HttpServletResponse response, @PathVariable Long userId) {
        try {
            response.getOutputStream().write(imageService.getAvatar(userId));
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Can`t load avatar from " + userId + " .", e);
        }
    }

    @Secured({"ROLE_USER", "ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = "/user/changeAvatar")
    public String changeAvatar(@RequestParam("avatar") MultipartFile avatar, Principal principal) {
        imageService.changeAvatar(avatar, principal);
        return "redirect:/main";
    }

    @Secured({"ROLE_USER", "ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = "/user/resetAvatar")
    public String resetAvatar(Principal principal) {
        imageService.resetAvatar(principal);
        return "redirect:/main";
    }

    @Secured({"ROLE_VERIFIED", "ROLE_ADMIN"})
    @RequestMapping(value = "/project/changePicture/{projectId}")
    public String changePicture(@RequestParam("picture") MultipartFile picture, @PathVariable Long projectId) {
        imageService.changeProjectPicture(picture, projectId);
        return "redirect:/myProjects";
    }

    @RequestMapping(value = "/project/loadPicture/{projectId}")
    public void loadProjectPicture(HttpServletResponse response, @PathVariable Long projectId) {
        try {
            response.getOutputStream().write(imageService.getProjectPicture(projectId));
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Can`t load picture from " + projectId + " .", e);
        }
    }

    @RequestMapping(value = "/main/loadMainPicture")
    public void loadMainPicture(HttpServletResponse response) {
        try {
            response.getOutputStream().write(imageService.getMainPicture());
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Can`t load picture from system.", e);
        }
    }

    @RequestMapping(value = "/main/loadNyPicture")
    public void loadNyPicture(HttpServletResponse response) {
        try {
            response.getOutputStream().write(imageService.getNyPicture());
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Can`t load picture from system.", e);
        }
    }

    @RequestMapping(value = "/main/loadBeautifulPicture")
    public void loadBeautifulPicture(HttpServletResponse response) {
        try {
            response.getOutputStream().write(imageService.getBeautifulPicture());
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Can`t load picture from system.", e);
        }
    }
}
