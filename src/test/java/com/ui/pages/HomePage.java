package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;

public final class HomePage extends BrowserUtility{

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");
	
	public HomePage(WebDriver driver) {
		super(driver);
		gotoWebsite("http://automationpractice.pl/index.php?");
		maximizeWindow();
	}
	
	public HomePage(Browser browserName) {
		super(browserName);
		gotoWebsite("http://automationpractice.pl/index.php?");
		maximizeWindow();
	}
	
	// Never use void return type for Page Functions
	public LoginPage gotoLoginPage() { // Page Functions
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
}
