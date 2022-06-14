package com.cast.AmdocsTests;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.AmazonHomePage;
import com.crm.ObjectRepository.AmazonToysPage;
import com.crm.ObjectRepository.ToyPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2Test extends BaseClass{
	
	@Test
	public void amazonToys() {
		
		//Searching for toys
		AmazonHomePage ah = new AmazonHomePage(driver);
		ah.searchToys(driver);
		
		//Sort by :low to high
		AmazonToysPage at = new AmazonToysPage(driver);
		at.lowToHigh();
		
		//identifying the first product
		at.firstProductAndPrice();
		
		//Switching to the product window
		ToyPage tp = new ToyPage(driver);
		tp.toy(driver);
		
	}

}
