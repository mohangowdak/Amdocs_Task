package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouTubeVideoPlayingPage {
	
	@FindBy(xpath="//button[@class='ytp-play-button ytp-button']")
	private WebElement pauseButton;
	
	@FindBy(xpath="//span[@class='view-count style-scope ytd-video-view-count-renderer']")
	private WebElement numberOfSubscriber;
	
	public YouTubeVideoPlayingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPauseButton() {
		return pauseButton;
	}

	public WebElement getNumberOfSubscriber() {
		return numberOfSubscriber;
	}
	
	public void playingTheVideoAndTakingNumberSubscriber(WebDriver driver) {
		Actions ac=new Actions(driver);
		ac.moveToElement(pauseButton).perform();
		pauseButton.click();
		String NumberOfSub=numberOfSubscriber.getText();
		String actual = NumberOfSub.replace(",", "").substring(0,6);
		int views = Integer.parseInt(actual);
		if(views>1000) {
			System.out.println("Number of Views : "+views);
		}
		
	}

}
