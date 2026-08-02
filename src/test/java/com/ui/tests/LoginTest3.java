package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("User Management")
@Feature("Login")
@Listeners({com.ui.listeners.TestListener.class,  io.qameta.allure.testng.AllureTestNg.class})





public class LoginTest3 extends TestBase {
	
	
	private static final Logger LOGGER = LogManager.getLogger(LoginTest3.class);

	
	@Story("Login using valid credentials")
	@Description("verify user is able to login with valid credenatials")
	@Severity(SeverityLevel.BLOCKER)
	@Test(description = "verify user is able to login with valid credenatials", groups = { "Regression",
			"Smoke" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginJsonDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginJsontest(User user) {
		

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Ramita Thakur");

	}

}
