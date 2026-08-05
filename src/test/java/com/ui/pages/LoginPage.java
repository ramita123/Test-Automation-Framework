package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

import io.qameta.allure.Step;

public class LoginPage extends BrowserUtility {
	static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	static final By EROOR_MESSAGE_LOCATOR=By.xpath("//div[contains(@class,'alert-danger')]/ol/li");

	
	
	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}


	@Step("Enter emailAddress on Login Page: {emailAddress} ")
	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}
	
	
	public LoginPage doLoginWithInvalidUser(String emailAddress, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		LoginPage loginPage= new LoginPage(getDriver());
		return loginPage;
	}
	
	
	public String errorMessage() {
		return getVisibleText(EROOR_MESSAGE_LOCATOR);
	}

}
