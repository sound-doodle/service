package edu.cnm.deepdive.sounddoodleservice.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;


@Entity
public class SongProject {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "project_id", nullable = false, updatable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date timeStamp;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @JoinColumn(name = "song_id", nullable = false, updatable = true)
  private Long songId;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  private User user;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @JoinColumn(name = "track_id", nullable = false, updatable = true)
  private Long track;

  public Long getId() {
    return id;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getSongId() {
    return songId;
  }

  public void setSongId(Long songId) {
    this.songId = songId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Long getTrack() {
    return track;
  }

  public void setTrack(Long track) {
    this.track = track;
  }
}
