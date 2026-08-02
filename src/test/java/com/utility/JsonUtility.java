package com.utility;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import tools.jackson.databind.ObjectMapper;

public class JsonUtility {
	
	private JsonUtility() {};
	
	
	
	public static <T> Iterator<T> loadJson(String filePath, Class<T[]> clazz) {
		
		InputStream inputStream= Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
		
		
		ObjectMapper mapper= new ObjectMapper();
	T[ ] classArray=	mapper.readValue(inputStream, clazz);
	List<T> listArray=Arrays.asList(classArray);
	
	return listArray.iterator();
		
		
		
		
	}


}
