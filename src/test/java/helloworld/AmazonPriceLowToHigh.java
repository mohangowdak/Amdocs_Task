package helloworld;
	import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

import GenericUtility.Baseclass;
import GenericUtility.Webdriverutility;
import ObjectRepositoryAmazonPriceLowToHigh.AmazonHomepage2;
import ObjectRepositoryAmazonPriceLowToHigh.CartpageAmazon2;
import ObjectRepositoryAmazonPriceLowToHigh.Toyspage;
import ObjectRepositoryAmazonPriceLowToHigh.Toysproductpage;
import ObjectRepositoryAmazonPriceisgraterThan.ProductCartpage;
import io.github.bonigarcia.wdm.WebDriverManager;
	/**
	 * Here search for product and sortby price low to high
	 * check product is price is less than 100rs than print console
	 * checking product quantity print in console
	 * validate the title of product in cart and print in console
	 * @author sachin
	 *
	 */

	public class AmazonPriceLowToHigh extends Baseclass{
		@Test
		public void test() throws Throwable
		{
			
			/*search for product toys*/
			AmazonHomepage2 homepage=new AmazonHomepage2(driver);
			homepage.searchbox("toys");
			homepage.clicksearchbutton();
			
			/*sortby price low to high*/
			Toyspage typage=new Toyspage(driver);
			typage.sortbyprice();
			typage.pricelowtohigh();
		
			/*here scroll down the toys page*/
			wutil.ExecutejavaScript(driver, "window.scrollBy(0,200);");
		
	        /*Validate product price*/
			typage.validateproductprice();
			typage.clickfirstproduct();
			
			/*validate product quantity*/
			Toysproductpage typroductpage=new Toysproductpage(driver);
			typroductpage.validatequntity();
			typroductpage.addtocartproduct();
			typroductpage.clickviewcart();
			
			/*validate product present in cart or not and print in console*/
			CartpageAmazon2 cartpage=new CartpageAmazon2(driver);
			cartpage.validatecartproductpresentornot();
			
			}
	}




