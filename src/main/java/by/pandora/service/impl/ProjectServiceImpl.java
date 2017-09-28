package by.pandora.service.impl;

import by.pandora.exception.ServiceException;
import by.pandora.model.*;
import by.pandora.repository.*;
import by.pandora.security.SecurityUser;
import by.pandora.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    private void update(Project project) {
        projectRepository.save(project);
    }

    private Project save(Project project) {
        project.setCreatingDate(new Date());
        return projectRepository.save(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project findFullById(Long id) {
        return initFull(projectRepository.findById(id));
    }

    @Override
    public Project findForMainById(Long id) {
        return initForMain(projectRepository.findById(id));
    }

    @Override
    public List<Objective> findProjectObjectivesById(Long id) {
        return objectiveRepository.findObjectivesByProjectId(id);
    }

    @Override
    public List<Comment> findProjectCommentsById(Long id) {
        return commentRepository.findCommentsByProjectId(id);
    }

    @Override
    public List<Objective> findProjectMinObjectivesById(Long id) {
        return objectiveRepository.findMinObjectivesByProjectId(id);
    }

    @Override
    public Double findProjectRatingById(Long id) {
        return markRepository.findAvgMarksByProjectId(id);
    }


    @Override
    public List<Project> findProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> findActiveProjectsAscFinishDate() {
        return projectRepository.findActiveProjectsAscFinishDate();
    }

    @Override
    public List<Project> findActiveProjectsAscFinishDateForMain() {
        return initListForMain(projectRepository.findActiveProjectsAscFinishDate());
    }

    @Override
    public List<Project> findActiveProjectsAscCreatingDateForMain() {
        return initListForMain(projectRepository.findActiveProjectsAscCreatingDate());
    }

    @Override
    public List<Project> findActiveProjectsByCreatorId(Long id) {
        return projectRepository.findActiveProjectsByCreatorId(id);
    }

    @Override
    public List<Project> findProjectsByCreatorIdForMain(Long id) {
        return initListForMain(projectRepository.findProjectsByCreatorId(id));
    }

    @Override
    public Project findProjectByObjectiveId(Long id) {
        return initForMain(projectRepository.findOne(objectiveRepository.findProjectIdByObjectiveId(id)));
    }

    @Override
    public Objective findObjectiveByObjectiveId(Long id) {
        return (objectiveRepository.findOne(id));
    }


    @Override
    public byte[] findPictureById(Long id) {
        return projectRepository.findPictureById(id);
    }

    @Override
    public void updateProjectPictureById(Long projectId, byte[] picture) {
        Project project = findById(projectId);
        project.setPicture(picture);
        update(project);
    }

    @Override
    @Transactional
    public void addProject(Project project) throws ServiceException {
        if (project.getObjectives() == null || project.getObjectives().isEmpty()) {
            throw new ServiceException("The project must have at least one objective.");
        }
        if (project.getCreatorId() == null) {
            throw new ServiceException("The project must have a creator.");
        }
        Project newProject = save(project);
        Iterator<Objective> obj = project.getObjectives().iterator();
        while (obj.hasNext()) {
            addObjective(obj.next(), newProject.getId());
        }
    }

    @Override
    @Transactional
    public void addProject(Project project, Principal principal) throws ServiceException {
        if (project.getObjectives() == null || project.getObjectives().isEmpty()) {
            throw new ServiceException("The project must have at least one objective.");
        }
        if (principal == null) {
            throw new ServiceException("The project must have a creator.");
        }
        project.setCreatorId(userRepository.findIdByUsername(principal.getName()));
        Project newProject = save(project);
        Iterator<Objective> obj = project.getObjectives().iterator();
        while (obj.hasNext()) {
            addObjective(obj.next(), newProject.getId());
        }
    }

    @Override
    @Transactional
    public void addObjective(Objective objective, Long projectId) {
        objective.setProjectId(projectId);
        objectiveRepository.save(objective);
    }

    @Override
    @Transactional
    public void addComment(Comment comment, Long projectId) {
        comment.setProjectId(projectId);
        comment.setCreatingTime(Timestamp.valueOf(LocalDateTime.now()));
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void addMark(Integer value, Long userId, Long projectId) {
        markRepository.save(new Mark(value, userId, projectId));
        Double rating = markRepository.findAvgMarksByProjectId(projectId);
        Project project = findById(projectId);
        project.setRating(rating);
        projectRepository.save(project);
    }

    @Override
    @Transactional
    public void addMark(Integer value, Principal principal, Long projectId) {
        Long userId = ((SecurityUser)((UsernamePasswordAuthenticationToken)principal).getPrincipal()).getUserId();
        markRepository.save(new Mark(value, userId, projectId));
        Double rating = markRepository.findAvgMarksByProjectId(projectId);
        Project project = findById(projectId);
        project.setRating(rating);
        projectRepository.save(project);
    }

    @Override
    @Transactional
    public void addSubscriptionStateDependent(SubscriptionStatus status, Long userId, Long projectId) {
        Subscription subscription = subscriptionRepository.findNewsSubcsrByUserAbdProject(userId, projectId);
        if (subscription == null) {
            subscriptionRepository.save(new Subscription(status, userId, projectId));
        } else {
            subscriptionRepository.delete(subscription);
        }
    }

    @Override
    @Transactional
    public void addSubscriptionStateDependent(SubscriptionStatus status, Principal principal, Long projectId) {
        Long userId = userRepository.findIdByUsername(principal.getName());
        Subscription subscription = subscriptionRepository.findNewsSubcsrByUserAbdProject(userId, projectId);
        if (subscription == null) {
            subscriptionRepository.save(new Subscription(status, userId, projectId));
        } else {
            subscriptionRepository.delete(subscription);
        }
    }

    @Override
    @Transactional
    public void addPayment(Long objectiveId, Double amount) {
        Objective objective = objectiveRepository.findOne(objectiveId);
        objective.setBalance(objective.getBalance() + Math.abs(amount));
        objectiveRepository.save(objective);
    }

    private Project initForMain(Project project) {
        Long id = project.getId();
        project.setObjectives(objectiveRepository.findObjectivesByProjectId(id));
        project.setCreator(userRepository.findOne(project.getCreatorId()));
        project.setRating(markRepository.findAvgMarksByProjectId(id));
        project.setBalance(objectiveRepository.findProjectBalanceByProjectId(id));
        project.setPrice(objectiveRepository.findProjectPriceByProjectId(id));
        return project;
    }

    private Project initFull(Project project) {
        Long id = project.getId();
        project.setObjectives(objectiveRepository.findObjectivesByProjectId(id));
        project.setComments(commentRepository.findCommentsByProjectId(id));
        project.setRating(markRepository.findAvgMarksByProjectId(id));
        project.setCreator(userRepository.findOne(project.getCreatorId()));
        project.setSubscriptions(subscriptionRepository.findSubscriptionUserIdListByProjectId(id));
        project.setMarks(markRepository.findMarkUserIdListByProjectId(id));
        project.setBalance(objectiveRepository.findProjectBalanceByProjectId(id));
        project.setPrice(objectiveRepository.findProjectPriceByProjectId(id));
        return project;
    }

    private List<Project> initListForMain(List<Project> projects) {
        Iterator<Project> it = projects.iterator();
        while (it.hasNext()) {
            initForMain(it.next());
        }
        return projects;
    }
}
