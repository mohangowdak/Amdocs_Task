package com.cast.AmdocsHardcodedTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.AmazonHome1Page;

public class Scenario4Test extends BaseClass{
	
	@Test
	public void amazonToys() {
		
		AmazonHome1Page hp = new AmazonHome1Page(driver);
		hp.searchItem("toys",driver);
		
	}
	
	

}
