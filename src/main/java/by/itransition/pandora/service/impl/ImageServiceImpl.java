package by.itransition.pandora.service.impl;

import by.itransition.pandora.controller.ControllerConstants;
import by.itransition.pandora.service.ImageService;
import by.itransition.pandora.service.UserService;
import by.itransition.pandora.util.ImageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */

@Service
public class ImageServiceImpl implements ImageService {


    @Autowired
    UserService userService;

    private static final Logger LOGGER = LogManager.getLogger(ImageServiceImpl.class);
    private static final String AVATAR_PARAM = "avatar";

    public byte[] getAvatar(Principal principal) {
        byte[] image = null;
        if (principal != null) {
            String username = principal.getName();
            image = userService.findAvatarByUsername(username);
        }
        if (image == null || image.length == 0) {
            image = ImageManager.getDefaultAvatar();
        }
        return image;
    }


    public void changeAvatar(MultipartFile avatarPart, Principal principal) {

        System.out.println("-- avatarPart: " + avatarPart);

        if (avatarPart == null) {
            LOGGER.log(Level.WARN, "Problems with ChangeAvatarCommand.");
            return;
        }
        byte[] empty = {};
        byte[] avatar = empty;

        int fileSize = (int) avatarPart.getSize();
        System.out.println("-- fileSize: " + fileSize);

        if (fileSize != 0 && fileSize <= ControllerConstants.MAX_FILE_SIZE) {
            avatar = new byte[fileSize];
            try {
                int bytesAmount = avatarPart.getInputStream().read(avatar, 0, fileSize);
                if (bytesAmount != fileSize) {
                    avatar = empty;
                }
            } catch (IOException e) {
                LOGGER.log(Level.WARN, "IOException in ChangeAvatarCommand.", e);
                avatar = empty;
            }
        }
        if (avatar.length != 0) {
            userService.updateAvatarByUsername(principal.getName(), avatar);
        }
    }
}
