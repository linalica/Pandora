package by.pandora.service.impl;

import by.pandora.controller.ControllerConstants;
import by.pandora.service.ImageService;
import by.pandora.service.ProjectService;
import by.pandora.service.UserService;
import by.pandora.util.ImageManager;
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

    @Autowired
    ProjectService projectService;

    private static final Logger LOGGER = LogManager.getLogger(ImageServiceImpl.class);
    private static final String AVATAR_PARAM = "avatar";


    @Override
    public void resetAvatar(Principal principal) {
        userService.updateAvatarByUsername(principal.getName(), null);
    }

    @Override
    public byte[] getMainPicture() {
        return ImageManager.getMainPicture();
    }

    @Override
    public  byte[] getNyPicture() {
        return ImageManager.getNyPicture();
    }

    @Override
    public  byte[] getBeautifulPicture() {
        return ImageManager.getBeautifulPicture();
    }

    @Override
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

    @Override
    public byte[] getAvatar(Long userId) {
        byte[] image =  userService.findAvatarById(userId);
        if (image == null || image.length == 0) {
            image = ImageManager.getDefaultAvatar();
        }
        return image;
    }

    @Override
    public byte[] getProjectPicture(Long projectId) {
        byte[] image = null;
        if (projectId != null) {
            image = projectService.findPictureById(projectId);
        }
        if (image == null || image.length == 0) {
            image = ImageManager.getDefaultProjectPicture();
        }
        return image;
    }

    @Override
    public void changeAvatar(MultipartFile avatarPart, Principal principal) {
        byte[] avatar = getImage(avatarPart);
        if (avatar.length != 0) {
            userService.updateAvatarByUsername(principal.getName(), avatar);
        }
    }

    @Override
    public void changeProjectPicture(MultipartFile projectPicturePart, Long projectId) {
        byte[] projectPicture = getImage(projectPicturePart);
        if (projectPicture.length != 0) {
            projectService.updateProjectPictureById(projectId, projectPicture);
        }
    }

    private byte[] getImage(MultipartFile imagePart){
        if (imagePart == null) {
            LOGGER.log(Level.WARN, "Problems with getImage.");
        }
        byte[] empty = {};
        byte[] image = empty;
        int fileSize = (int) imagePart.getSize();
        if (fileSize != 0 && fileSize <= ControllerConstants.MAX_FILE_SIZE) {
            image = new byte[fileSize];
            try {
                int bytesAmount = imagePart.getInputStream().read(image, 0, fileSize);
                if (bytesAmount != fileSize) {
                    image = empty;
                }
            } catch (IOException e) {
                LOGGER.log(Level.WARN, "IOException in getImage.", e);
                image = empty;
            }
        }
        return image;
    }
}
