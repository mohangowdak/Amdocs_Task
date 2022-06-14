package com.cast.AmdocsHardcodedTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * This class will pause the youtube vedio after 15 seconds.
 * @author sushmitha
 *
 */
public class Scenario3Test {
	
	
	/**
	 * This method will pause the youtube vedio after 15 seconds.
	 * @throws InterruptedException
	 */
	@Test
	public void youtubePlayPause() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Maximizing the window
		driver.manage().window().maximize();
		
		//Wait to pageLoad
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		//Open the youtube.com
		driver.get("https://Youtube.com/");
		Thread.sleep(3000);
		
		//Identifying search text box and passing the Selenium Training
//		driver.findElement(By.id("search")).sendKeys("Selenium Training");
		WebElement search = driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div/div[1]/input"));
		search.sendKeys("Selenium Training");
//		search.sendKeys(Keys.ENTER);
		
		//Click on search
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		
		//Click on First video to play 
		driver.findElement(By.xpath("//a[@id='video-title']/child::yt-formatted-string[@class='style-scope ytd-video-renderer']")).click();
		
		//waiting for 15seconds
		Thread.sleep(15000);
		
		//Identify the pause button and click
		driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
		Thread.sleep(2000);
		
		//Fetching subscribers 
		String[] subscribers = driver.findElement(By.xpath("//yt-formatted-string[@id='owner-sub-count']")).getText().split(" ");
		
		SoftAssert s = new SoftAssert();
		s.assertTrue(subscribers[0].contains("K") || subscribers[0].contains("M"),"Subscribers less than 1000");
		
		
		//Closing the browser
		driver.quit();
	
	}
	
}
