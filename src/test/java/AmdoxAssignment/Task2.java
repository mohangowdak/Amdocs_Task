package AmdoxAssignment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 
{
	@Test
	public void task2() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(20000);
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("toys");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//a[@id='s-result-sort-select_1']")).click();
		
		Thread.sleep(20000);
		
		String price = driver.findElement(By.xpath("//span[text()='30']")).getText();
		int cost = Integer.parseInt(price);
		Assert.assertTrue((cost<100));
		System.out.println(price);
        
		 Object ele = driver.findElement(By.xpath("//img[@class='s-image' and  @src='https://m.media-amazon.com/images/I/314g5xzwnNS._AC_UL320_.jpg']"));
		  Assert.assertEquals(cost, ele);
		   
		  driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		  driver.findElement(By.xpath("//div[@data-cart-type='Retail_Cart' and @class='a-row ewc-cart-header ewc-cart-header--selected']")).click();
		  WebElement verifydata = driver.findElement(By.xpath("//span[@class='a-truncate-cut']"));
		  Assert.assertEquals(cost, verifydata);
		  System.out.println(verifydata);
		  driver.close();
		 
	}

}
