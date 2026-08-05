package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pages.ProductDetailPage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {
	
	private MyAccountPage accountPage;
	private SearchResultPage searchResultPage;
	
	private static final String SEARCH_TERM="printed summer dresses";
	private static final int index=0;
	
	@BeforeMethod(description="user logs in to the application and saerches for the product")
	public void setUp() {
		accountPage=	homePage.goToLoginPage().doLoginWith("lucky@yopmail.com", "Ramita@Automation2026!X7");
		 searchResultPage=accountPage.searchTheProduct(SEARCH_TERM);
	}
	
	@Test(description="verif is logged in user able to place an order")
	public void testCheckout() {
		searchResultPage.clickOnTheProductAt(index).addItemToCart().goToConfirmAddressPage().goShippmentPage()
		.goToPaymentPage();
		
	}

}
