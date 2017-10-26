# Netty-json_push

## Requirements 
* Netty [4.1.16](http://dl.bintray.com/netty/downloads/netty-4.1.16.Final.tar.bz2)
* Kafka [0.11.0.1](https://www.apache.org/dyn/closer.cgi?path=/kafka/0.11.0.1/kafka-0.11.0.1-src.tgz)
* Kafka-clients [0.11.0.1](http://central.maven.org/maven2/org/apache/kafka/kafka-clients/0.11.0.1/kafka-clients-0.11.0.1.jar)
* protobuf [3.4.0](https://github.com/google/protobuf/releases/tag/v3.4.0) (Compiler for the proto template)
* protobuf-java [3.4.0](https://mvnrepository.com/artifact/com.google.protobuf/protobuf-java/3.4.0) 


## Build
* Build packages of protobuf in "com.json_push.template" into project src
* Build the project with jars of Netty, Kafka-clients, protobuff

## Start the server
* Run the project with "com.json_push.init.Server"
