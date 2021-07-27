package edu.cnm.deepdive.sounddoodleservice.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity
public class SoundSample {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "sound_sample_id", nullable = false, updatable = false)
  private Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @NonNull
  private Date timeStamp;

  @Enumerated(EnumType.ORDINAL)
  @NonNull
  private SampleType sampleType;

  @Column(nullable = false, updatable = false)
  @NonNull
  private String sampleFile;

  @Column(nullable = true, updatable = false)
  @NonNull
  private String sampleName;


  public Long getId() {
    return id;
  }

  @NonNull
  public Date getTimeStamp() {
    return timeStamp;
  }

  @NonNull
  public SampleType getSampleType() {
    return sampleType;
  }

  public void setSampleType(
      @NonNull SampleType sampleType) {
    this.sampleType = sampleType;
  }

  @NonNull
  public String getSampleFile() {
    return sampleFile;
  }

  public void setSampleFile(@NonNull String sampleFile) {
    this.sampleFile = sampleFile;
  }

  @NonNull
  public String getSampleName() {
    return sampleName;
  }

  public void setSampleName(@NonNull String sampleName) {
    this.sampleName = sampleName;
  }

  public enum SampleType {
    DRUM, KEYBOARD
  }

}
