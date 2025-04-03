package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homepage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@BeforeMethod(description = "Load the Homepage of the website")
	public void setupMethod() {
		logger.info("Loads the Homepage of the website");
		homepage = new HomePage(CHROME);
	}
	
	public BrowserUtility getInstance() {
		return homepage;
	}
}
