package Amazon;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1{
	@Test
	public void assignment1() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
			
		
		// search for arts and crafts
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox' ]")).sendKeys("arts and crafts");
		Thread.sleep(4000);
		//click on search button
		driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/div[4]")).click();
		
		//select parent tag and fetching the price
		String price = driver.findElement(By.xpath("//div[@class='s-matching-dir sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16']/descendant::span[@class='a-price-whole'][3]")).getText();
		
		//converting string price into integer format
		int cost = Integer.parseInt(price);
		
		//comparing price is greater than 500 then print the price in cosole
		if (cost>500) 
		{
			System.out.println(cost);
			
			//click on the first product
			driver.findElement(By.xpath("//div[@class='s-matching-dir sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16']/descendant::span[@class='a-price-whole'][3]")).click();
			Thread.sleep(2000);
			
			//fetching parent id using window handles
			String parent = driver.getWindowHandle();
			Set<String> win = driver.getWindowHandles();
			Iterator<String> it = win.iterator();
			
			//here control checking for multiple windows
			while(it.hasNext())
			{
				//fetching child id
				String child = it.next();
				
				if (!parent.equalsIgnoreCase(child)) 
				{
					//if parent window!=child window then switch to child window
					driver.switchTo().window(child);
					
					//click on add to cart
					driver.findElement(By.id("add-to-cart-button")).click();
				}
				
			}
		}
	}
}
		
		
	