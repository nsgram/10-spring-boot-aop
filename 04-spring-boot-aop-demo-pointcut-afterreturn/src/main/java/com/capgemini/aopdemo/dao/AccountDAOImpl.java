package com.capgemini.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	private String name;
	
	private String serviceCode;

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

	public String getName() {
		System.out.println("getName()");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setName()");
	}

	public String getServiceCode() {
		System.out.println("getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
		System.out.println("setServiceCode()");
	}

	@Override
	public List<Account> findAccounts() {
		ArrayList<Account> accounts = new ArrayList<>();
		accounts.add(new Account("A", "a"));
		accounts.add(new Account("B", "b"));
		accounts.add(new Account("C", "c"));
		accounts.add(new Account("D", "d"));
		accounts.add(new Account("E", "e"));
		return accounts;
	}

	
}
