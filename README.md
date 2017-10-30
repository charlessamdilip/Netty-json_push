# Netty-json_push

## Requirements 
* Netty [4.1.16](http://central.maven.org/maven2/io/netty/netty-all/4.1.16.Final/netty-all-4.1.16.Final.jar)
* Kafka [0.11.0.1](https://www.apache.org/dyn/closer.cgi?path=/kafka/0.11.0.1/kafka-0.11.0.1-src.tgz)
* Kafka-clients [0.11.0.1](http://central.maven.org/maven2/org/apache/kafka/kafka-clients/0.11.0.1/kafka-clients-0.11.0.1.jar)
* protobuf [3.4.0](https://github.com/google/protobuf/releases/tag/v3.4.0) (Compiler for the proto template)
* protobuf-java [3.4.0](http://central.maven.org/maven2/com/google/protobuf/protobuf-java/3.4.0/protobuf-java-3.4.0.jar)
* protobuf-util [3.4.0](http://central.maven.org/maven2/com/google/protobuf/protobuf-java-util/3.4.0/protobuf-java-util-3.4.0.jar)
* gson [2.8.2](http://central.maven.org/maven2/com/google/code/gson/gson/2.8.2/gson-2.8.2.jar) (Compiletime requirement by protobuf-util for JSON)
* sl4j-api [1.7.25](http://central.maven.org/maven2/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar) (Runtime requirement by kafka-clients)

## Build
* Build packages of protobuf in "com.json_push.template" into project src
  * Move to the project directory (netty-json_push)
  * execute `protoc --java_out=src template/proto/query.proto`
* Build the project with jars of netty-all-4.1.16.Final, kafka-clients-0.11.0.1, protobuf-java-3.4.0, protobuf-java-util-3.4.0, gson-2.8.2

## Maven Build
* To build a stand alone jar with all dependencies execute `mvn clean compile assembly:single`

## Start the server
* Run the project with "com.json_push.init.Server" with sl4j-api-1.7.25 jar in Xpath
### Using the jar
* Find the jar in [releases](https://github.com/charlessamdilip/Netty-json_push/releases)
* Excute the following `java -Xbootclasspath/a:<Directory_of_jar>/slf4j-api-1.7.25.jar  -jar netty-json_push.jar`
* Execute the maven jar directly `java -jar netty-json_push-0.0.1-jar-with-dependencies.jar` 

> NOTE
> ---
> * server starts at localhost:8080
> * Make sure started the kafka bootstrap:servers at localhost:9092(default kafka)
> * Protobuf are saved to Kafka Topic `netty-queue`(create topic `netty-queue` with required configuration in cmd)
> * Test Consumer available in test folder which will listen toe the `netty-queue`
> * Server accepts the query at the root "/" or "/index.html" via `GET` method only.
> * Server responds with http html response
