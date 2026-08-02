package com.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class AllureEnvironmentWriterUtility {
	
	
	
	private AllureEnvironmentWriterUtility() {};
	
	
	public static void createEnvironmentProperties() {
		 String folderPath="target/allure-results";
			
			File file= new File(folderPath);
			file.mkdirs();
			
			Properties prop= new Properties();
			prop.setProperty("Engineer Name", System.getProperty("user.name"));
			prop.setProperty("Project Name", "Web Automation Assignment");
			prop.setProperty("Environment", ConfigManager.env);
			prop.setProperty("Base_Uri", ConfigManager.getProperty("URL"));
			prop.setProperty("Operating version", System.getProperty("os.version"));
			prop.setProperty("Operating System", System.getProperty("os.name"));
			prop.setProperty("Java version", System.getProperty("java.version"));
			
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(folderPath + File.separator + "environment.properties");
				prop.store(fileWriter, "My environment property file");
				fileWriter.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
	}		

}
