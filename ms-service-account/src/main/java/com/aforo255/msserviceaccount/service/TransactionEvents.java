package com.aforo255.msserviceaccount.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.msserviceaccount.entity.Account;
import com.aforo255.msserviceaccount.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class TransactionEvents {

	@Autowired
	private IAccountService accountService;
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord ) throws JsonMappingException, JsonProcessingException {
		double newAmount = 0 ; 
		Account account = new Account();
		Transaction event = objectMapper.readValue(consumerRecord.value(), Transaction.class) ;
		
		account=accountService.findById(event.getAccountId());
		switch(event.getType()) {
		
		case "deposito":
			newAmount= account.getTotalAmount() + event.getAmount();
			break ;
			
		case "retiro":		
			newAmount= account.getTotalAmount() - event.getAmount();
			break ;	
		}
		
		account.setTotalAmount(newAmount);
		log.info("Actualizando N° cuenta ******"+ event.getAccountId());
		accountService.save(account);	
		
	}
	
}
