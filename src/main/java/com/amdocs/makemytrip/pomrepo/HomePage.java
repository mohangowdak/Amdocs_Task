package com.amdocs.makemytrip.pomrepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="langCardClose")
	private WebElement hiddenDivisionPopup;
	
	public WebElement getHiddenDivisionPopup() {
		return hiddenDivisionPopup;
	}

	@FindBy(xpath="//li[@data-cy='roundTrip']")
	private WebElement roundTripRadioBtn;
	
	@FindBy(xpath="//label[@for='fromCity']")
	private WebElement fromText;
	
	@FindBy(xpath="//p[text()='Bangalore, India']")
	private WebElement searchResultBLR;
	
	@FindBy(xpath="//span[text()='To']")
	private WebElement toText;
	
	@FindBy(xpath="//p[text()='Delhi, India']")
	private WebElement searchResultDEL;
	
	@FindBy(xpath="//span[@aria-label='Next Month']")
	private WebElement nextMonthSelectionArrow;
	
	@FindBy(xpath="//a[text()='Search']")
	private WebElement searchButton;

	@FindBy(xpath="//div[@class='headerOuter']")
	private WebElement loginAd;

	public WebElement getRoundTripRadioBtn() {
		return roundTripRadioBtn;
	}

	public WebElement getFromText() {
		return fromText;
	}

	public WebElement getSearchResultBLR() {
		return searchResultBLR;
	}

	public WebElement getToText() {
		return toText;
	}

	public WebElement getSearchResultDEL() {
		return searchResultDEL;
	}

	public WebElement getNextMonthSelectionArrow() {
		return nextMonthSelectionArrow;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public WebElement getLoginAd()
	{
		return loginAd;
	}
	//Business Logic
	public void roundTripFromTo()
	{
		hiddenDivisionPopup.click();
		roundTripRadioBtn.click();
		fromText.click();
		//loginAd.click();
		searchResultBLR.click();
		toText.click();
		searchResultDEL.click();
		
	}
	public  void selectFromToDate(String monthYear, int date, WebDriver driver)
	{
		String path = "//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		
		
		for(;;)
			{
				try
				{
				driver.findElement(By.xpath(path)).click();
				break;
				}
				
				catch(Exception e)
				{
					nextMonthSelectionArrow.click();
				
				}
			}

}
	
	public void search()
	{
		searchButton.click();
	}
}
