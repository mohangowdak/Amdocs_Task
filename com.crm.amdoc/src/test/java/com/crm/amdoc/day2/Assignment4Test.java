package com.crm.amdoc.day2;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amazon.objectrepository.HomePage;
import com.genericutility.BaseClass;




public class Assignment4Test extends BaseClass {
	
	@Test
	public void amazon() throws Throwable
	{
		
		
		HomePage home_Page= new HomePage(driver);
		home_Page.passvalueInSearchBar(eLib.getDataFromExcel("Sheet1", 1, 0), driver);
		
		String exp_title =eLib.getDataFromExcel("Sheet1", 1, 2);
		String act_title = driver.getTitle();
		
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(exp_title, act_title);
		System.out.println("Actual Title: "+ act_title);
		
	}

}
