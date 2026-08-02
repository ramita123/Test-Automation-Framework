package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	
	private static String filePath="";
	private static Properties prop  = new Properties();
	public static String env="";

	private ConfigManager() {
	};

	static {

		String env = System.getProperty("env", "qa");
		env = env.toLowerCase();
		
		switch(env) {
		
		case "qa"-> filePath= "config/QA.properties";
		
		case "uat" -> filePath="config/UAT.properties";
		
		case "dev"-> filePath="config/DEV.properties";
		
		default -> filePath="config/QA.properties";
		
		}

		InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
		if(inputStream==null) {
			throw new RuntimeException("Cannot read the file at path {}"+ filePath);
		}
		
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static  String getProperty(String key) {
		return prop.getProperty(key);
	}

}
