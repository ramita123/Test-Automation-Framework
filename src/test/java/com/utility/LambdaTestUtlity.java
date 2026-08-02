package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtlity {
	
	 public static final String HUBURL = "https://hub.lambdatest.com/wd/hub";
	 private static ThreadLocal<WebDriver> driverLocal= new ThreadLocal<WebDriver>();;
	 private static ThreadLocal<DesiredCapabilities> capabilitisLocal=new ThreadLocal<DesiredCapabilities>();

	 
	 
	 public static WebDriver intializeLambdaTestSession(String browser, String name) {

	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", browser);
	        capabilities.setCapability("browserVersion", "latest");
	        Map<String, Object> ltOptions = new HashMap<>();
	        ltOptions.put("user", "ramitasambyal");
	        ltOptions.put("accessKey", "2vTBjYqPHbeJtJVqe4F4rezQSwP9PRyTrC0t58RoxGv2ytMFUM");
	        ltOptions.put("build", "Selenium 4");
	        ltOptions.put("name", name);
	        ltOptions.put("platformName", "Windows 10");
	        ltOptions.put("seCdp", true);
	        ltOptions.put("selenium_version", "latest");
	        capabilities.setCapability("LT:Options", ltOptions);
	        capabilitisLocal.set(capabilities);
	        
	        WebDriver driver=null;
			try {
				driver = new RemoteWebDriver(new URL(HUBURL), capabilitisLocal.get());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        driverLocal.set(driver);

	       
	        System.out.println(driver);
	        return driverLocal.get();
	 }
	 
	 public static void quitSession() {
		 if(driverLocal.get()!=null) {
			 driverLocal.get().quit();
		 }
	 }
}
