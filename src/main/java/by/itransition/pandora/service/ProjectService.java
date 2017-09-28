package by.itransition.pandora.service;


import by.itransition.pandora.model.Comment;
import by.itransition.pandora.model.Objective;
import by.itransition.pandora.model.Project;
import by.itransition.pandora.model.User;

import java.util.List;

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

    List<Objective> findProjectObjectivesById(Long id);

    List<Comment> findProjectCommentsById(Long id);

    List<Objective> findProjectMinObjectivesById(Long id);

    Double findProjectRatingById(Long id);

    void addObjective(Objective objective, Long projectId);

    void addComment(Comment comment, Long projectId);

    void addMark(Integer value, Long userId, Long projectId);

}
