package by.itransition.pandora.repository;

import by.itransition.pandora.model.Mark;
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
@RepositoryRestResource(path = "rating", collectionResourceRel = "rating")
public interface MarkRepository extends JpaRepository<Mark, Long> {

    @Query(value = "from Mark as m where m.projectId = :id")
    List<Mark> findMarksByProjectId(@Param("id") Long id);

    @Query(value = "select avg(m.value) from Mark as m where m.projectId = :id")
    Double findAvgMarksByProjectId(@Param("id") Long id);
}
