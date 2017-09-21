package by.itransition.pandora.repository;

import by.itransition.pandora.model.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

@Repository
@RepositoryRestResource(path = "objectives", collectionResourceRel = "objectives")
public interface ObjectiveRepository extends JpaRepository<Objective, Long>{

    @Query(value = "from Objective as objective where objective.projectId = :id")
    List<Objective> findObjectivesByProjectId(@Param("id") Long id);

    @Query(value = "from Objective as objective where objective.projectId = :id and objective.min = true")
    List<Objective> findMinObjectivesByProjectId(@Param("id") Long id);


}