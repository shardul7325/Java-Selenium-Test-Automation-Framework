package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	
	public BrowserUtility(WebDriver driver) {
		super();
		BrowserUtility.driver.set(driver);// This is going to initialize the instance variable driver!!
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching " + browserName + " browser");
		if(browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		else if(browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());;
		}
		else {
			logger.error("Invalid Browser name!! Please select one of the following Chrome or Edge.");
		}
	}
	
	
	public void gotoWebsite(String url) {
		logger.info("Launching the website " + url);
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info("Finding Element with the locator " + locator);
		WebElement webElement = driver.get().findElement(locator);
		logger.info("Found the element and now performing click operation on " + locator);
		webElement.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator " + locator);
		WebElement webElement = driver.get().findElement(locator);
		logger.info("Found the element and now trying to enter text: " + textToEnter);
		webElement.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator " + locator);
		WebElement webElement = driver.get().findElement(locator);
		logger.info("Found the element and now trying to return the visible text: " + webElement.getText());
		return webElement.getText();
	}
	
	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = dateFormat.format(date);
		String path = System.getProperty("user.dir") + "\\screenshots\\" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
}
