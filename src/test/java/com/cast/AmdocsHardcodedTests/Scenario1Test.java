package com.cast.AmdocsHardcodedTests;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1Test {

	@Test
	public void amazonArtAndCrafts() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		//Searching for arts and crafts
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("arts and crafts");
		Thread.sleep(3000);
		
		//clicking on 4th option from top from Autosuggestions
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
//		System.out.println(elements.size());
		elements.get(3).click();
		
		//Finding the first product
		String actual = "Little-Birdie-Bitsy-Decor-Varnish";
		driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).click();
		
		//Switching to the window of the product
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		 
		 while(it.hasNext())
		 {
			 String winId = it.next();
			 String currentWinTitle = driver.switchTo().window(winId).getTitle();
			 if(currentWinTitle.contains(actual)) {
				 break;
			 }
			 
		 }
		
		//Fetching the price
		String pr = driver.findElement(By.xpath("//td[@class='a-span12']/descendant::span[@aria-hidden='true']")).getText();
		String p = pr.substring(1);
		double price = Double.parseDouble(p);
		SoftAssert s = new SoftAssert();
		s.assertTrue(price > 500, "Price greater than 500");
//		System.out.println("Price is greater than 500");
		Reporter.log("Price is greater than 500",true);
		//adding to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("nav-cart-count")).click();
		
		List<WebElement> wb = driver.findElements(By.xpath("//span"));
		
		for(int i=0; i<wb.size(); i++) {
			String title = wb.get(i).getText();
			s.assertEquals(actual, title);
//			System.out.println("Title of the product is present");
			Reporter.log("Title of the product is present",true);
			break;
		}
		
		//closing the browser
		driver.quit();

	}

}
