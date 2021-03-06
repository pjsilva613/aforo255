package com.aforo255.msservicehistorical.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.aforo255.msservicehistorical.entity.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

	@Query("{'accountId':?0}")
	public Iterable<Transaction> findByAccountId(Integer accountId);
}
