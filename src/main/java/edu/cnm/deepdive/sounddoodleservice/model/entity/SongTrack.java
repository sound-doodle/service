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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity
public class SongTrack {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "track_id", nullable = false, updatable = false)
  private Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @NonNull
  private Date timeStamp;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @JoinColumn(name = "sound_sample_id", nullable = false, updatable = false)
  private Long soundSampleId;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @NonNull
  private Date startTime;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @NonNull
  private Date endTime;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "track_creator_id", nullable = false, updatable = false)
  @NonNull
  private User trackCreator;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userTracks")
  @OrderBy("sampleName ASC")
  private final List<SoundSample> userSamples = new LinkedList<>();

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private SongProject songProject;

  public Long getId() {
    return id;
  }

  @NonNull
  public Date getTimeStamp() {
    return timeStamp;
  }

  @NonNull
  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(@NonNull Date startTime) {
    this.startTime = startTime;
  }

  @NonNull
  public Date getEndTime() {
    return endTime;
  }

  @NonNull
  public User getCreator() {
    return trackCreator;
  }

  public void setCreator(@NonNull User creator) {
    this.trackCreator = creator;
  }

  public void setEndTime(@NonNull Date endTime) {
    this.endTime = endTime;
  }

  public List<SoundSample> getUserSamples() {
    return userSamples;
  }

}
