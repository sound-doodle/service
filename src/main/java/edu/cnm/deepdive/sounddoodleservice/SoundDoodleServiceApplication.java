package edu.cnm.deepdive.sounddoodleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The launcher activity for the server.
 */
@SpringBootApplication
public class SoundDoodleServiceApplication {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(SoundDoodleServiceApplication.class, args);
  }

}
