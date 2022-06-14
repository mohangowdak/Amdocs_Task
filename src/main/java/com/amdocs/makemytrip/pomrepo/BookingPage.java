package com.amdocs.makemytrip.pomrepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage  {

	
	public BookingPage(WebDriver driver)
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
	
	public void loginButtonClick(String mobileNo,String otp) throws Throwable
	{
		loginButton.click();
		mobileNoTextBox.sendKeys(mobileNo);
		continueButton.click();
		enterOTPTextBox.sendKeys(otp);
		verifyAndCreateAccountButton.click();
	}
	
	public String caputureIncorrectMSG()
	{
		String exp_message = incorrectOTPMsg.getText();
		return exp_message;
	}
	

}
