package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class InvalidLoginCredTest extends TestBase {
	
	private static final String USER_EMAIL_ADDRESS="ramita@yopmail.com";
	private static final String USER_PASSWORD="password";
			
	
	@Test
	public void loginTest() {
		

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidUser(USER_EMAIL_ADDRESS, USER_PASSWORD).errorMessage(),
				"Authentication failed.");
	}

}
