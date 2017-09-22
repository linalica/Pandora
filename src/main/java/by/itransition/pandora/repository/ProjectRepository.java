package by.itransition.pandora.repository;

import by.itransition.pandora.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

@Repository
@RepositoryRestResource(path = "projects", collectionResourceRel = "projects")
public interface ProjectRepository extends JpaRepository<Project, Long>{

    Project findById(Long id);

}
