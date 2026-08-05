package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class SearchProductTest extends TestBase {
	private MyAccountPage accountPage;
	private static final String SEARCH_TERM="printed summer dresses";
	
	@BeforeMethod(description="verify user logs in to the application")
	public void setUp() {
	 accountPage=	homePage.goToLoginPage().doLoginWith("paixiya360@biomails.com", "passowrd");
	}
	
	
	@Test(description="verify if logged in user is able to search the prodyc and correct products are displayed",groups= {"regression","smoke","e2e"})
	public void verifyProductSearchTest() {
		accountPage.searchTheProduct(SEARCH_TERM);
	}
	
	
	@Test(description="verify the product title is coming as per the search")
	public void verifySearchProductTitle() {
	boolean actualResults=	accountPage.searchTheProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResults, true);
	}
	
	
	
	

}
