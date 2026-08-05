package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.utility.ConfigManager;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	
	private int count=0;
	private final static int MAX_ATTEMPT= Integer.valueOf(ConfigManager.getProperty("MAX_ATTEMPT"));
	

	@Override
	public boolean retry(ITestResult result) {
		
		  System.out.println("Retry called for: "
		            + result.getMethod().getMethodName()
		            + " count=" + count);
		
		if(count<MAX_ATTEMPT) {
			count++;
			return true;
			
		}
		
		return false;
	}

}
