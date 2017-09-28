package by.pandora.repository;

import by.pandora.model.User;
import by.pandora.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

@Repository
@RepositoryRestResource(path = "users", collectionResourceRel = "users")
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

    @Query(value = "select user.avatar from User as user where user.id = :id")
    byte[] findAvatarById(@Param("id") Long id);

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


}
