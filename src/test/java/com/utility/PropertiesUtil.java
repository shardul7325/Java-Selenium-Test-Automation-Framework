package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.EnvironmentConstants;

/*
 * File to read .properties file
 */
public class PropertiesUtil {
	
	public static String readProperty(EnvironmentConstants env, String propertyName) {
//		System.out.println(System.getProperty("user.dir")); //IMPORTANT property
		
		File propertiesFile = new File(System.getProperty("user.dir") + "//config//" + env + ".properties");
		FileReader fileReader;
		Properties properties = new Properties();
		
		try {
			fileReader = new FileReader(propertiesFile);
			properties.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties.getProperty(propertyName.toUpperCase());
	}
}
