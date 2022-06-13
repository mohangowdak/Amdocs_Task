package com.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassYouTube {
	
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public  WebDriver driver=null;

	
	
	@BeforeSuite()
	public void beforeSuite()
	{
		System.out.println("--------------------Before Suite-----------------");
	}
	
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("---------------Before Test-------------------");
	}
	

	@BeforeClass()
	public void beforeClass() throws Throwable
	{
		String browser = "chrome";
		String url = "https://www.youtube.com/";
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
	
		} else {
			System.out.println("Specify a valid browser");
		}	
		
		driver.get(url);
		driver.manage().window().maximize();
		wLib.implicitWait(driver, 20);
	}
	
	
	
	@BeforeMethod()
	public void beforeMethod() throws Throwable
	{
		System.out.println("---------------------Before Method---------------");
	}
	
	
	@AfterMethod()
	public void afterMethod()
	{
		System.out.println("---------------------After Method---------------");
	}
	
	
	@AfterClass()
	public void afterClass()
	{
		driver.quit();
	}
	
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("---------------After Test---------------");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("---------------After Suite---------------------");
	}

}
