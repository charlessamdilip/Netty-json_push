package com.json_push.helper;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.json_push.protobuf.QueryProtobuf.Query;

public class KafkaHelper {
	private static KafkaHelper _instance = null;
	private KafkaProducer _producer;
	
	private static final Logger logger = Logger.getLogger(KafkaHelper.class.getName());
	private KafkaHelper() {
		_producer = null;
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
		setProducer(new KafkaProducer<>(props));
	}
	
	public static void pushProtobuf(Query queryProtobuf) throws Exception{
		if (null == _instance) {
			_instance = new KafkaHelper();
		}
	
		logger.info("Pushing to Kafka netty-queue1");
		_instance.getProducer().send(new ProducerRecord<String, byte[]>("netty-queue", queryProtobuf.toByteArray()));
	}
	
	private KafkaProducer getProducer() {
		return _producer;
	}

	private void setProducer(KafkaProducer _producer) {
		this._producer = _producer;
	}

}
