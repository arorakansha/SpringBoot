package org.sample.spring.kafka.application;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Listener class for kafka Topics
 * @author akansha
 *
 */
@Component
public class Listener {
 
  private CountDownLatch latch = new CountDownLatch(1);
  
  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(id = "myConsumer", topics = "testIn")
  public void receive(String message) {
      System.out.println(message);
      latch.countDown();
  }
  
}
