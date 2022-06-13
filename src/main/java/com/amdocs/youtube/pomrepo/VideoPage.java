package com.amdocs.youtube.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideoPage {
	WebDriver driver;

	public VideoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='ytp-play-button ytp-button']")
	private WebElement playBtn;

	public WebElement getPlayBtn() {
		return playBtn;
	}
	
	@FindBy(id = "owner-sub-count")
	private WebElement subCount;

	public WebElement getSubCount() {
		return subCount;
	}
	
}
