package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private WebDriver driver;

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;// This is going to initialize the instance variable driver!!
	}
	
	public BrowserUtility(Browser browserName) {
		if(browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		}
		else if(browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void gotoWebsite(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement webElement = driver.findElement(locator);
		webElement.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		WebElement webElement = driver.findElement(locator);
		webElement.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		WebElement webElement = driver.findElement(locator);
		return webElement.getText();
	}
	
}
