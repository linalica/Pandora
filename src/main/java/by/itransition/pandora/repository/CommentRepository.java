package by.itransition.pandora.repository;

import by.itransition.pandora.model.Comment;
import by.itransition.pandora.model.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

@Repository
@RepositoryRestResource(path = "comments", collectionResourceRel = "comments")
public interface CommentRepository extends JpaRepository<Comment, Long>{

    @Query(value = "from Comment as comment where comment.projectId = :id")
    List<Comment> findCommentsByProjectId(@Param("id") Long id);

    @Query(value = "from Comment as comment where comment.userId = :id")
    List<Comment> findCommentsByUserId(@Param("id") Long id);

}
