package by.pandora.service;


import by.pandora.exception.ServiceException;
import by.pandora.model.*;

import java.security.Principal;
import java.util.List;

/**
 * Service class for {@link User}
 *
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

public interface ProjectService {

    Project findById(Long id);

    Project findFullById(Long id);

    List<Objective> findProjectObjectivesById(Long id);

    List<Comment> findProjectCommentsById(Long id);

    List<Objective> findProjectMinObjectivesById(Long id);

    Double findProjectRatingById(Long id);

    List<Project> findActiveProjectsAscFinishDate();

    List<Project> findActiveProjectsByCreatorId(Long id);

    List<Project> findProjectsByCreatorIdForMain(Long id);

    List<Project> findActiveProjectsAscFinishDateForMain();

    List<Project> findActiveProjectsAscCreatingDateForMain();

    Project findProjectByObjectiveId(Long id);

    Objective findObjectiveByObjectiveId(Long id);

    List<Project> findProjects();

    byte[] findPictureById(Long id);

    Project findForMainById(Long id);

    void updateProjectPictureById(Long projectId, byte[] picture);

    void addProject(Project project) throws ServiceException;

    void addProject(Project project, Principal principal) throws ServiceException;

    void addObjective(Objective objective, Long projectId);

    void addComment(Comment comment, Long projectId);

    void addMark(Integer value, Long userId, Long projectId);

    void addMark(Integer value, Principal principal, Long projectId);

    void addSubscriptionStateDependent(SubscriptionStatus status, Long userId, Long projectId);

    void addSubscriptionStateDependent(SubscriptionStatus status, Principal principal, Long projectId);

    void addPayment(Long objectiveId, Double amount);
}
