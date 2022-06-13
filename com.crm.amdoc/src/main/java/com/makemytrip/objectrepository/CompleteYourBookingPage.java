package com.makemytrip.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutility.ExcelUtility;

public class CompleteYourBookingPage {
	
	ExcelUtility eLib = new ExcelUtility();
	
	public CompleteYourBookingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='makeFlex spaceBetween column']")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement mobileNoTextBox;
	
	@FindBy(xpath="//button[@class='capText font16']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@placeholder='Enter OTP here']")
	private WebElement enterOTPTextBox;
	
	@FindBy(xpath="//span[text()='Verify & Create Account']")
	private WebElement verifyAndCreateAccountButton;
	
	@FindBy(xpath="//span[@class='appendRight5 popupSprite errorCross']")
	private WebElement incorrectOTPMsg;

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getMobileNoTextBox() {
		return mobileNoTextBox;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getEnterOTPTextBox() {
		return enterOTPTextBox;
	}

	public WebElement getVerifyAndCreateAccountButton() {
		return verifyAndCreateAccountButton;
	}

	public WebElement getIncorrectOTPMsg() {
		return incorrectOTPMsg;
	}
	
	//Business Logic
	
	public void loginButtonClick() throws Throwable
	{
		loginButton.click();
		mobileNoTextBox.sendKeys(eLib.getDataFromExcel("Sheet3", 1, 0));
		continueButton.click();
		enterOTPTextBox.sendKeys(eLib.getDataFromExcel("Sheet3", 1, 1));
		verifyAndCreateAccountButton.click();
	}
	
	public String caputureIncorrectMSG()
	{
		String exp_message = incorrectOTPMsg.getText();
		return exp_message;
	}
	

}
