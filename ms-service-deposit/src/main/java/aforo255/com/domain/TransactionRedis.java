package aforo255.com.domain;

import java.io.Serializable;
public class TransactionRedis implements Serializable {	
	private static final long serialVersionUID = 1L;
	private String  id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	private double amount ; 
	private String type ;	
	private Integer accountId ; 
}
