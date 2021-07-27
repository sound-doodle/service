package edu.cnm.deepdive.sounddoodleservice.model.dao;

import edu.cnm.deepdive.sounddoodleservice.model.entity.Project;
import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

  Iterable<Project> getAllByOrderByNameAsc ();

  Iterable<Project> findByCreatorAndTracksNotEmpty(User creator);
}
