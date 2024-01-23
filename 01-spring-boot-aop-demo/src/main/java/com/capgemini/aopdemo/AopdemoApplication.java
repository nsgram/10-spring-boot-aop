package com.capgemini.aopdemo;

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
			demoTheBeforeAdvice(dao,memberShipDAO);
		};
	}
	
	private void demoTheBeforeAdvice(AccountDAO dao, MemberShipDAO memberShipDAO){
		
		//call the business method
		dao.addAccount();
		System.out.println("-------");
		memberShipDAO.addAccount();
		System.out.println("--------------");
		dao.addAccountDetails(new Account(),true);
		System.out.println("------------");
		dao.doWork();
		
	}
}
