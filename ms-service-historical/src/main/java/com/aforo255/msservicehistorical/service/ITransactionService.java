package com.aforo255.msservicehistorical.service;

import com.aforo255.msservicehistorical.entity.Transaction;

public interface ITransactionService {
	public Transaction save (Transaction transaction);
	public Iterable<Transaction> findByAccountId (Integer accountId);
	public Iterable <Transaction> findAll();
}
