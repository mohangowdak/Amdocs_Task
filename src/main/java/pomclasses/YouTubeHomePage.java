package pomclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.WebDriverUtility;

public class YouTubeHomePage {
	
	@FindBy(xpath="//input[@id='search']")
	private WebElement youTubeSeachButton;
	
	@FindBy(xpath="//yt-formatted-string[@class='style-scope ytd-video-renderer']")
	private WebElement firstVideoInYouTube;
	
	public YouTubeHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getYouTubeSeachButton() {
		return youTubeSeachButton;
	}

	public WebElement getFirstVideoInYouTube() {
		return firstVideoInYouTube;
	}
	
	public void ClickOnFirstVideo(String SearchName) throws InterruptedException, AWTException {
		youTubeSeachButton.sendKeys(SearchName);
		WebDriverUtility wb=new WebDriverUtility();
		wb.customWait(2000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		firstVideoInYouTube.click();
		wb.customWait(15000);
	}

}
