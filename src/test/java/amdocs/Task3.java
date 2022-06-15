package amdocs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3
{
	@Test
	public void task3() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Selenium Training");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();

		driver.findElement(By.xpath("//div[@class='style-scope ytd-video-renderer']")).click();

		Thread.sleep(15000);
		driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
		
		String[] subCount = driver.findElement(By.id("owner-sub-count")).getText().split(" ");
		
		Assert.assertTrue(subCount[0].contains("K") || subCount[0].contains("M"),"Subscribers less than thousand");
		System.out.println("Subscribers : "+subCount[0]);
		 driver.quit();
	}



}
