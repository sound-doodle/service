package edu.cnm.deepdive.sounddoodleservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
/**
 * Encapuslates a user of the service.
 */
@Entity
@Table(
    name = "user_profile",
    indexes = {
        @Index(columnList = "created"),
        @Index(columnList = "connected")
    }
)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", nullable = false, updatable = false)
  private Long id;

  @Column(nullable = false, unique = true)
  @NonNull
  private String userName;

  @NonNull
  @Column(nullable = false, updatable = false, unique = true)
  private String oauthKey;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @NonNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date connected;

  @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY,
      cascade = {CascadeType.ALL})
  @NonNull
  @JsonIgnore
  private final List<Track> tracksCreated = new LinkedList<>();

  @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY,
      cascade = {CascadeType.ALL})
  @OrderBy("name ASC")
  @NonNull
  @JsonIgnore
  private final List<Project> projectsCreated = new LinkedList<>();

  /**
   * Returns unique identifier of a user.
   * @return
   */
  public Long getId() {
    return id;
  }

  /**
   * Returns date of creation.
   * @return
   */
  @NonNull
  public Date getCreated() {
    return created;
  }

  @NonNull
  public String getUserName() {
    return userName;
  }

  /**
   * Returns Users user name.
   * @param userName
   */
  public void setUserName(@NonNull String userName) {
    this.userName = userName;
  }

  /**
   * Returns authentication oauth key of a user.
   * @return
   */
  @NonNull
  public String getOauthKey() {
    return oauthKey;
  }


  public void setOauthKey(@NonNull String oauthKey) {
    this.oauthKey = oauthKey;
  }

  /**
   * Returns the date/time user connects to service.
   * @return
   */
  @NonNull
  public Date getConnected() {
    return connected;
  }

  /**
   *
   * @param connected
   */
  public void setConnected(@NonNull Date connected) {
    this.connected = connected;
  }

  /**
   *
   * @return
   */
  @NonNull
  public List<Track> getTracksCreated() {
    return tracksCreated;
  }

  /**
   *
   * @return
   */
  @NonNull
  public List<Project> getProjectsCreated() {
    return projectsCreated;
  }
}
