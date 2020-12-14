package com.hygor.vendaingressoskafka.serealizer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hygor.vendaingressoskafka.models.Venda;

public class VendaSerializer implements Serializer<Venda>{

	@Override
	public byte[] serialize(String topic, Venda venda) {
		try {
			return new ObjectMapper().writeValueAsBytes(venda);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
