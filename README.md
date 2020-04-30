# Kafka Producer - CASESOURCE
This readme describes the installation and configuration of the CASESOURCE producer.
This producer is a stand-alone springboot application that publishes the information to the Kafka topic.

# TECH
- Apache Zookeeper - an open-source server which enables highly reliable distributed coordination
- Apache Kafka - a high-throughput distributed messaging system
- Java 1.8 or higher

## Prerequisites - Installing Kafka
- download the kafka 2.5.0 release binaries and un-tar it:

  ```shell
  tar -xzf kafka_2.12-2.5.0.tgz
  cd kafka_2.12-2.5.0
  ```
  
- Kafka uses ZooKeeper so you need to first start a ZooKeeper server if you don't already have one:
  
  ```shell
  bin\windows\zookeeper-server-start.sh config\zookeeper.properties
  ```
  
- Start a Kafka broker by running the following command in a new terminal:
  
   ```shell
   bin\windows\kafka-server-start.sh config\server.properties
   ```

# Running the application in local
Follow the below steps to run the project in your machine

 - Clone the Git repository.
 
 ```shell
 git clone "https://github.com/sarpadhy/casesource.git".
 ```
 - import gradle project in your IDE.
   - File -> Import -> Existing gradle Project -> Navigate to the folder where you have cloned the project
   - Select the project
 - refresh gradle project.
 - run the spring boot application(CaseSourceApplication.java) to produce messages to topic      "LENDING_UK_ACCOUNT_LOANS_PAYMENTMISS".
 
 Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
 
 #### Check the produced messages
 Go to kafka "bin" or bin/windows folder depending on the OS and run
 ```shell
 ./kafka-console-consumer.sh --zookeeper localhost:2181/kafka --topic "LENDING_UK_ACCOUNT_LOANS_PAYMENTMISS" --from-beginning
 ```
 ## Files and Directories

The project has a particular directory structure. A representative project is shown below:

```
├── src
│   └── main
│       └── java
│           ├── com.example.demo
│             ├── CaseSource.java
│             ├── CaseSourceApplication.java
│             ├── CaseSourceData.java
├── src
│   └── main
│       └── resources
│           ├── application.properties
├── src
│   └── test
│       └── java
│           ├── com.example.demo
│             ├── CaseSourceApplicationTests.java
├── JRE System Library
├── External Dependencies
├── bin
├── src
├── build.gradle
├── gradlew
├── gradlew.bat
├── README.md
└── stale_outputs_checked
```
 
