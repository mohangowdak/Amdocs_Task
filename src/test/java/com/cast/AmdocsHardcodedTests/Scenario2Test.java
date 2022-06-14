package com.cast.AmdocsHardcodedTests;


import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author sushmitha
 *
 */
public class Scenario2Test {
	
	
	@Test
	public void amazonToys() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Navigating to amazon.in
		driver.get("https://www.amazon.in/");
		
		//Searching for toys
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("toys");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		
		//Sort by :low to high
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.id("s-result-sort-select_1")).click();
		
		
		//identifying the first product
		WebElement ele = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal'][1]"));
		
		//price of the product
		String pr = driver.findElement(By.xpath("//div[@class='a-section a-spacing-base']/descendant::span[@class='a-price-whole']")).getText();
		int price = Integer.parseInt(pr); 
//		System.out.println(price);
		
		SoftAssert s = new SoftAssert();
		s.assertTrue(price < 100, "Price less than 100");
		System.out.println("Price less than 100");
		ele.click();
		
		
		//Switching to the product window
		String actual = "SC-Mart-Transparent-Plasticine-Educational";
//		System.out.println(actual);
		
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
		
		//Quantity
		WebElement qty = driver.findElement(By.xpath("//label[text()='Quantity:']/ancestor::span[@class='a-dropdown-container']/descendant::select[@name='quantity']"));
		Select sel = new Select(qty);
		String quantitystring = sel.getFirstSelectedOption().getText();
		int quantity = Integer.parseInt(quantitystring);
		s.assertTrue(quantity > 0, "Quanity is greater than zero");
//		System. out. println("Quantity is greater than zero");
		Reporter.log("Quantity is greater than zero",true);
		
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
