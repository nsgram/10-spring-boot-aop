package com.capgemini.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capgemini.aopdemo.dao.AccountDAO;
import com.capgemini.aopdemo.dao.MemberShipDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO dao, MemberShipDAO memberShipDAO) {
		return runner -> {
			//demoTheBeforeAdvice(dao,memberShipDAO);
			demoTheAfterThrowingAdvice(dao);
		};
	}
	
	private void demoTheAfterThrowingAdvice(AccountDAO dao) {
		List<Account> theAccounts =  null;
				
		try {
			//add a booan flag to simulate exception
			boolean tripWire = true;
			theAccounts =dao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\n main app :: "+e);
		}		
				
				
		System.out.println("\n\nMain app :: demoTheAfterThrowingAdvice()");
		System.out.println("----------");
		System.out.println(theAccounts);
	}

	private void demoTheBeforeAdvice(AccountDAO dao, MemberShipDAO memberShipDAO){
		
		//call the business method
//		dao.addAccount();
//		System.out.println("-------");
//		memberShipDAO.addAccount();
//		System.out.println("--------------");
//		dao.addAccountDetails(new Account("test","test"),true);
//		System.out.println("------------");
//		dao.doWork();
//		System.out.println("------------");
//		dao.getName();
//		dao.setName("tets");
//		dao.getServiceCode();
//		dao.setServiceCode("service_test");
//		System.out.println("-----------");
		
		List<Account> theAccounts =   dao.findAccounts();
		System.out.println("Main app =====");
		System.out.println("\n\n"+theAccounts);
	}
}
