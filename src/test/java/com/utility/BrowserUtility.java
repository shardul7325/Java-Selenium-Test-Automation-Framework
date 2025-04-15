package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

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
		else if(browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());;
		}
		else {
			logger.error("Invalid Browser name!! Please select one of the following Chrome or Edge.");
		}
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching " + browserName + " browser");
		
		if(browserName == Browser.CHROME) {
			if(isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));				
			}
			else {
				driver.set(new ChromeDriver());
			}

		}
		else if(browserName == Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));				
			}
			else {
				driver.set(new EdgeDriver());
			}
		}
		else if(browserName == Browser.FIREFOX) {
			if(isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));				
			}
			else {
				driver.set(new FirefoxDriver());
			}
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
	
	public void clickOn(WebElement element) {
		logger.info("Performing click operation on webelement" + element);
		element.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator " + locator);
		WebElement webElement = driver.get().findElement(locator);
		logger.info("Found the element and now trying to enter text: " + textToEnter);
		webElement.sendKeys(textToEnter);
	}
	
	public void clearText(By texBoxLocator) {
		logger.info("Finding Element with the locator " + texBoxLocator);
		WebElement webElement = driver.get().findElement(texBoxLocator);
		logger.info("Element found and now clearing the test box");
		webElement.clear();
	}
	
	public void selectFromDropdown(By dropdownLocator, String optionToSelect) {
		logger.info("Finding Element with the locator " + dropdownLocator);
		WebElement element = driver.get().findElement(dropdownLocator);
		Select select = new Select(element);
		logger.info("Selecting the option " + optionToSelect);
		select.selectByVisibleText(optionToSelect);

	}
	
	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding Element with the locator " + locator);
		WebElement webElement = driver.get().findElement(locator);
		logger.info("Found the element and now trying to enter key: " + keyToEnter);
		webElement.sendKeys(keyToEnter);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Finding Element with the locator " + locator);
		WebElement webElement = driver.get().findElement(locator);
		logger.info("Found the element and now trying to return the visible text: " + webElement.getText());
		return webElement.getText();
	}
	
	public String getVisibleText(WebElement element) {
		
		logger.info("Return the visible text: " + element.getText());
		return element.getText();
	}
	
	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding List of Elements with the locator " + locator);
		List<WebElement> webElementsList = driver.get().findElements(locator);
		logger.info("Found List of Elements and now trying to return the List of visible texts.");
		
		List<String> visibleTextList = new ArrayList<>();
		for(WebElement wb: webElementsList) {
			visibleTextList.add(getVisibleText(wb));
		}
		
		return visibleTextList;
	}
	
	public List<WebElement> getAllWebElements(By locator) {
		logger.info("Finding List of Elements with the locator " + locator);
		List<WebElement> webElementsList = driver.get().findElements(locator);
		logger.info("Found List of Elements and now trying to return the List of Web Elements");
		
		return webElementsList;
	}
	
	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = dateFormat.format(date);
		String folderPath = "./extent-reports/screenshots/";
		String fileName = name + " - " + timeStamp + ".png";
		String path =  folderPath + fileName;
		File screenshotFile = new File(path);
		
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileName;
	}
	
	public void quit() {
		if(driver.get() != null) {
			driver.get().close();
			driver.get().quit();	
		}
	}
	
}
