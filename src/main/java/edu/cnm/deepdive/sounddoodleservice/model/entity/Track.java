package edu.cnm.deepdive.sounddoodleservice.model.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity
public class Track {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "track_id", nullable = false, updatable = false)
  private Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @NonNull
  private Date created;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "creator_id", nullable = false, updatable = false)
  @NonNull
  private User creator;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tracks")
  @OrderBy("name ASC")
  private final List<Sample> samples = new LinkedList<>();

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "project_id", nullable = false, updatable = false)
  @NonNull
  private Project project;

  public Long getId() {
    return id;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  @NonNull
  public User getCreator() {
    return creator;
  }

  public void setCreator(@NonNull User creator) {
    this.creator = creator;
  }

  public List<Sample> getSamples() {
    return samples;
  }

  @NonNull
  public Project getProject() {
    return project;
  }

  public void setProject(@NonNull Project project) {
    this.project = project;
  }

}
