Project Prerequisites ::
Apache Kafka - 10.2.0
Spring Kafka - 1.2.0.RELEASE
Spring Version - 1.5.3.RELEASE

Steps to setup ::
1. Download Apache Kafka version 10.2.0 and run zookeeper and Kafka server
2. Create Kafka queues defined in project (testIn)
3. Ensure that application-dev.properties should have the desired topic name (testIn)
4. If you want to change the topic name, please update the same on application-dev.properties
5. Run the application, the Junit execution will send a message to local Kafka Topic & consume the same. 


