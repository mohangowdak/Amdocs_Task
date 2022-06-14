package ObjectRepositoryforyoutube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.Webdriverutility;

public class Videoplayingpage extends Webdriverutility{
	public Videoplayingpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@class='ytp-play-button ytp-button']")
	private WebElement moveonpausebutton;
	
	@FindBy(xpath="//button[@class='ytp-play-button ytp-button']")
	private WebElement clickonpausebutton;
	
	@FindBy(xpath="//span[@class='view-count style-scope ytd-video-view-count-renderer']")
	private WebElement validatesubscribers;

	public WebElement getMoveonpausebutton() {
		return moveonpausebutton;
	}

	public WebElement getClickonpausebutton() {
		return clickonpausebutton;
	}

	public WebElement getValidatesubscribers() {
		return validatesubscribers;
	}
	public void mouseoveronpause()
	{
		WebElement movetoscreen = moveonpausebutton;
		mouseoveraction(driver, movetoscreen);
	}
	
	public void clickonpausebutton()
	{
	    clickonpausebutton.click();
	}
	public void vaidatesubscriber()
	{
		String numofsubscribers = validatesubscribers.getText();
		String subscribers = numofsubscribers.replace(",", "");
		int views = Integer.parseInt(subscribers);
    	
    	if(views>1000)
    	{
    		System.out.println("no of views"+views);
    	}
	}
	
}
