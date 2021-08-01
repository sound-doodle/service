package edu.cnm.deepdive.sounddoodleservice.service;

import edu.cnm.deepdive.sounddoodleservice.model.dao.SampleRepository;
import edu.cnm.deepdive.sounddoodleservice.model.entity.Project;
import edu.cnm.deepdive.sounddoodleservice.model.entity.Sample;
import edu.cnm.deepdive.sounddoodleservice.model.entity.Sample.SampleType;
import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

  private final SampleRepository repository;

  @Autowired
  public SampleService(SampleRepository repository) {
    this.repository = repository;
  }

  public Sample start(Sample sample, User user) {
    sample.setName(sample.getName());
    return repository.save(sample);
  }

  public Iterable<Project> getAvailableProjects(User user) {
    return user.getProjectsCreated();

  }

  public Optional<Sample> get(long id) {
    return repository
        .findById(id);
  }

  public void delete(long id, User user) {
    repository
        .deleteById(id);

  }

}
