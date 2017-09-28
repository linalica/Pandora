package by.pandora.repository;

import by.pandora.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

@Repository
@RepositoryRestResource(path = "projects", collectionResourceRel = "projects")
public interface ProjectRepository extends JpaRepository<Project, Long>{

    Project findById(Long id);

    @Query(value = "from Project as p where p.creatorId = :id")
    List<Project> findProjectsByCreatorId(@Param("id") Long id);

    @Query(value = "from Project as p where p.creatorId = :id and p.status = 'ACTIVE'")
    List<Project> findActiveProjectsByCreatorId(@Param("id") Long id);

    @Query(value = "from Project as p where p.status = 'ACTIVE'")
    List<Project> findActiveProjects();

    @Query(value = "from Project as p where p.status = 'ACTIVE' order by p.finishDate desc")
    List<Project> findActiveProjectsDescFinishDate();

    @Query(value = "from Project as p where p.status = 'ACTIVE' order by p.finishDate asc")
    List<Project> findActiveProjectsAscFinishDate();

    @Query(value = "from Project as p where p.status = 'ACTIVE' order by p.creatingDate desc")
    List<Project> findActiveProjectsDescCreatingDate();

    @Query(value = "from Project as p where p.status = 'ACTIVE' order by p.creatingDate asc")
    List<Project> findActiveProjectsAscCreatingDate();

    @Query(value = "from Project as p where p.status = 'ACTIVE' order by p.rating desc")
    List<Project> findActiveProjectsDescRating();

    @Query(value = "from Project as p where p.status = 'ACTIVE' order by p.rating asc")
    List<Project> findActiveProjectsAscRating();

    @Query(value = "select p.picture from Project as p where p.id = :id")
    byte[] findPictureById(@Param("id") Long id);



    /*@Modifying
@Query("update User u set u.firstname = ?1 where u.lastname = ?2")
int setFixedFirstnameFor(String firstname, String lastname);*/

}
