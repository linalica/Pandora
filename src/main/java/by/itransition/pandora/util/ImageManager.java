package by.itransition.pandora.util;

import by.itransition.pandora.controller.ImageController;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class ImageManager {

    private static final Logger LOGGER = LogManager.getLogger(ImageController.class);

    private static final String FILE_PATH_AVATAR = "/images/default_account_avatar.png";

    private static ImageManager imageManager;

    private static boolean init = false;
    private byte[] defaultAvatar = {};

    private ImageManager() {
    }

    private static void init() {
        imageManager = new ImageManager();
        ClassLoader classLoader = imageManager.getClass().getClassLoader();
        URL urlAvatar = classLoader.getResource(FILE_PATH_AVATAR);
        if (urlAvatar != null) {
            File fileAvatar = new File(urlAvatar.getFile());
            if (fileAvatar.exists()) {
                try {
                    imageManager.defaultAvatar = Files.readAllBytes(fileAvatar.toPath());
                } catch (IOException e) {
                    LOGGER.log(Level.ERROR, "Can't read default images.");
                }
            } else {
                LOGGER.log(Level.ERROR, "Default images don`t exist.");
            }
        } else {
            LOGGER.log(Level.ERROR, "Can't load resource for default images.");
        }
        init = true;
    }

    public static byte[] getDefaultAvatar() {
        if (!init) {
            init();
        }
        return imageManager.defaultAvatar;
    }

}
