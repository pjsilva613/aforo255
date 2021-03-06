package aforo255.com.service;

import java.util.Map;

import aforo255.com.domain.Transaction;
import aforo255.com.domain.TransactionRedis;

public interface ITransactionService {
	public Transaction save(Transaction transaction);

	// Metodos Redis
	public TransactionRedis findByIdRedis(String id);

	public void save(TransactionRedis transaction);

	public Map<String, TransactionRedis> findAll();
}
