package edu.cnm.deepdive.sounddoodleservice.model.dao;

import edu.cnm.deepdive.sounddoodleservice.model.entity.Track;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * This is the Track Repository to persist the Track entity into the database.
 */
public interface TrackRepository extends JpaRepository<Track, Long> {

    Optional<Track> findTrackByCreatedOrderByCreated(Date created);
}
