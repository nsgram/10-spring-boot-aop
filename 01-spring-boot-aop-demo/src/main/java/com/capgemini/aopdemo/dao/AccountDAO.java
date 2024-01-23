package com.capgemini.aopdemo.dao;

import com.capgemini.aopdemo.Account;

public interface AccountDAO {
	
	void addAccount();
	void addAccountDetails(Account account,boolean vip);
	boolean doWork();

}
