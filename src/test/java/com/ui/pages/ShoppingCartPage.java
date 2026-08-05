package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By PROCEED_TO_CHECKOUT_LOCATOR = By
			.xpath("//p[contains(@class,'cart_navigation clearfix')]/a[@title='Proceed to checkout']");
	
	
	
	public ConfirmAddressPage goToConfirmAddressPage() {
		clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
		ConfirmAddressPage confirmAddress= new ConfirmAddressPage(getDriver());
		return confirmAddress;
	}

}
