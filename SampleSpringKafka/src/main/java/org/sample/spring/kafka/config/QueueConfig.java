package org.sample.spring.kafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Class to maintain the queue configs & read from properties
 * @author akansha
 *
 */
@Configuration
public class QueueConfig {
	
	/** The broker list. */
	  private final String brokerList;
	  
	  /** The Topic name. */
	  private final String in_topic;
	  
	  /** The bootStrapServers. */
	  private final String bootStrapServers;
	  
	  /** The auto commit. */
	  private final String autoCommit;

	  /** The auto commit interval in ms. */
	  private final String autoCommitIntervalInMs;

	  /** The max poll interval in ms. */
	  private final String maxPollIntervalInMs;

	  /** The session timeout in ms. */
	  private final String sessionTimeoutInMs;

	  /** The max poll records. */
	  private final String maxPollRecords;

	  /** The client id. */
	  private final String clientId;

	  /** The heartbeat interval ms. */
	  private final String heartbeatIntervalMs;
	  
	  
	  @Autowired
	  public QueueConfig(
	      
	      @Value("${kafka.in.brokerList}") final String brokerList,
	      @Value("${kafka.in.topicName}") final String in_topic,
	      @Value("${Kafka.in.bootstrap.servers}") final String bootStrapServers,
	      @Value("${kafka.in.enable.auto.commit}") final String autoCommit,
	      @Value("${kafka.in.auto.commit.interval.ms}") final String autoCommitIntervalInMs,
	      @Value("${kafka.in.max.poll.interval.ms}") final String maxPollIntervalInMs,
	      @Value("${kafka.in.session.timeout.ms}") final String sessionTimeoutInMs,
	      @Value("${kafka.in.max.poll.records}") final String maxPollRecords,
	      @Value("${kafka.in.client.id}") final String clientId,
	      @Value("${kafka.in.heartbeat.interval.ms}") final String heartbeatIntervalMs
	      ) {
	      this.brokerList = brokerList;
	      this.in_topic = in_topic;
	      this.bootStrapServers = bootStrapServers;
	      this.autoCommit = autoCommit;
	      this.autoCommitIntervalInMs = autoCommitIntervalInMs;
	      this.sessionTimeoutInMs = sessionTimeoutInMs;
	      this.maxPollIntervalInMs = maxPollIntervalInMs;
	      this.maxPollRecords = maxPollRecords;
	      this.clientId = clientId;
	      this.heartbeatIntervalMs = heartbeatIntervalMs;
	  }


	  /**
	   * @return the brokerList
	   */
	  public String getBrokerList() {
	    return brokerList;
	  }


	  /**
	   * @return the in_topic
	   */
	  public String getIn_topic() {
	    return in_topic;
	  }

	  
	  /**
	   * @return the bootStrapServers
	   */
	  public String getBootStrapServers() {
	    return bootStrapServers;
	  }


	  /**
	   * @return the autoCommit
	   */
	  public String getAutoCommit() {
	    return autoCommit;
	  }


	  /**
	   * @return the autoCommitIntervalInMs
	   */
	  public String getAutoCommitIntervalInMs() {
	    return autoCommitIntervalInMs;
	  }


	  /**
	   * @return the maxPollIntervalInMs
	   */
	  public String getMaxPollIntervalInMs() {
	    return maxPollIntervalInMs;
	  }


	  /**
	   * @return the sessionTimeoutInMs
	   */
	  public String getSessionTimeoutInMs() {
	    return sessionTimeoutInMs;
	  }


	  /**
	   * @return the maxPollRecords
	   */
	  public String getMaxPollRecords() {
	    return maxPollRecords;
	  }


	  /**
	   * @return the clientId
	   */
	  public String getClientId() {
	    return clientId;
	  }


	  /**
	   * @return the heartbeatIntervalMs
	   */
	  public String getHeartbeatIntervalMs() {
	    return heartbeatIntervalMs;
	  }
	  

}
