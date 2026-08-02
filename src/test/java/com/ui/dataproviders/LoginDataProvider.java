package com.ui.dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.JsonUtility;

public class LoginDataProvider {

	@DataProvider(name = "loginJsonDataProvider")
	public Iterator<User> loginJsonDataProvider() {
		return JsonUtility.loadJson("testData/loginData.json", User[].class);
	}

	@DataProvider(name = "LoginCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("testData/loginData.csv", User.class);
	}

}
