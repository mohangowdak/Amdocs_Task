package GenericLibrary;

import java.io.FileInputStream;

import java.util.Properties;

/**
 * This class will read data from property file and return value to user
 * @author LHR
 *
 */
public class PropertyFileUtility 
{
	
	/**
	 * This method will read data from property file for the key given by user 
	 * and return value to user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
public String readDataFromPropertyFile(String key) throws Throwable
{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties plib=new Properties();
	plib.load(fis);
	String value = plib.getProperty(key);
	return value;

}
	
}
