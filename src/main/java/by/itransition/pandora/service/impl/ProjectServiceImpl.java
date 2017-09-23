package by.itransition.pandora.service.impl;

import by.itransition.pandora.model.Comment;
import by.itransition.pandora.model.Mark;
import by.itransition.pandora.model.Objective;
import by.itransition.pandora.model.Project;
import by.itransition.pandora.repository.CommentRepository;
import by.itransition.pandora.repository.MarkRepository;
import by.itransition.pandora.repository.ObjectiveRepository;
import by.itransition.pandora.repository.ProjectRepository;
import by.itransition.pandora.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @Override
    public void update(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void save(Project project) {
        project.setCreatingDate(Timestamp.valueOf(LocalDateTime.now()));
        projectRepository.save(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project findFullById(Long id) {
        Project project = projectRepository.findById(id);
        project.setObjectives(objectiveRepository.findObjectivesByProjectId(id));
        project.setComments(commentRepository.findCommentsByProjectId(id));
        project.setRating(markRepository.findAvgMarksByProjectId(id));
        return project;
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
        Mark mark = new Mark(value, userId, projectId);
        markRepository.save(mark);
    }
}
