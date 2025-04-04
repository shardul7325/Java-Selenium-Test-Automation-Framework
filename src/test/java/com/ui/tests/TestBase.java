package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isHeadless = true;
	private boolean isLambdaTest = true;
	
	@BeforeMethod(description = "Load the Homepage of the website")
	public void setupMethod(ITestResult result) {
		WebDriver lambdaDriver;
		
		if(isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("chrome", result.getMethod().getMethodName());
			logger.info("Loads the Homepage of the website in Remote Server!!");
			homePage = new HomePage(lambdaDriver);
		}
		else {
			//Running the test in local Machine
			logger.info("Loads the Homepage of the website");
			homePage = new HomePage(CHROME, isHeadless);
		}
				
	}
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}
		else {
			homePage.quit();
		}
	}
}
