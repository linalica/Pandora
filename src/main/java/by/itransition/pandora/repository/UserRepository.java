package by.itransition.pandora.repository;

import by.itransition.pandora.model.User;
import by.itransition.pandora.model.UserRole;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
=======
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
>>>>>>> new-start
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.List;
=======
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
>>>>>>> actual-database
=======
import java.security.Timestamp;
import java.util.List;
>>>>>>> new-start

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

@Repository
@RepositoryRestResource(path = "users", collectionResourceRel = "users")
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    /*@Modifying
    @Query("UPDATE User u SET u.user_last_login_time = ?1 WHERE u.user_id = ?2")
    void updateLastLoginTimeByUsername(Timestamp lastLoginTime, String username);*/

>>>>>>> actual-database
=======
public interface UserRepository extends JpaRepository<User, Long> /*, CrudRepository<User, Long>, JpaSpecificationExecutor<User> */{

    User findByUsername(String username);

    @Query(value = "select user.id from User as user where user.username = :username")
    Long findIdByUsername(@Param("username") String username);

    @Query(value = "select user.username from User as user where user.id = :id")
    String findUsernameById(@Param("id") Long id);

    @Query(value = "select user.role from User as user where user.username = :username")
    UserRole findRoleByUsername(@Param("username") String username);

    @Query(value = "select user.enabled from User as user where user.username = :username")
    Boolean findEnabledByUsername(@Param("username") String username);

    @Query(value = "select user.avatar from User as user where user.username = :username")
    byte[] findAvatarByUsername(@Param("username") String username);

    @Query(value = "select user.firstName from User as user where user.username = :username")
    String findFirstNameByUsername(@Param("username") String username);

    @Query(value = "select user.lastName from User as user where user.username = :username")
    String findLastNameByUsername(@Param("username") String username);

    @Query(value = "select user.passport from User as user where user.username = :username")
    byte[] findPassportByUsername(@Param("username") String username);

    @Query(value = "select user.birthday from User as user where user.username = :username")
    Timestamp findBirthdayByUsername(@Param("username") String username);

    @Query(value = "select user.creatingTime from User as user where user.username = :username")
    Timestamp findCreatingTimeByUsername(@Param("username") String username);

    @Query(value = "select user.lastLoginTime from User as user where user.username = :username")
    Timestamp findLastLoginTimeByUsername(@Param("username") String username);

    @Query(value = "select user.locale from User as user where user.username = :username")
    String findLocaleByUsername(@Param("username") String username);

    @Query(value = "select user.theme from User as user where user.username = :username")
    String findThemeByUsername(@Param("username") String username);


>>>>>>> new-start
}
