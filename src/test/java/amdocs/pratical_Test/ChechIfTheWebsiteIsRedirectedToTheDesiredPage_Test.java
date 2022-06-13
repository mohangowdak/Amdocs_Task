package amdocs.pratical_Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amazon.comcast.pomrepositlib.Home_Page;
import com.crm.GenericUtility_Test.BaseAnnotationClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChechIfTheWebsiteIsRedirectedToTheDesiredPage_Test extends BaseAnnotationClass{
	
	@Test
	public void chechIfTheWebsiteIsRedirectedToTheDesiredPage() throws InterruptedException
	{
		Home_Page hp=new Home_Page(driver);
		hp.getSearchBox().sendKeys("toys");
		Thread.sleep(2000);
		hp.getSearchOption().click();
		String itemName="toys";
		String url=driver.getCurrentUrl();
		SoftAssert sAssert = new SoftAssert();
		sAssert.assertTrue(url.contains(itemName));
		sAssert.assertAll();
	}

}
