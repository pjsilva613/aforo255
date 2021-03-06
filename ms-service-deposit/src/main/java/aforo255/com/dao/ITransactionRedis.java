package aforo255.com.dao;

import java.util.Map;

import aforo255.com.domain.TransactionRedis;

public interface ITransactionRedis {
	void save (TransactionRedis transaction);
	 Map<String, TransactionRedis> findAll();
	 TransactionRedis findById(String id );
	 void update (TransactionRedis transaction);
	 void delete (String id );
}
