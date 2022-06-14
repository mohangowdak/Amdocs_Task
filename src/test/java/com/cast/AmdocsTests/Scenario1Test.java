package com.cast.AmdocsTests;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.AmazonArtsAndCraftsPage;
import com.crm.ObjectRepository.AmazonHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1Test extends BaseClass{
	

	@Test
	public void amazonArtAndCrafts() throws Throwable
	{
		
		//Searching for arts and crafts
		AmazonHomePage ah = new AmazonHomePage(driver);
		ah.scenario1(driver);
		
		//Finding the first product
		AmazonArtsAndCraftsPage aac = new AmazonArtsAndCraftsPage(driver);
		aac.scenario1(driver);

	}


}
