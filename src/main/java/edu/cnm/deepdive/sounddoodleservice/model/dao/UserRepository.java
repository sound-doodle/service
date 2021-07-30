package edu.cnm.deepdive.sounddoodleservice.model.dao;

import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is the User Repository to persist the User entity into the database.
 */
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findFirstByOauthKey(String oauthKey);


}
