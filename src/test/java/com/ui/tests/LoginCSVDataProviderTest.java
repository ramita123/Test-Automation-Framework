package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;

@Listeners({com.ui.listeners.TestListener.class, io.qameta.allure.testng.AllureTestNg.class})
public class LoginCSVDataProviderTest extends TestBase {


	@Test(description = "verify user is able to login with CSV data provider valid credenatials", groups = { "Regression", "Smoke" },
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginCSVDataProvider",retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
	public void loginCSVtest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Ramita Thakur");

	}

}
