package edu.cnm.deepdive.sounddoodleservice.controller;

import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * This will process the requests for the User service class.
 */
@RestController
@RequestMapping("/users")
public class UserController {

  /**
   *  This will verify the autherization status of the user and return the users verified status.
   * @param auth
   * @return
   */
  @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
  public User me(Authentication auth) {
    return (User) auth.getPrincipal();
  }
}
