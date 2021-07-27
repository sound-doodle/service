package edu.cnm.deepdive.sounddoodleservice.model.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity
public class Sample {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "sample_id", nullable = false, updatable = false)
  private Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @NonNull
  private Date created;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false, updatable = false)
  @NonNull
  private SampleType type;

  @Column(nullable = false, updatable = false)
  @NonNull
  private String file;

  @Column(nullable = false, updatable = false)
  @NonNull
  private String name;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
  @JoinTable(
      name = "sample_track",
      joinColumns = {
          @JoinColumn(name = "sample_id", nullable = false, updatable = false)
      },
      inverseJoinColumns = {
          @JoinColumn(name = "track_id", nullable = false, updatable = false)
      }
  )
  private final List<Track> tracks = new LinkedList<>();

  public Long getId() {
    return id;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  @NonNull
  public SampleType getType() {
    return type;
  }

  public void setType(
      @NonNull SampleType type) {
    this.type = type;
  }

  @NonNull
  public String getFile() {
    return file;
  }

  public void setFile(@NonNull String sampleFile) {
    this.file = sampleFile;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String sampleName) {
    this.name = sampleName;
  }

  public List<Track> getTracks() {
    return tracks;
  }

  public enum SampleType {
    DRUM, KEYBOARD
  }

}
