package com.makemytrip.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsfromBengalurutoNewDelhi {
	
	public FlightsfromBengalurutoNewDelhi(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[@id='flightCard-47']")
	private WebElement departLastFlightButton;
	
	@FindBy(xpath="//label[@id='flightCard-101']")
	private WebElement returnFlightLastButton;
	
	@FindBy(xpath="//p[text()='Departure']/ancestor::div[@class='stickyFlightDtl appendRight15']/descendant::span[@class='whiteText blackFont fontSize16']")
	private WebElement departFlightSelectedPrice;
	
	@FindBy(xpath="//button[text()='Book Now']")
	private WebElement bookNowButton;
	
	@FindBy(xpath="//button[contains(@id,'bookbutton-RKEY')  and text()='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//span[@class='bgProperties icon20 overlayCrossIcon']")
	private WebElement hiddonDivisionPopup;

	public WebElement getDepartLastFlightButton() {
		return departLastFlightButton;
	}

	public WebElement getReturnFlightLastButton() {
		return returnFlightLastButton;
	}

	public WebElement getDepartFlightSelectedPrice() {
		return departFlightSelectedPrice;
	}

	public WebElement getBookNowButton() {
		return bookNowButton;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getHiddonDivisionPopup() {
		return hiddonDivisionPopup;
	}
	
	public void hiddonPopupClose() {
		try {

			hiddonDivisionPopup.click();
		} catch (Exception e) {

		}
	}
	
	public void departFlightSelect()
	{
		
	}
	public void returnFlightSelect()
	{
		
	}
	public String departFlightSelectedPrice()
	{
		String price = departFlightSelectedPrice.getText();
		return price;
	}
	
	public void bookNow()
	{
		bookNowButton.click();
		continueButton.click();
	}
	
}
