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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;


@Entity
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "project_id", nullable = false, updatable = false)
  private Long id;

  @Column(nullable = false)
  @NonNull
  private String name;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @NonNull
  private Date created;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "creator_id", nullable = false, updatable = false)
  @NonNull
  private User creator;

  public Long getId() {
    return id;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public User getCreator() {
    return creator;
  }

  public void setCreator(@NonNull User creator) {
    this.creator = creator;
  }
}
