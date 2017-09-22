package by.itransition.pandora.controller;

import by.itransition.pandora.service.ImageService;
import by.itransition.pandora.service.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
@Controller
public class ImageController {

    @Autowired
    ImageService imageService;

    @Autowired
    UserService userService;

    private static final Logger LOGGER = LogManager.getLogger(ImageController.class);

    @RequestMapping(value = "/loadAvatar", method = RequestMethod.GET)
    public void loadAvatar(HttpServletResponse response, Principal principal) {
        try {
            response.getOutputStream().write(imageService.getAvatar(principal));
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Can`t load avatar from " + principal + " .", e);
        }
    }

    @RequestMapping(value = "/changeAvatar", method = RequestMethod.POST)
    public String changeAvatar(@RequestParam("avatar") MultipartFile avatar, Principal principal) {
        imageService.changeAvatar(avatar, principal);
        return "redirect:/main";
    }
}
