package helloworld;

	import java.awt.AWTException;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

import GenericUtility.Baseclass;
import GenericUtility.Webdriverutility;
import ObjectRepositoryAmazonPriceisgraterThan.Amazon1HomePage;
import ObjectRepositoryAmazonPriceisgraterThan.Artsandcraftsproductpage;
import ObjectRepositoryAmazonPriceisgraterThan.ProductCartpage;
import io.github.bonigarcia.wdm.WebDriverManager;
	/**
	 * Here search for product and select fourth option from top
	 * check the price of product grater than 500rs
	 * validate product present in cart are not and print in console
	 * @author sachin
	 *
	 */
	public class AmazonPriceisgraterThan extends Baseclass{
	
		@Test
		public void test() throws InterruptedException, AWTException
		{
		
		 /*search for product in amazon*/
		Amazon1HomePage homepage=new Amazon1HomePage(driver);
		homepage.searchtextbox("arts and crafts");
		homepage.clicksearchtextbox();
	    homepage.selectalllist();
	    
	    /*click on fourth option*/
	    List<WebElement> allsuggestions = homepage.getFetchfourthdata();
	    int count=0;
	    for(WebElement wb:allsuggestions)
	    {
	    	count++;
	    	if(count==4)
	    	{
	    		wb.click();
	    	}
	    }
	    
	    /*scroll by product page*/
	    wutil.ExecutejavaScript(driver, "window.scrollBy(0,300);");
	    Artsandcraftsproductpage productpage=new Artsandcraftsproductpage(driver);
	    productpage.validateproductprice();
	    productpage.clickonfirdtproduct();
	    
	    /*using java scripts scroll down product page*/
	    wutil.ExecutejavaScript(driver, "window.scrollBy(0,200);");
	    productpage.clickonaddtocart();
	    productpage.clickonviewcart();
	    
	    /*actual product print in console*/
	    ProductCartpage cartpage=new ProductCartpage(driver);
	    String actualproduct = cartpage.getValidatecart().getText();		
	    System.out.println(actualproduct);		
	   
		   }
		}
	
	
		
		

		


