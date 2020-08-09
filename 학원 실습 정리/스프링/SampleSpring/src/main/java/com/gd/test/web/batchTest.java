package com.gd.test.web;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class batchTest {
	
	@Scheduled(cron = "0 0 * * * *")
	public void batchTest1() {
		System.out.println("배치프로그램 구동중");
	}
	
}
