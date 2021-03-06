package aforo255.com.dao;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import aforo255.com.domain.TransactionRedis;
@Repository
public class TransactionRedisDao implements ITransactionRedis {
	  @Autowired
		private RedisTemplate<String , TransactionRedis> redisTemplate ; 
	
	  private HashOperations hashOperations;
	    String key = "TRANSACTION";
	    @PostConstruct
	    private void init () {
	    	hashOperations= redisTemplate.opsForHash();
	    	
	    }
		@Override
		public void save(TransactionRedis transaction) {
			// TODO Auto-generated method stub
			hashOperations.put(key ,transaction.getId(), transaction);
		}

		@Override
		public Map<String, TransactionRedis> findAll() {
			// TODO Auto-generated method stub
			return hashOperations.entries(key);
		}

		@Override
		public TransactionRedis findById(String id) {
			// TODO Auto-generated method stub
			return (TransactionRedis) hashOperations.get(key, id);
		}

		@Override
		public void update(TransactionRedis transaction) {
			// TODO Auto-generated method stub
			save (transaction);
		}

		@Override
		public void delete(String id) {
			// TODO Auto-generated method stub
			hashOperations.delete(key, id);
		}
}
