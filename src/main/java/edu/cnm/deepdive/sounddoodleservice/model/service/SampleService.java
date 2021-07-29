package edu.cnm.deepdive.sounddoodleservice.model.service;

import edu.cnm.deepdive.sounddoodleservice.model.dao.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

  private final SampleRepository repository;

  @Autowired
  public SampleService(SampleRepository repository) {
    this.repository = repository;
  }
}
