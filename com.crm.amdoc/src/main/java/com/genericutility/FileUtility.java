package com.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/*
 * This class contains all the generic method of Property File
 */
public class FileUtility {
	
	/*
	 * This method Fetch the data from the property file
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/main/resources/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
