
package helloworld;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import GenericUtility.Baseclass;
import GenericUtility.Webdriverutility;
import ObjectRepositoryforyoutube.Triningvideospage;
import ObjectRepositoryforyoutube.Videoplayingpage;
import ObjectRepositoryforyoutube.Youtubehomepage;
import io.github.bonigarcia.wdm.WebDriverManager;
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

	import io.github.bonigarcia.wdm.WebDriverManager;

	/**
	 * Here we search for Selenium training  videos,and play first video,pause after 15sec,
	 * validate the number of subscribers
	 * @author sachin
	 *
	 */
	public class Youtube extends Baseclass{

		    @Test
			public void SeleniumTrainingTest() throws Throwable {
	
	       
			    /*search for selenium training videos*/
			    Youtubehomepage homepage=new Youtubehomepage(driver);
		    	homepage.searchbox("Selenium Training");
		    	Thread.sleep(2000);
		    	homepage.clicksearchbutton();
		    	wutil.robotclicksearchbutton();
		    	
		    	/*here select first video */
		    	Triningvideospage allvideos=new Triningvideospage(driver);
		    	allvideos.selectfirstvideo();
		    	wutil.waitForCustomTimeOut(driver, 15);
		    	
		    	/*using mouse over action move to screen*/
		    	Videoplayingpage videopage=new Videoplayingpage(driver);
		    	videopage.mouseoveronpause();
		    	videopage.clickonpausebutton();
		    	
		    	/*print in console number of subscribers*/
		    	videopage.vaidatesubscriber();
		    	
		    	

		}

	

	}

