package edu.cnm.deepdive.sounddoodleservice.model.dao;

import edu.cnm.deepdive.sounddoodleservice.model.entity.Sample;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * This is the Sample Repository to persist the Sample entity into the database.
 */
public interface SampleRepository extends JpaRepository<Sample, Long> {

  Optional<Sample> findSampleByIdOrderById (Long id);

}
