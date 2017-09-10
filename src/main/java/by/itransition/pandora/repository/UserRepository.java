package by.itransition.pandora.repository;

import by.itransition.pandora.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
