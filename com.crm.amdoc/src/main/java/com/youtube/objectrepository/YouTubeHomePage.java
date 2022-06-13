package com.youtube.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouTubeHomePage {
	
	public YouTubeHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_query")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@id='search-icon-legacy']")
	private WebElement searchButton;

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	//Business Logics
	
	public void enterSearchValue(String value)
	{
		searchField.sendKeys(value);
		searchButton.click();
	}
}
