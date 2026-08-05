package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import static com.utility.ConfigManager.*;

public final class  HomePage extends BrowserUtility {

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName,isHeadless);
		goToWebsite(getProperty("URL"));


	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(getProperty("URL"));


	}

	private final static By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

	public LoginPage goToLoginPage() {
	clickOn(SIGN_IN_LINK_LOCATOR);
	LoginPage loginPage= new LoginPage(getDriver());
	return loginPage;
	}

}
