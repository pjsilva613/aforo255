package com.aforo255.msservicehistorical.listener;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Component;

import com.aforo255.msservicehistorical.service.TransactionEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class ConsumerListener {

	@Autowired
	private TransactionEvents transactionEvents ;
	private Logger log = LoggerFactory.getLogger(ConsumerListener.class);
	@KafkaListener(topics = {"transaction-events"})
	public void OnMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		log.info("*************** MICROSERVICE HISOTORICAL *******************");
		log.info("ConsumerRecord : {}", consumerRecord.value());
		transactionEvents.processTransactionEvent(consumerRecord);
		
	}
	
}
