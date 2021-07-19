package edu.cnm.deepdive.sounddoodleservice.model.service;

import edu.cnm.deepdive.sounddoodleservice.model.dao.UserRepository;
import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repository;


  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User getOrCreate(String oauthKey, String userName) {
    return repository.findFirstByOauthKey(oauthKey)
        .map((user) -> {
          user.setConnected(new Date());
          return repository.save(user);
    })
    .orElseGet(() -> {
      User user = new User();
      user.setOauthKey(oauthKey);
      user.setUserName(userName);
      user.setConnected(new Date());
      return repository.save(user);
    });
  }


}
