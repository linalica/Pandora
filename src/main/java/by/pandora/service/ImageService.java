package by.pandora.service;

import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
public interface ImageService {


    byte[] getMainPicture();

    byte[] getNyPicture();

    byte[] getBeautifulPicture();

    byte[] getAvatar(Principal principal);

    byte[] getAvatar(Long userId);

    byte[] getProjectPicture(Long projectId);

    void changeAvatar(MultipartFile avatarPart, Principal principal);

    void resetAvatar(Principal principal);

    void changeProjectPicture(MultipartFile projectPicturePart, Long projectId);

}
