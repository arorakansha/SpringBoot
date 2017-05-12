package org.sample.spring.kafka.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	Sender sender;
	
	@Autowired
	Listener listener;
	
	 @Test
	  public void testReceive() throws InterruptedException {
	    sender.send("testIn", "Hello test");
	    listener.getLatch().await(1000,TimeUnit.MILLISECONDS);
	    assertThat(listener.getLatch().getCount()).isEqualTo(0);
	  }

}
