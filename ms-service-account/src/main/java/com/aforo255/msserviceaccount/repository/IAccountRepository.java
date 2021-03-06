package com.aforo255.msserviceaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aforo255.msserviceaccount.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer>{

}
