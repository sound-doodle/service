package edu.cnm.deepdive.sounddoodleservice.model.service;

import edu.cnm.deepdive.sounddoodleservice.model.dao.UserRepository;
import edu.cnm.deepdive.sounddoodleservice.model.entity.User;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class UserService implements Converter<Jwt, UsernamePasswordAuthenticationToken> {

  private final UserRepository repository;

  /**
   * Initializes service with an instance of {@link UserRepository}.
   * @param repository Provider of CRUD operations for {@link User} entities.
   */
  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  /**
   * Searches for a user by oauthkey and creates user if none exists.
   * @param oauthKey Unique Open ID Identifier
   * @param userName Display name provided from the authetication provider
   * @return Retrieved or new created user
   */
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

  /**
   * Exchanges a validated {@link Jwt} for a {@link UsernamePasswordAuthenticationToken} containing
   * an instance of user.
   * @param jwt Decrypted ID Token from authentication provider.
   * @return Created token containing user instance.
   */
  @Override
  public UsernamePasswordAuthenticationToken convert(Jwt jwt) {
    Collection<SimpleGrantedAuthority> grants = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    return new UsernamePasswordAuthenticationToken(
        getOrCreate(jwt.getSubject(), jwt.getClaim("name")), jwt.getTokenValue(), grants);
      }
}
