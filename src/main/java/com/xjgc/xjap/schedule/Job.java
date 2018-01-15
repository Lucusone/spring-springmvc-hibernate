package com.xjgc.xjap.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Job {
	
	@Scheduled(fixedRate=5000)
	public void doJob1(){
		
		//System.out.println("DoJob 1");
	}
	
	@Scheduled(fixedDelay = 5000)
	public void doJob2(){
		
		//System.out.println("DoJob 2");
	}
	
	@Scheduled(cron = "0/5 25-35 17 * * ?")
	public void doJob3(){
		
		//System.out.println("DoJob 3");
	}
	
	@Scheduled(cron = "0 0 8 ? * 1-7")
	public void doJob4(){
		
		//System.out.println("DoJob 4");
	}
}
