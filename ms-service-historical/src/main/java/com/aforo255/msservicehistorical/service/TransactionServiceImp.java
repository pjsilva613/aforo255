package com.aforo255.msservicehistorical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.msservicehistorical.entity.Transaction;
import com.aforo255.msservicehistorical.repository.TransactionRepository;

@Service
public class TransactionServiceImp implements ITransactionService {


	@Autowired
	TransactionRepository transactionRepository ;
	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionRepository.save(transaction);
	}

	@Override
	public Iterable<Transaction> findByAccountId(Integer accountId) {
		// TODO Auto-generated method stub
		return transactionRepository.findByAccountId(accountId);
	}

	@Override
	public Iterable<Transaction> findAll() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
	}



}
