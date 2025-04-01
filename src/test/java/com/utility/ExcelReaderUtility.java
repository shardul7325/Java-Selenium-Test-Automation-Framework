package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	@DataProvider(name = "LoginTestExcelDataProvider")
	public static Iterator<User> readExcelFile(String fileName) {
		
		File xlsxFile = new File(System.getProperty("user.dir")+"\\testData\\"+fileName);
		XSSFWorkbook xssfWorkbook;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		List<User> userList = null;
		Row row;
		Cell emailAddress;
		Cell password;
		User user;
		
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();
			userList = new ArrayList<>();
			
			while(rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddress = row.getCell(0);
				password = row.getCell(1);
				
				user = new User(emailAddress.toString(), password.toString());
				userList.add(user);
			}
			
			xssfWorkbook.close();
			
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
	}
}
