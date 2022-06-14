package GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author sachin
 *
 */
public class Webdriverutility {
  
	public WebDriver driver;
	/**
	 * using this method we can capture the screenshot of failed test scripts
	 * @param driver
	 * @param homepage
	 * @throws IOException
	 */
	public void takescreenshot(WebDriver driver) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./scrennshot/abc.PNG");
		FileUtils.copyFile(src, dest);
	}
	/**
	 * using this method maximize the window
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * using this method to wait for element to be load in UI
	 * @param driver
	 */
	public void waitforpagetobeload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}
	/**
	 * using for this method to click particular element in UI
	 * @param driver
	 * @param element
	 */
	public void elementtobeclick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * using this method it will wait custom time
	 * @param driver
	 * @param pollingTime
	 * @throws Throwable
	 */
	public void waitForCustomTimeOut(WebDriver driver,int pollingTime) throws Throwable {
    	FluentWait wait=new FluentWait(driver);
    	wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
    	
    	
    }

	/**
	 * using this method to achieve window handling
	 * @param driver
	 * @param partialtitle
	 */
	public void switchtowindow(WebDriver driver,String partialtitle) 
	{
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while(it.hasNext())
		{
			String wib = it.next();
			driver.switchTo().window(wib);
			String currenttitle = driver.getTitle();
			if(currenttitle.contains(partialtitle));
		}
	}
	/**
	 * using this method capture the window title
	 * @param driver
	 * @param windowtitle
	 */
	public void capturewindowtitle(WebDriver driver,String windowtitle)
	{
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while(it.hasNext())
		{
			String wib = it.next();
			driver.switchTo().window(wib);
			String currenttitle = driver.getTitle();
			if(currenttitle.contains(windowtitle));
		}
	}
	/**
	 * using java scripts method to achieve scroll down handling
	 * @param driver
	 * @param string 
	 */
	public void ExecutejavaScript(WebDriver driver, String string) {
  		JavascriptExecutor js=(JavascriptExecutor)driver;
  		js.executeScript(string,"window.scrollBy(0,310);");
  	}
		/**
		 * using actions class to move on particular element
		 * @param driver
		 * @param element
		 */
		public void mouseoveraction(WebDriver driver,WebElement element)
		{
		Actions action=new Actions(driver);
		action.moveToElement(element);
	   }
		/**
		 * using robot class to click particular search button
		 * @throws Throwable
		 */
		public void robotclicksearchbutton() throws Throwable
		{
			Robot rt=new Robot();
			rt.keyPress(KeyEvent.VK_ENTER);
		}
}
