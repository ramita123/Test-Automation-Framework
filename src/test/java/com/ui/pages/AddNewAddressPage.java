package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.UserAddress;
import com.utility.BrowserUtility;
import static com.utility.FakerUtility.*;

public class AddNewAddressPage extends BrowserUtility {

	private static final By ADDRESS1_TEXT_LOCATOR = By.id("address1");
	private static final By CITY_TEXT_LOCATOR = By.id("city");
	private static final By POSTCODE_TEXT_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXT_LOCATOR = By.id("phone");
	private static final By PHONE_MOBILE_TEXT_LOCATOR = By.id("phone_mobile");
	private static final By ADDRESS_TITLE_TEXT_LOCATOR = By.id("alias");
	private static final By STATE_LOCATOR = By.id("id_state");
	private static final By SUBMIT_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDITIONAL_INFORMATION_TEXT_LOCATOR = By.id("other");

	public AddNewAddressPage(WebDriver driver) {
		super(driver)	;
}

	public void saveAddress(UserAddress userAddress) {
		
		enterText(ADDRESS1_TEXT_LOCATOR, userAddress.getAddress1());
		enterText(CITY_TEXT_LOCATOR, userAddress.getCity());
		enterText(POSTCODE_TEXT_LOCATOR,userAddress.getPostcode());
		enterText(HOME_PHONE_TEXT_LOCATOR, userAddress.getHomePhone());
		enterText(PHONE_MOBILE_TEXT_LOCATOR, userAddress.getMobilePhone());
		enterText(ADDRESS_TITLE_TEXT_LOCATOR, userAddress.getAddressAlias());
		enterText(ADDITIONAL_INFORMATION_TEXT_LOCATOR, userAddress.getAdditionalInformation());
		clickOn(STATE_LOCATOR);
		enterText(STATE_LOCATOR, "Alabama");
		clickOn(STATE_LOCATOR);
		clickOn(SUBMIT_ADDRESS_BUTTON_LOCATOR);

	}

}
