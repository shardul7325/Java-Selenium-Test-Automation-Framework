package com.utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private WebDriver driver;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;// This is going to initialize the instance variable driver!!
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching " + browserName + " browser");
		if(browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		}
		else if(browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		}
		else {
			logger.error("Invalid Browser name!! Please select one of the following Chrome or Edge.");
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void gotoWebsite(String url) {
		logger.info("Launching the website " + url);
		driver.get(url);
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info("Finding Element with the locator " + locator);
		WebElement webElement = driver.findElement(locator);
		logger.info("Found the element and now performing click operation on " + locator);
		webElement.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator " + locator);
		WebElement webElement = driver.findElement(locator);
		logger.info("Found the element and now trying to enter text: " + textToEnter);
		webElement.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator " + locator);
		WebElement webElement = driver.findElement(locator);
		logger.info("Found the element and now trying to return the visible text: " + webElement.getText());
		return webElement.getText();
	}
	
}
