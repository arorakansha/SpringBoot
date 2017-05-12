package org.sample.spring.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

/**
 * Class to declare beans for Kafka Consumer 
 * @author akansha
 *
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {

  @Autowired
  private QueueConfig queueConfig;
  
  @Bean
  KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
      ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
      factory.setConsumerFactory(consumerFactory());
      factory.setConcurrency(3);
      factory.getContainerProperties().setPollTimeout(3000);
      return factory;
  }

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
      return new DefaultKafkaConsumerFactory<String, String>(consumerConfigs());
  }

  @Bean
  public Map<String, Object> consumerConfigs() {
      Map<String, Object> propsMap = new HashMap<String,Object>();
      propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, queueConfig.getBootStrapServers());
      propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, queueConfig.getAutoCommitIntervalInMs());
      propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, queueConfig.getAutoCommit());
      propsMap.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, queueConfig.getMaxPollIntervalInMs());
      propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, queueConfig.getMaxPollRecords());
      propsMap.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, queueConfig.getHeartbeatIntervalMs());
      return propsMap;
  }
  
}
