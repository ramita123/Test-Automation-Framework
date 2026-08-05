package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippmentPage extends BrowserUtility {
	
	private static final By PROCEED_CHECKOUT_BUTTON_LOCATOR=By.xpath("//button[@name='processCarrier']");
	private static final By TERMS_CHECKBOX_LOCATOR=By.xpath("//input[@type='checkbox']");

	public ShippmentPage(WebDriver driver) {
	super(driver);
	}
	
	
	public PaymentPage goToPaymentPage() {
		clickOn(TERMS_CHECKBOX_LOCATOR);
		clickOn(PROCEED_CHECKOUT_BUTTON_LOCATOR);
		PaymentPage paymentPage=new PaymentPage(getDriver());
		return paymentPage;
	}
}
