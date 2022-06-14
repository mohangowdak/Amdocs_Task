package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.WebDriverUtility;

public class YouTubeHomePage extends WebDriverUtility{
	
	@FindBy(xpath="/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div/div[1]/input")
	private WebElement search;
	
	@FindBy(xpath="//button[@id='search-icon-legacy']")
	private WebElement searchIcon;
	
	@FindBy(xpath="//a[@id='video-title']/child::yt-formatted-string[@class='style-scope ytd-video-renderer']")
	private WebElement firstVedio;
	
	@FindBy(xpath="//button[@class='ytp-play-button ytp-button']")
	private WebElement pauseBtn;
	
	@FindBy(xpath="//yt-formatted-string[@id='owner-sub-count']")
	private WebElement subscriberCount;
	
	public YouTubeHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}
	

	//business library
	public void searchFor() {
		
		search.sendKeys("selenium Webdriver");
		searchIcon.click();
		firstVedio.click();
	}
	
	public void pause() throws InterruptedException {
		
		Thread.sleep(15000);
		pauseBtn.click();
		
	}
	
	public void subscriberCount() {
		String[] subscribers = subscriberCount.getText().split(" ");
		
		SoftAssert s = new SoftAssert();
		s.assertTrue(subscribers[0].contains("K") || subscribers[0].contains("M"),"Subscribers less than 1000");
	}
	
	

}
