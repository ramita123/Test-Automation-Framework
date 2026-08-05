package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;
import com.ui.tests.LoginTest3;

import io.qameta.allure.Attachment;

public abstract class BrowserUtility {
	private static final Logger LOGGER = LogManager.getLogger(LoginTest3.class);

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	private WebDriverWait wait=null;

	public WebDriver getDriver() {
		return driver.get();
	}

	

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if (browserName == browserName.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");

				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {


				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browserName == browserName.FIREFOX) {

			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else {
			System.err.println("Invalid browser name !! please selelct chrome or firefox only");
		}
	}

	public BrowserUtility(WebDriver lambdaDriver) {
		driver.set(lambdaDriver);
		wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
	}

	public void goToWebsite(String url) {
		LOGGER.info("Visitng the website {}", url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		LOGGER.info("Maximizing the window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		LOGGER.info("Finding the element with locator {}", locator);
		WebElement element = driver.get().findElement(locator);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public void clickOn(WebElement webElement) {
		webElement.click();
	}

	public void enterText(By locator, String textToEnter) {

	//	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(textToEnter);

	}

	public void enterSpecialKey(By locator, Keys keys) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keys);

	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {
		List<WebElement> elementList = driver.get().findElements(locator);
		List<String> visibleTextList = new ArrayList<>();
		for (WebElement element : elementList) {

			visibleTextList.add(element.getText());

		}
		return visibleTextList;
	}

	public List<WebElement> getProductList(By locator) {
		List<WebElement> elementList = driver.get().findElements(locator);
		List<WebElement> productList = new ArrayList<>();
		for (WebElement element : elementList) {

			productList.add(element);

		}
		return productList;
	}

	public void selectFromDropdown(By dropDownLocator, String optionToSelect) {
		WebElement element = driver.get().findElement(dropDownLocator);
		Select s = new Select(element);
		clickOn(dropDownLocator);
		s.selectByVisibleText(optionToSelect);
	}

	public String takeScreenShot(String name) {
		TakesScreenshot takesScreenShot = (TakesScreenshot) driver.get();
		File source = takesScreenShot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String destinationPath = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + name
				+ "-" + timeStamp + ".png";
		try {
			FileUtils.copyFile(source, new File(destinationPath));
		} catch (IOException e) {

			e.printStackTrace();
		}

		return destinationPath;

	}

}
