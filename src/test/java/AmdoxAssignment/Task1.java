package AmdoxAssignment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 
{
	@Test
	public void task1() throws InterruptedException 
	{
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("arts and crafts");
		driver.findElement(By.xpath("//span[text()=' materials']")).click();
		String price = driver.findElement(By.xpath("//div[@id='p_36-title']")).getText();
		
		 int pr = Integer.parseInt(price);
		Assert.assertTrue(pr>=500);
		System.out.println(price);
		
		driver.findElement(By.xpath("//span[text()='INDIKONB 40 Colors 3 mm Seed Beads Jewellery Making Material - includes Small Multicolor Seed Beads & Nylon Wire Thread - Jewelry "
				+ "Making Set for Embroidery Work, Art and Craft (3 mm - 8/0, 40 Colours)']")).click();
		
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext())
		{
			String chwin=iterator.next();
			if(set.equals(iterator))
			{
				driver.switchTo().window(chwin);
				System.out.println(driver.switchTo().window(chwin).getTitle());
			}
		}
		Thread.sleep(20000);
		driver.close();
		
		 
		
		 
		
		
		
		
	}
	

}
