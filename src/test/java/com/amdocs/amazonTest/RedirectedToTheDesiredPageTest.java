package com.amdocs.amazonTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.amdocs.amazon.genericUtils.BaseAnnotationClassCB;
import com.amdocs.amazon.pomrepo.HomePage;

public class RedirectedToTheDesiredPageTest extends BaseAnnotationClassCB {
@Test
public void PracticalTest() throws InterruptedException
{
	HomePage hp=new HomePage(driver);
	String itemNAme = "toys";
	hp.searchIteam(driver, itemNAme);
	String Url = driver.getCurrentUrl();
	/*Validate the redirected page*/
	Assert.assertTrue(Url.contains(itemNAme));
	Reporter.log("Redirected to Desired Page");
	
	}
}
