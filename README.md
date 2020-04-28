# Kafka Producer - CASESOURCE
Kafka Producer - CASESOURCE is a springboot application to push events into a kafka topic

# Version
0.0.1-SNAPSHOT

# TECH
- Apache Zookeeper - an open-source server which enables highly reliable distributed coordination
- Apache Kafka - a high-throughput distributed messaging system


# Prerequisites
- https://kafka.apache.org/quickstart can be used for installing kafka
- Create the kafka topic "LENDING_UK_ACCOUNT_LOANS_PAYMENTMISS" (mentioned in application.properties in resources folder) where you will push your data

# Usage
The paragraph below assumes that kafka is running on the same machine (localhost) with default port (9092) and the topic name is "LENDING_UK_ACCOUNT_LOANS_PAYMENTMISS". These settings can be changed respectively in config files. Follow the below steps to run the project in your machine

 > git clone "https://github.com/sarpadhy/casesource.git"
 - import gradle project in any IDE
 - run gradle build
 - run the spring boot application(CaseSourceApplication.java) to produce messages to topic      "LENDING_UK_ACCOUNT_LOANS_PAYMENTMISS"
 
 #### Check the produced messages
 Go to kafka "bin" or bin/windows folder depending on the OS and run
 > ./kafka-console-consumer.sh --zookeeper localhost:2181/kafka --topic "LENDING_UK_ACCOUNT_LOANS_PAYMENTMISS" --from-beginning
 
 Again, this command assumes that:
 - Zookeeper is running on the same machine (localhost) with the default port (2181)
 
 

 
 
