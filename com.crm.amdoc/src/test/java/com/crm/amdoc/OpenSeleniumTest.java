package com.crm.amdoc;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericutility.JavaUtility;
import com.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenSeleniumTest {
	
	public static void main(String[] args) throws Throwable {
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/");
		wLib.screenShot(driver);
		driver.close();
	}

}
