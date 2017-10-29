import java.util.Properties;
import java.util.Arrays;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.json_push.protobuf.QueryProtobuf.Query;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class KafkaConsumerTest {
    public static void main(String[] args) throws Exception {
	Properties props = new Properties();
	props.put("bootstrap.servers", "localhost:9092");
	props.put("group.id", "test");
	props.put("enable.auto.commit", "true");
	props.put("auto.commit.interval.ms", "1000");
	props.put("session.timeout.ms", "30000");
	props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
	KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(props);
	consumer.subscribe(Arrays.asList(args[0]));
	while (true) {
	    ConsumerRecords<String, byte[]> records = consumer.poll(100);
	    for (ConsumerRecord<String, byte[]> record : records)
		System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(),
			Query.parseFrom(record.value()).toString());
	}
    }
}