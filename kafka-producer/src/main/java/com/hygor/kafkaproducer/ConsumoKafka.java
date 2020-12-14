package com.hygor.kafkaproducer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumoKafka {

	public static void main(String[] args) {
		
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); //Pegar todos os registros mesmo os anteriores
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		
		consumer.subscribe(Arrays.asList("testejava"));
		
		ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1)); 
		
		for (ConsumerRecord<String, String> record : records) {
			System.out.println(record.value());
		}
		
		consumer.close();
		
		System.out.println("Fim");
	}
}
