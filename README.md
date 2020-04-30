# Kafka Producer - CASESOURCE
This readme describes the installation and configuration of the CASESOURCE producer.
This producer is a stand-alone springboot application that publishes the information to the Kafka topic.

# TECH
- Apache Zookeeper - an open-source server which enables highly reliable distributed coordination
- Apache Kafka - a high-throughput distributed messaging system
- Java 1.8 or higher
- Lombok

## Prerequisites - Installing Kafka
- download the kafka 2.5.0 release binaries and un-tar it:

  ```shell
  tar -xzf kafka_2.12-2.5.0.tgz
  cd kafka_2.12-2.5.0
  ```
  
- Kafka uses ZooKeeper so you need to first start a ZooKeeper server if you don't already have one:
  
  ```shell
  cd bin\windows
  zookeeper-server-start.bat config\zookeeper.properties
  ```
  
- Start a Kafka broker by running the following command in a new terminal:
  
   ```shell
   cd bin\windows
   kafka-server-start.bat config\server.properties
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
 
 Alternatively, go to the root of the application where `build.gradle` is available:

```shell
gradle bootRun
```
 
 #### Check the produced messages
 
 ```shell
 cd bin\windows
 kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic "LENDING_UK_ACCOUNT_LOANS_PAYMENTMISS" --from-beginning
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

# Annotations in detail

- @SpringBootApplication:enable Java-based configuration, component scanning, and to enable the auto-configuration feature of        SpringBoot application.
- @Component:used to auto-detect and auto-configure beans using classpath scanning.
- @EnableBinding(Source.class):enables the binding of targets annotated with @OUTPUT to a broker.
- @Output(CASEOUT):used to identify output channels (for messages leaving the module).
- @InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedRate = "5000000")):
  configure the channel to which the adapter will feed its messages (in our case, Source.OUTPUT) and 
  poller is a component which helps the adapter poll the configured folder at the specified interval even if the last        invocation may still be running.
- @Data:it can generate getters and setters for the fields automatically.
- @AllArgsConstructor:generates a constructor with 1 parameter for each field in your class.
- @NoArgsConstructor:generate a constructor with no parameters.
- @ToString:it will print the class name, along with each field, in order, separated by commas.

# application.properties
- spring.cloud.stream.bindings.output.destination=LENDING_UK_ACCOUNT_LOANS_PAYMENTMISS:
Spring Cloud Stream applications connect to the broker through bindings, which link Spring Integration channels to broker destinations.

