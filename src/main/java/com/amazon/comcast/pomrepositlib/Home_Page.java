package com.amazon.comcast.pomrepositlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	WebDriver driver;
	public Home_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@type='text']")
	private WebElement SearchBox;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement SearchOption;
	
	public WebElement getSearchBox() {
		return SearchBox;
	}

	public WebElement getSearchOption() {
		return SearchOption;
	}

	
}
