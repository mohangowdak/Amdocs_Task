package commonUtility;

import java.time.LocalDateTime;
import java.util.Random;
/**
 * this class contains all java specfic methods 
 * @author CHANNAKESHVA REDDY
 *
 */
public class Javautility {
	/**
	 * this method will generate the random number
	 * @return
	 */
	public int RandomNumber() {
		Random ran = new Random();
		int ranNum=ran.nextInt(1000);
		return ranNum;
	}
	/**
	 * this method will return system date
	 * @return
	 */
	public String SystemDate() {
		String time = LocalDateTime.now().toString().replace(":", "-");
		return time;
	}

}
