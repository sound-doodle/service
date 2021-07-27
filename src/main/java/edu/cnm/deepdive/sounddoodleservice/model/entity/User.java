package edu.cnm.deepdive.sounddoodleservice.model.entity;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
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

  @OneToMany(mappedBy = "trackCreator", fetch = FetchType.LAZY,
      cascade = {CascadeType.ALL})
  @NonNull
  private final List<SongTrack> trackOriginated = new LinkedList<>();

  @OneToMany(mappedBy = "projectCreator", fetch = FetchType.LAZY,
      cascade = {CascadeType.ALL})
  @NonNull
  private final List<SongProject> projectOriginated = new LinkedList<>();

  @NonNull
  public Long getId() {
    return id;
  }

  @NonNull
  public String getUserName() {
    return userName;
  }

  @NonNull
  public void setUserName(String userName) {
    this.userName = userName;
  }

  @NonNull
  public String getOauthKey() {
    return oauthKey;
  }

  @NonNull
  public void setOauthKey(String oauthKey) {
    this.oauthKey = oauthKey;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  @NonNull
  public Date getConnected() {
    return connected;
  }

  public void setConnected(@NonNull Date connected) {
    this.connected = connected;
  }

  @NonNull
  public List<SongTrack> getTrackOriginated() {
    return trackOriginated;
  }

  @NonNull
  public List<SongProject> getProjectOriginated() {
    return projectOriginated;
  }
}
