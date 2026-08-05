package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {
	
	
	
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		
	}


	private static final By ADD_TO_CART_LOCATOR=By.xpath("//button[@name='Submit']");
	private static final By PROCEED_TO_CHECKOUT_LOCATOR	=By.xpath("//a[@title='Proceed to checkout']");
	
	
	public ShoppingCartPage addItemToCart() {
		clickOn(ADD_TO_CART_LOCATOR);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
		ShoppingCartPage shoppingCartPage= new ShoppingCartPage(getDriver());
		return shoppingCartPage;
	}

}
