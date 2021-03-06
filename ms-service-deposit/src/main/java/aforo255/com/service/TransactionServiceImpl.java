package aforo255.com.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aforo255.com.dao.ITransactionDao;
import aforo255.com.dao.ITransactionRedis;
import aforo255.com.domain.Transaction;
import aforo255.com.domain.TransactionRedis;
@Service
public class TransactionServiceImpl implements ITransactionService {
	
	@Autowired
	private ITransactionDao transactionDao;
	@Autowired
	private ITransactionRedis transactionRedis ;  
	@Override
	@Transactional
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionDao.save(transaction);
	}

	@Override
	public TransactionRedis findByIdRedis(String id) {
		// TODO Auto-generated method stub
		return transactionRedis.findById(id);
	}

	@Override
	public void save(TransactionRedis transaction) {
		 transactionRedis.save(transaction);
		
	}

	@Override
	public Map<String, TransactionRedis> findAll() {
		// TODO Auto-generated method stub
		return transactionRedis.findAll();
	}

}
