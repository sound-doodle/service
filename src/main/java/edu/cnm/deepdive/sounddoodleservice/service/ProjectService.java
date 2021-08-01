package edu.cnm.deepdive.sounddoodleservice.service;

import edu.cnm.deepdive.sounddoodleservice.model.dao.ProjectRepository;
import edu.cnm.deepdive.sounddoodleservice.model.entity.Project;
import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import java.util.Optional;
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
    return repository.save(project);
  }

  public Iterable<Project> getAvailableProjects(User user) {
    return user.getProjectsCreated();

  }

  public Optional<Project> get(long id, User user) {
    return repository
        .findById(id)
        .map((project) -> (project.getCreator().getId().equals(user.getId())) ? project : null);
  }

  public void delete(long id, User user) {
    repository
        .findById(id)
        .map((project) -> (project.getCreator().getId().equals(user.getId())) ? project : null)
        .ifPresent(repository::delete);
  }
}
