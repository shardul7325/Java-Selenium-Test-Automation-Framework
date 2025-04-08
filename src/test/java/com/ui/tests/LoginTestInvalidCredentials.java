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
public class LoginTestInvalidCredentials extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_USERNAME = "abcd@gmail.com";
	private static final String INVALID_PASSWORD = "anime@1234";
	
	@Test(description = "Verifies if he proper error message is shown for a user when they enter invalid credentials"
			, groups = {"e2e", "sanity"}
			, retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginTestInvalidCredentials() {
		
		assertEquals(homePage.gotoLoginPage()
				.doLoginWithInvalidCredentials(INVALID_USERNAME, INVALID_PASSWORD)
				.getLoginErrorMessage(), "Authentication failed." );
		
	}

}
