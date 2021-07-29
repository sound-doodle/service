package edu.cnm.deepdive.sounddoodleservice.model.service;

import edu.cnm.deepdive.sounddoodleservice.model.dao.TrackRepository;
import edu.cnm.deepdive.sounddoodleservice.model.entity.Project;
import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {

  private final TrackRepository repository;

  @Autowired
  public TrackService(TrackRepository repository) {
    this.repository = repository;
  }

  Stream<Project> getUserProjects(User user) {
    return repository.findAllById()
  }

}
