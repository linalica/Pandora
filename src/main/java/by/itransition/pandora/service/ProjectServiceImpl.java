package by.itransition.pandora.service;

import by.itransition.pandora.model.Project;
import by.itransition.pandora.repository.ObjectiveRepository;
import by.itransition.pandora.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gulevich Ulyana
 * @version 1.0
 */

@Service
public class ProjectServiceImpl implements  ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Override
    public void update(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project findFullById(Long id) {
        Project project = projectRepository.findById(id);
        //project.setObjectives(objectiveRepository.findObjectivesByProjectId(id));
        return projectRepository.findById(id);
    }
}
