package by.itransition.pandora.repository;

import by.itransition.pandora.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
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
@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRepository extends JpaRepository<User, Long>/*, CrudRepository<User, Long>, JpaSpecificationExecutor<User> */{

    User findByUsername(String username);

    @Query(value = "from User as user where user.id = 5")
    List<User> findInfo();

    @Query("select user.locale from User as user where user.username = :username")
    String findLocaleByUsername(@Param("username") String username);


    /*

    @Modifying
    //@NamedNativeQuery(value = ("update User u set u.user_last_login_time = ?1 where u.user_username = ?2"))
    void updateLastLoginTimeByUsername(Timestamp lastLoginTime, String username);
*/

    /*@Modifying
    @Query("update from User as user set user.locale = 'ru_RU' where user.id=3")
    void updateLocaleByUsername(*//*@Param("locale")*//* String locale, *//*@Param("username")*//*String username);
*/
}
