package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class LoginPage extends BrowserUtility{

	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_LOGIN_BUTTON_lOCATOR = By.id("SubmitLogin");
	private static final By LOGIN_ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,'alert-danger')]/ol/li");
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public MyAccountPage doLoginWith(String emailAddress, String password) {
		logger.info("Trying to login with EmailAddress: " + emailAddress + " and Password: " + password);
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		
		logger.info("Performing Click operation on Submit Login Button: " + SUBMIT_LOGIN_BUTTON_lOCATOR);
		clickOn(SUBMIT_LOGIN_BUTTON_lOCATOR);
		
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}
	
	public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {
		logger.info("Trying to login with EmailAddress: " + emailAddress + " and Password: " + password);
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		
		logger.info("Performing Click operation on Submit Login Button: " + SUBMIT_LOGIN_BUTTON_lOCATOR);
		clickOn(SUBMIT_LOGIN_BUTTON_lOCATOR);
		
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	public String getLoginErrorMessage() {
		return getVisibleText(LOGIN_ERROR_MESSAGE_LOCATOR);
	}

}
