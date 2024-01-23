package com.capgemini.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.capgemini.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount() {
		System.out.println(getClass() + " : Adding Account");
	}

	@Override
	public void addAccountDetails(Account account,boolean vip) {
		System.out.println(getClass() + " : addAccountDetails()");
		
	}

	@Override
	public boolean doWork() {
		System.out.println("Do some work");
		return false;
	}

}
