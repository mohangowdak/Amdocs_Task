package com.youtube.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouTubeSearchResultPage {

	
	public YouTubeSearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='contents' and @class='style-scope ytd-section-list-renderer']/descendant::div[@class='text-wrapper style-scope ytd-video-renderer']")
	private List<WebElement> searchField;
	
	@FindBy(xpath="//button[@class='ytp-play-button ytp-button']")
	private WebElement pauseIcon;
	
	@FindBy(xpath="//yt-formatted-string[@id='owner-sub-count']")
	private WebElement subscribersText;

	public List<WebElement> getSearchField() {
		return searchField;
	}

	public WebElement getPauseIcon() {
		return pauseIcon;
	}

	public WebElement getSubscribersText() {
		return subscribersText;
	}
	
	public void clickOnVideo() 
	{
		int count=0;
		for(WebElement w: searchField)
		{
			count++;
			if(count==1)
			{
				w.click();
				
	}
		}
	}
	
	public void clickOnPause() throws Throwable
	{
		Thread.sleep(15000);
		pauseIcon.click();
	}
	
	public String captureSubs()
	{
		String subscribers = subscribersText.getText();
		return subscribers;
	}
	
}
