package com.amdocs.amazonTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2Test 
{
	@Test
	public void assignment2() throws InterruptedException
	{
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		// search toys
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox' ]")).sendKeys("toys");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//click on sortby
		
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//a[text()='Price: Low to High']")).click();
		
		String price = driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/descendant::span[@class='a-price-whole'][4]")).getText();
		int cost = Integer.parseInt(price);
		//System.out.println(price);
		
		if (cost<100) 
		{
			System.out.println(cost);
			driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/descendant::span[@class='a-price-whole'][4]")).click();
			Thread.sleep(2000);
			//fetching parent id
			String parent = driver.getWindowHandle();
			Set<String> win = driver.getWindowHandles();
			Iterator<String> it = win.iterator();
			while(it.hasNext())
			{
				//fetching child id
				String child = it.next();
				
				if (!parent.equalsIgnoreCase(child)) 
				{
					driver.switchTo().window(child);
					
					WebElement element = driver.findElement(By.xpath("//select[@name='quantity']"));
					Select s=new Select(element);
					String quantity = s.getFirstSelectedOption().getText();
					System.out.println(quantity);
					driver.findElement(By.id("add-to-cart-button")).click();
					driver.findElement(By.xpath("//a[@class='a-button-text']")).click();
					String text = driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).getText();
					
					//Assert.assertTrue(text.contains("Clay Slime DIY Crystal Transparent"));
					System.out.println(text);
					
				}
				
			}
		}
		{
			driver.close();
		}
		
}
}