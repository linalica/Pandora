package by.itransition.pandora.service;


import by.itransition.pandora.model.Project;
import by.itransition.pandora.model.User;

/**
 * Service class for {@link User}
 *
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

public interface ProjectService {

    void update(Project project);

    void save(Project project);

    Project findById(Long id);

    Project findFullById(Long id);
}
