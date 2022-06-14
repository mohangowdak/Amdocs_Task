package helloworld;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.Baseclass;
import ObjectRepositoryforUsingFramework.Homepage;

public class Usingframework extends Baseclass{

	@Test
	
	public void framework() throws Throwable
	{
		Homepage hm=new Homepage(driver);
		/*fetching data from excel sheet*/
		String fetchproduct = exl.getdata("Sheet1", 0, 1);
		hm.entertextinsearchbox(fetchproduct);
		hm.clickonsearchbutton();
		
		/*validate title on actual product*/
		String actualttitle = driver.getTitle();
		String expectedtitle="Amazon.com : toys";
        Assert.assertEquals(actualttitle, expectedtitle);
	}
}
