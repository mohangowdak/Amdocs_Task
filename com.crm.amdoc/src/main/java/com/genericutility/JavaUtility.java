package com.genericutility;

import java.util.Random;

/*
 * This class contains java re usable method
 */
public class JavaUtility {
	
	
	/*
	 * This method will generate random number
	 */
	public int randomNum()
	{
	Random r = new Random();
	int num = r.nextInt(1000);
	return num;
	}

}
