package aforo255.com.dao;

import org.springframework.data.repository.CrudRepository;

import aforo255.com.domain.Transaction;

public interface ITransactionDao  extends CrudRepository<Transaction, Integer>{

}
