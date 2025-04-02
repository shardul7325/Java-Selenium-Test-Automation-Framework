package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.EnvironmentConstants.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility{

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public HomePage(WebDriver driver) {
		super(driver);
		gotoWebsite(readProperty(QA, "URL"));
		maximizeWindow();
	}
	
	public HomePage(Browser browserName) {
		super(browserName);
//		gotoWebsite(readProperty(QA, "URL"));
		gotoWebsite(JSONUtility.readJSON(QA).getUrl());
		maximizeWindow();
	}
	
	// Never use void return type for Page Functions
	public LoginPage gotoLoginPage() { // Page Functions
		logger.info("Trying to perform click operation to goto Sign In page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}
}
