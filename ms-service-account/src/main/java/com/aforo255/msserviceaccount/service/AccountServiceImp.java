package com.aforo255.msserviceaccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.msserviceaccount.entity.Account;
import com.aforo255.msserviceaccount.repository.IAccountRepository;

@Service
public class AccountServiceImp implements IAccountService{

	@Autowired
	IAccountRepository iAccountRepository;
	
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return iAccountRepository.findAll();
	}

	@Override
	public Account findById(Integer id) {
		// TODO Auto-generated method stub
		return iAccountRepository.findById(id).orElse(null);
	}

	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return iAccountRepository.save(account);
	}

}
