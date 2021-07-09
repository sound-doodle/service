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

@Entity
public class SoundSample {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "sound_sample_id", nullable = false, updatable = false)
  private Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date timeStamp;

  @Enumerated(EnumType.ORDINAL)
  private Enum sampleType;
  public enum SampleType {
    DRUM, KEYBOARD
  }

  @Column(nullable = false, updatable = false)
  private String sampleFile;

  @Column(nullable = true, updatable = false)
  private String sampleName;


  public Long getId() {
    return id;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public Enum getSampleType() {
    return sampleType;
  }

  public void setSampleType(Enum sampleType) {
    this.sampleType = sampleType;
  }

  public String getSampleFile() {
    return sampleFile;
  }

  public void setSampleFile(String sampleFile) {
    this.sampleFile = sampleFile;
  }

  public String getSampleName() {
    return sampleName;
  }

  public void setSampleName(String sampleName) {
    this.sampleName = sampleName;
  }
}
