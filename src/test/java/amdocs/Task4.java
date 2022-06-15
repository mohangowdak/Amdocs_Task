package amdocs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 
{
	@Test
	public void task4() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new FirefoxDriver();
		//WebDriver driver1=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//driver1.get("https://www.amazon.in/");
         Thread.sleep(20000);
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("toys");
		WebElement toys = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		WebElement verify = driver.findElement(By.xpath("//"));
		Assert.assertEquals(verify, toys);
		System.out.println(verify);
		driver.close();
		
	}

}
