	/*
	 * How to ensure we write good Test Scripts
	 * 1. Test Scripts have to be small
	 * 2. You cannot have conditional statements, loops, try catch in your test methods
	 * 		1st Test Scripts ----> then Test steps
	 * 3. Reduce the use of local variables!!
	 * 4. You should have at least one assertion!!
	 */
package com.ui.tests;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTestDataDriven extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	
//	@Test(description = "Verifies if the valid user is able to login into the application"
//			, groups = {"e2e", "sanity"}
//			, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class
//			, dataProvider = "LoginTestDataProvider")
//	public void loginTest(User user) {
//		
//		assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(), "Shardul Pakhare");
//		
//	}
//	
	@Test(description = "Verifies if the valid user is able to login into the application"
			, groups = {"e2e", "sanity"}
			, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class
			, dataProvider = "LoginTestCSVDataProvider"
			, retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginCSVTest(User user) {
		
		assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
				.getUsername(), "Shardul Pakhare");
		
	}
	
//	@Test(description = "Verifies if the valid user is able to login into the application"
//			, groups = {"e2e", "sanity"}
//			, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class
//			, dataProvider = "LoginTestExcelDataProvider"
//			, retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginExcelTest(User user) {
//		assertEquals(homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(), "Shardul Pakhare");
//		
//	}

}
