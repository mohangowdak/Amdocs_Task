package AmdoxAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 
{
	@Test
	public void task3() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://youtube.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("selenium training");
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//yt-formatted-string[text()='Selenium Full Course - Learn Selenium in 12 Hours | Selenium Tutorial For Beginners | Edureka']")).click();
		Thread.sleep(5000);
		driver.close();
	}

}
