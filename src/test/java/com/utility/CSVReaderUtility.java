package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	private CSVReaderUtility() {
	};

	public static <T> Iterator<T> readCSVFile(String filePath, Class<T> clazz) {

		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);

		if (inputStream == null) {
			throw new RuntimeException("cannot find the csv file in the specified file path" + filePath);
		}

		InputStreamReader streamReader = new InputStreamReader(inputStream);

		CSVReader reader = new CSVReader(streamReader);

		CsvToBean<T> csvToBean = new CsvToBeanBuilder(reader).withType(clazz).withIgnoreEmptyLine(true).build();
		List<T> userData = csvToBean.parse();

		return userData.iterator();

	}

}
