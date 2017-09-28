package by.pandora.repository;

import by.pandora.model.Subscription;
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
@RepositoryRestResource(path = "subscriptions", collectionResourceRel = "subscriptions")
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{

    @Query(value = "from Subscription as s where s.projectId = :id")
    List<Subscription> findSubscriptionsByProjectId(@Param("id") Long id);

    @Query(value = "from Subscription as s where s.userId = :userId and s.projectId = :projectId and s.status = 'NEWS'")
    Subscription findNewsSubcsrByUserAbdProject(@Param("userId") Long userId, @Param("projectId") Long projectId);

    @Query(value = "from Subscription as s where s.userId = :id")
    List<Subscription> findSubscriptionsByUserId(@Param("id") Long id);

    @Query(value = "select s.userId from Subscription as s where s.projectId = :id")
    List<Integer> findSubscriptionUserIdListByProjectId(@Param("id") Long id);




}
