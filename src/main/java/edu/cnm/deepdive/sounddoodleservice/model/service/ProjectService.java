package edu.cnm.deepdive.sounddoodleservice.model.service;

import edu.cnm.deepdive.sounddoodleservice.model.dao.ProjectRepository;
import edu.cnm.deepdive.sounddoodleservice.model.entity.Project;
import edu.cnm.deepdive.sounddoodleservice.model.entity.Track;
import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

  private final ProjectRepository repository;

  @Autowired
  public ProjectService(ProjectRepository repository) {
    this.repository = repository;
  }

  public Project start(Project project, User user) {
    project.setCreator(user);
    List<Track> tracks = project.getTracks();
    return repository.save(project);
  }

  Stream<Project> getAvailableProjects (User user, String name) {
    return repository.findAll(user, name);


  }
}
