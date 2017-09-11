package by.itransition.pandora.repository;

import by.itransition.pandora.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

@Repository
@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    /*@Modifying
    @Query("UPDATE User u SET u.user_last_login_time = ?1 WHERE u.user_id = ?2")
    void updateLastLoginTimeByUsername(Timestamp lastLoginTime, String username);*/

}
