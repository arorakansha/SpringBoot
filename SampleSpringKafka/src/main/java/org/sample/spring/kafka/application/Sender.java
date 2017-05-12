package org.sample.spring.kafka.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Class to send message to kafka Topic
 * @author akansha
 *
 */

@Component
public class Sender {
	
	  @Autowired
	  private KafkaTemplate<String, String> kafkaTemplate;

	  /**
	   * Method to send messages to kafka topic
	   * @param topic
	   * @param message
	   */
	  public void send(String topic, String message) {
		  
	    // the KafkaTemplate provides asynchronous send methods returning a Future
	    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

	    // register a callback with the listener to receive the result of the send asynchronously
	    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	      @Override
	      public void onSuccess(SendResult<String, String> result) {
	        System.out.println("sent message");
	      }

	      @Override
	      public void onFailure(Throwable ex) {
	        System.out.println("unable to send message");
	      }
	    });
	    
	  }

}
