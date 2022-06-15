package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility 
{
	/**
	 * this method will read data from property file for the key given by user and return value to user
	 * @param key
	 * @return
	 * @throws Throwable 
	 * @throws Throwable 
	 * @throws Throwable
	 */
	
	public String readDatafromPropertyfile(String key) throws Throwable 
	{
		FileInputStream fs = new FileInputStream(".\\\\src\\\\test\\\\resources\\\\CommonData.properties");
		Properties pLoad = new Properties();
		pLoad.load(fs);
		return pLoad.getProperty(key);
	}

}
