package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddNewAddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.UserAddress;
import com.utility.FakerUtility;

public class AddNewAddressTest extends TestBase{
	
	private MyAccountPage accountPage;
	private AddNewAddressPage addressPage;
	private UserAddress  userAddress;
	@BeforeMethod(description ="valid first time user logs in ")
	public void setUp() {
		accountPage=	homePage.goToLoginPage().doLoginWith("lucky@yopmail.com", "Ramita@Automation2026!X7");
		userAddress= FakerUtility.getFakeAddress();
	}
	
	
	@Test(description ="Adding first new address ")
	public void addNewAddress() {
	accountPage.goToAddAddressPage().saveAddress(userAddress);
	}

}
