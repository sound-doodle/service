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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

/**
 *  Encapsulates the Project of the service.
 */
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

  @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @NonNull
  @JsonIgnore
  private final List<Track> tracks = new LinkedList<>();

  /**
   *  Returns the unique ID of the Project.
   * @return
   */
  public Long getId() {
    return id;
  }

  /**
   * Returns the date the project is created.
   * @return
   */
  @NonNull
  public Date getCreated() {
    return created;
  }

  /**
   *  Returns the name of the Project.
   * @return
   */
  @NonNull
  public String getName() {
    return name;
  }

  /**
   *
   * @param name
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }

  /**
   *
   * @return
   */
  @NonNull
  public User getCreator() {
    return creator;
  }

  /**
   *
   * @param creator
   */
  public void setCreator(@NonNull User creator) {
    this.creator = creator;
  }

  /**
   *
   * @return
   */
  @NonNull
  public List<Track> getTracks() {
    return tracks;
  }
}
