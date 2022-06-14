package com.cast.AmdocsTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.YouTubeHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3Test extends BaseClass{

	@Test
	public void youtubePlayPause() throws InterruptedException {
	
		//Open the youtube.com
		driver.get("https://Youtube.com/");
		YouTubeHomePage yt = new YouTubeHomePage(driver);
		yt.searchFor();
		
		//waiting for 15seconds
		yt.pause();
		yt.subscriberCount();
	 }

}
