package com.amdocs.amazonTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.parser.ParserImpl;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1Test 
{
	@Test
	public void assignment1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		// search arts and crafts
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox' ]")).sendKeys("arts and crafts");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/div[4]")).click();
		
		//selecting parent table and fetching price
		String price = driver.findElement(By.xpath("//div[@class='s-matching-dir sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16']/descendant::span[@class='a-price-whole'][3]")).getText();
		
		int cost = Integer.parseInt(price);
		
		if (cost>500) 
		{
			System.out.println(cost);
			
			driver.findElement(By.xpath("//div[@class='s-matching-dir sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16']/descendant::span[@class='a-price-whole'][3]")).click();
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
					driver.findElement(By.id("add-to-cart-button")).click();
				}
				
			}
		}
		
		
		
	}
}
