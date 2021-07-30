package edu.cnm.deepdive.sounddoodleservice.controller;

import edu.cnm.deepdive.sounddoodleservice.model.entity.Project;
import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import edu.cnm.deepdive.sounddoodleservice.model.service.ProjectService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * This will process the requests for the Project service class.
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

  private final ProjectService service;

  /**
   * Creates and instance of the Project service to start database requests.
   * @param service
   */
  @Autowired
  public ProjectController(ProjectService service) {
    this.service = service;
  }

  /**
   * This will return an authorized instance of project and post it to the database if authorization is earned.
   * @param project
   * @param auth
   * @return
   */
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Project> post(@RequestBody Project project, Authentication auth) {
    project = service.start(project, (User) auth.getPrincipal());
    URI location = WebMvcLinkBuilder
        .linkTo(
            WebMvcLinkBuilder
                .methodOn(ProjectController.class)
                .get(project.getId(), auth)
        )
        .toUri();
    return ResponseEntity.created(location).body(project);
  }

  /**
   * This will verify the authorization of the user and fetch requested project data from the database.
   * @param id
   * @param auth
   * @return
   */
  @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Project get(@PathVariable long id, Authentication auth) {
    return service
        .get(id, (User) auth.getPrincipal())
        .orElseThrow();
  }

  /**
   * This will allow the user to delete Projects from the database once authorization is verified.
   * @param id
   * @param auth
   */
  @DeleteMapping(value = "/{id:\\d+}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable long id, Authentication auth) {
    service
        .delete(id, (User) auth.getPrincipal());
  }
}
