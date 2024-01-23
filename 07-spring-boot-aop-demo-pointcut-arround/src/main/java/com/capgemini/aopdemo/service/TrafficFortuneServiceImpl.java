package com.capgemini.aopdemo.service;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

	@Override
	public String getFortune() {
		// simulate a delay
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "Except heavy traffic this morning";
	}

	@Override
	public String getFortune(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("The mejor accident! highway is closed");
		}
			return getFortune();
	}

}
