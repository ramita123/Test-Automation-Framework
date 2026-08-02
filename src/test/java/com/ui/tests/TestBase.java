package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtlity;

public class TestBase {
	
	
	protected HomePage homePage;
	private boolean isLambda=true;
	
	private static final Logger LOGGER = LogManager.getLogger(LoginTest3.class);

	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "load  website's home page")
	public void setUp(@Optional ("chrome") String browser ,
			@Optional ("false")  boolean isLambdaTest, @Optional("true") boolean isHeadless,ITestResult result) {
		
		this.isLambda=isLambda;
		
		
		WebDriver lambdaDriver;
		if(isLambda) {
		lambdaDriver=	LambdaTestUtlity.intializeLambdaTestSession(browser, result.getMethod().getMethodName());
		homePage= new HomePage(lambdaDriver);
		}
		else {
		LOGGER.info("The home page of the website is loaded");
		homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
	}
	
	
	public BrowserUtility getInstance() {
		return homePage;
		
	}
	
	
	@AfterMethod()
	public void quitDriver() {
		if(isLambda) {
			LambdaTestUtlity.quitSession();
		}else {
		homePage.getDriver().quit();
		}
	}
	
	


}
