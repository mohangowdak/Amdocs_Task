package day2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import commonUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomclasses.BaseClass;
import pomclasses.GooglePage;
import pomclasses.LoginPage;
import pomclasses.YouTubeHomePage;
import pomclasses.YouTubeVideoPlayingPage;
/**
 * This Script is developed to To play video in youtube and and Check number of views
 * @author CHANNAKESHVA REDDY
 *
 */
public class SeleniumTrainingTest extends BaseClass{

	    @Test
		public void seleniumTrainingTest() throws InterruptedException, AWTException {
	    /**
	    * Creating LoginPage object and call the LoginPage non-static method and provide the driver reference and url
	    * Here we navigate to amazon Homepage
	    */
	    LoginPage lp=new LoginPage();
	    lp.LoginPage(driver, "https://www.google.com");
	    /**
	     * Here we click on YouTube icon
	     */
	    GooglePage googlePage=new GooglePage(driver);
	    googlePage.clickOnYouTube(driver);
	    /**
	     * Here we Enter Selenium Training in Search Box
	     */
	    YouTubeHomePage youTubeHomePage = new YouTubeHomePage(driver);
	    youTubeHomePage.ClickOnFirstVideo("Selenium Training");
	    /**
	     * Here we playing video for 15 Seconds and also printing number of Subscriber
	     */
	    YouTubeVideoPlayingPage youTubeVideoPlayingPage = new YouTubeVideoPlayingPage(driver);
	    youTubeVideoPlayingPage.playingTheVideoAndTakingNumberSubscriber(driver);

	}

}
