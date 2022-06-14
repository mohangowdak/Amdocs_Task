package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * 
 * @author sachin
 *
 */
public class Fileutility {
/**
 * using this method to achieve fetching the data from property file
 * @param key
 * @return 
 * @return
 * @throws Throwable
 */
	public String fetchcommondata(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/main/resources/commondata/data.properties ");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
