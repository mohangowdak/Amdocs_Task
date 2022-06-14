package com.amdocs.youtube.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@id='search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@id='search-icon-legacy']")
	private WebElement searchBtn;
	
	public void searchIteam(WebDriver driver, String videoName) throws Throwable
	{
		searchBox.sendKeys(videoName);
		Thread.sleep(1000);
		searchBtn.click();
	}
}
