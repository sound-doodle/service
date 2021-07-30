package edu.cnm.deepdive.sounddoodleservice.model.dao;

import edu.cnm.deepdive.sounddoodleservice.model.entity.Project;
import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * This is the Project Repository to persist the Project entity into the database.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

  Iterable<Project> getAllByOrderByNameAsc ();

  Iterable<Project> findByCreatorAndTracksNotEmpty(User creator);
}
