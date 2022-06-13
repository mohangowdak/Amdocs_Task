package commonUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * this class used to get data from properties file
 * @author CHANNAKESHVA REDDY
 *
 */
public class FileUtility {
	
	public String getProperties(String Key) throws IOException {
		
		FileInputStream fis = new FileInputStream("");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
	}

}
