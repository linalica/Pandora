package by.itransition.pandora.service;

import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */
public interface ImageService {

    byte[] getAvatar(Principal principal);

    void changeAvatar(MultipartFile avatarPart, Principal principal);

    void resetAvatar(Principal principal);

}
