package by.pandora.util;

import by.pandora.controller.ImageController;
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
    private static final String FILE_PATH_PROJECT_PICTURE = "/images/default_project_picture_cr.png";

    private static final String FILE_PATH_MAIN_PICTURE = "/images/mainPagePictureLong.png";
    private static final String FILE_PATH_NY_PICTURE = "/images/nyLong.jpg";
    private static final String FILE_PATH_BEAUTIFUL_PICTURE = "/images/beautifulPicture.jpg";

    private static ImageManager imageManager;

    private static boolean init = false;
    private byte[] defaultAvatar = {};
    private byte[] defaultProjectPicture = {};
    private byte[] mainPicture = {};
    private byte[] nyPicture = {};
    private byte[] beautifulPicture = {};

    private ImageManager() {
    }

    private static void init() {
        imageManager = new ImageManager();
        ClassLoader classLoader = imageManager.getClass().getClassLoader();
        URL urlAvatar = classLoader.getResource(FILE_PATH_AVATAR);
        URL urlPicture = classLoader.getResource(FILE_PATH_PROJECT_PICTURE);
        URL urlMainPicture = classLoader.getResource(FILE_PATH_MAIN_PICTURE);
        URL urlNyPicture = classLoader.getResource(FILE_PATH_NY_PICTURE);
        URL urlBeautifulPicture = classLoader.getResource(FILE_PATH_BEAUTIFUL_PICTURE);
        if (urlAvatar != null && urlPicture != null && urlMainPicture != null &&
                urlNyPicture != null && urlBeautifulPicture != null) {
            File fileAvatar = new File(urlAvatar.getFile());
            File fileProjectPicture = new File(urlPicture.getFile());
            File fileMainPicture = new File(urlMainPicture.getFile());
            File fileNyPicture = new File(urlNyPicture.getFile());
            File fileBeautifulPicture = new File(urlBeautifulPicture.getFile());
            if (fileAvatar.exists() && fileProjectPicture.exists() && fileMainPicture.exists() &&
                    fileNyPicture.exists() && fileBeautifulPicture.exists()) {
                try {
                    imageManager.defaultAvatar = Files.readAllBytes(fileAvatar.toPath());
                    imageManager.defaultProjectPicture = Files.readAllBytes(fileProjectPicture.toPath());
                    imageManager.mainPicture = Files.readAllBytes(fileMainPicture.toPath());
                    imageManager.nyPicture = Files.readAllBytes(fileNyPicture.toPath());
                    imageManager.beautifulPicture = Files.readAllBytes(fileBeautifulPicture.toPath());
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

    public static byte[] getDefaultProjectPicture() {
        if (!init) {
            init();
        }
        return imageManager.defaultProjectPicture;
    }

    public static byte[] getMainPicture() {
        if (!init) {
            init();
        }
        return imageManager.mainPicture;
    }

    public static byte[] getNyPicture() {
        if (!init) {
            init();
        }
        return imageManager.nyPicture;
    }

    public static byte[] getBeautifulPicture() {
        if (!init) {
            init();
        }
        return imageManager.beautifulPicture;
    }

}
