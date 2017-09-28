package by.pandora.repository;

import by.pandora.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author Gulevich Ulyana
 * @author Ematinov Kirill
 * @version 1.0
 */

@Repository
@RepositoryRestResource(path = "registration", collectionResourceRel = "registration")
public interface RegistrationRepository extends JpaRepository<VerificationToken, Long>{

    @Query(value = "from VerificationToken as v where v.token = :token")
    VerificationToken findByToken(@Param("token") String token);

}
