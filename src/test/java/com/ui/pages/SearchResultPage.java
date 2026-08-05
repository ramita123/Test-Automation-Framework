package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By ALL_PRODCUST_LISTS_NAME = By.xpath(("//h5[@itemprop='name']/a"));

	private static final By PRODUCT_LISTING_LOCATOR = By.xpath("//span[@class='lighter']");

	public String getSearchProductTitle() {
		return getVisibleText(PRODUCT_LISTING_LOCATOR);

	}
	
	
	public boolean isSearchTermPresentInProductList(String SearchTerm) {
	List<String> keywords=	Arrays.asList(SearchTerm.toLowerCase().split(" "));
	List<String>productNameList	=getAllVisibleText(ALL_PRODCUST_LISTS_NAME);
	
boolean result=	productNameList.stream().anyMatch(name->keywords.stream().anyMatch(keyword->name.toLowerCase().contains(keyword)));
return result;
	
		
	}
	
	public ProductDetailPage clickOnTheProductAt(int index) {
	clickOn(getProductList(ALL_PRODCUST_LISTS_NAME).get(index));
	ProductDetailPage productDetailPage= new ProductDetailPage(getDriver());
	return productDetailPage;
	
	}


	
	

}
