package com.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/*
 * This class contains all generic method of WebDriver
 */
public class WebDriverUtility {
	
	JavaUtility jUtil = new JavaUtility();
	
	/*
	 * This method is used to take screenshot
	 */
	public void screenShot(WebDriver driver) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc  = new File("./src/test/resources/screenshot/"+jUtil.randomNum()+".png");
		Files.copy(src, desc);
	}
	
	/* 
	 * This method will perform implicit wait
	 */
	public void implicitWait(WebDriver driver, int custom_time)
	{
		driver.manage().timeouts().implicitlyWait(custom_time, TimeUnit.SECONDS);
	}
	
	/* 
	 * This method will perform explicit wait for element to be clickable
	 */
	public void elementToClick(WebDriver driver, int custom_time, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, custom_time);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void elementVisibility(WebDriver driver, List<WebElement> listAutoSuggestion, int custom_time)
	{
		WebDriverWait wait = new WebDriverWait(driver, custom_time);
		wait.until(ExpectedConditions.visibilityOfAllElements(listAutoSuggestion));
	}

	/*
	 * This method will switch window
	 */
	public void switchToWindow(WebDriver driver, String title)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> id= allId.iterator();
		
		while(id.hasNext())
		{
			String cWID = id.next();
			driver.switchTo().window(cWID);
			String tit = driver.getTitle();
			if(tit.contains(title))
			{
				break;
			}
			
		}
	}
	
	/*
	 * This method of actions class to move mouse cursor to a specific element
	 */
	public void moveToSpecificElement(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
	}
	
	/*
	 * This method will perform action based on index value of select class
	 */
	public void selectValue(WebElement ele, int index)
	{
	Select s = new Select(ele);
	s.selectByIndex(index);
	}
	
	/*
	 * This method will perform action based on value value of select class
	 */
	public void selectValue(WebElement ele, String value)
	{
	Select s = new Select(ele);
	s.selectByValue(value);
	}
	
	/*
	 * This method will perform action based on visible text value of select class
	 */
	public void selectValue(String value, WebElement ele)
	{
	Select s = new Select(ele);
	s.selectByVisibleText(value);
	}
	
	/*
	 * This method will switch to window without using title
	 */
	public void switchWindowWithoutTitle(WebDriver driver)
	{
		String main_id = driver.getWindowHandle();
		 Set<String> all_id = driver.getWindowHandles();
		 
		 for(String id: all_id)
		 {
			 if(!main_id.equals(id))
			 {
				 driver.switchTo().window(id);
			 }
	}
	}
	
	/*
	 * This method will scroll into particular element
	 */
	public void scrollIntoViewWindow(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("argumens[0].scrollIntoView(true);", ele);
	}

}
