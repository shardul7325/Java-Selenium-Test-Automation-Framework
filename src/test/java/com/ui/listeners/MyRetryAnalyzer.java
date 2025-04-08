package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.EnvironmentConstants;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public class MyRetryAnalyzer implements IRetryAnalyzer{

//	private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(readProperty(EnvironmentConstants.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJSON(EnvironmentConstants.QA).getmaxNumberOfAttempts();
	private static int currentAttempt = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		currentAttempt = 1;
		return false;
	}

}
