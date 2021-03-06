package aforo255.com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import aforo255.com.domain.Transaction;
import aforo255.com.domain.TransactionRedis;
import aforo255.com.producer.DepositEventProducer;
import aforo255.com.service.ITransactionService;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class DepositController {

	@Autowired
	private ITransactionService service;
	@Autowired
	DepositEventProducer eventProducer;
	private Logger log = LoggerFactory.getLogger(DepositController.class);
	
	@PostMapping("/v1/depositevent")
	public ResponseEntity<Transaction> postDepositEvent(@RequestBody Transaction transaction) throws JsonProcessingException {
		log.info("antes de transql");
		Transaction transql = service.save(transaction);
		log.info("despues de transql");
		log.info("antes de sendDepositEvent");
		eventProducer.sendDepositEvent(transql);
		log.info("despues de sendDepositEvent");
		return ResponseEntity.status(HttpStatus.CREATED).body(transql);
	}
	
	

	@GetMapping("/all")
	public Map<String , TransactionRedis> getAll(){		
		return service.findAll();
	}	
	
	
}
