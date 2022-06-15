package genericLibrary;


    import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.google.common.io.Files;

	/**
	 * This class consists of all generic methods related to webDriverActions
	 * @author Madhu
	 *
	 */

	public class WebDriverUtility
	{
		/**
		 * This method will maximize the window
		 * @param driver
		 */
		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		/**
		 * This method will wait for 20 seconds for the page to load
		 * @param driver
		 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                        
	}
	/**
	 * This method will wait for 20 seconds for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will select data from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(0);
	}
	/**
	 * This method will select data from dropdown using visible text
	 * @param value
	 * @param
	 */
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will select data from dropdown using visible text
	 * @param value
	 * @param element
	 */
	public void select(String value, WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public String selectGetFistOption(WebElement element)
	{
		Select s = new Select(element);
		 return (s.getFirstSelectedOption().getText());
	}
	/**
	 * This method will perform mouse Hover action
	 * @param driver
	 * @param element
	 */
	public void MouseHover(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform drag and drop action 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	/**
	 * This method will double on webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will right click on webpage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will press enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method will press enter key
	 * @param driver
	 * @throws Throwable
	 */
	public void  enterKey(WebDriver driver) throws Throwable
	{
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will release enter key
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch the frame based or name or ID
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will switch the frame based on address of the element
	 * @param driver
	 * @param address
	 */
	public void switchToFRame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * This method will accept alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel the alert pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will switch to window depending on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
		public void switchToWindow(WebDriver driver, String partialWinTitle)
		{
			//step 1: use getWindwoHandles to capture all window ids
			Set<String> windows = driver.getWindowHandles();
			
			//step 2" iterate through the window
			Iterator<String> it = windows.iterator();
			
			//step 3: check whether there is next window
			while(it.hasNext())
			{
				//step 4: capture current window id
				String winId = it.next();
				
				//step 5: switch to current window and capture title
				String currentWinTitle = driver.switchTo().window(winId).getTitle();
				
				//step 6: check whether the current window is expected
				if(currentWinTitle.contains(partialWinTitle))
				{
					break;
				}		
		}	
	}
		/**
		 * This method will take screenshot and store it in folder called as screenshot
		 * @param driver
		 * @param screenShotName
		 * @throws Throwable 
		 */
		public String getscreenShot(WebDriver driver, String screenShotName) throws Throwable
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
		    File src = ts.getScreenshotAs(OutputType.FILE);
			File dst=new File("./Screenshot"+screenShotName+".png");
	         Files.copy(src, dst);
	         
	         return dst.getAbsolutePath();
		}
		/**
		 * This method perform random scroll
		 * @param driver
		 */
		public void scrollAction(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 500)","");
		}
		/**
		 * This method will scroll until the specified element is found
		 * @param driver
		 * @param element
		 */
		public void scrollAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			 int y = element.getLocation().getY();
			 js.executeScript("window.scrollBy(0,"+y+")", element);
			 //js.executeScript("arguments[0].scrollIntoview()",element"
			 }
		
		public void waitAndClick(WebElement element) throws InterruptedException
		{
			int count = 0;
			while (count < 20) {
				try {
					element.click();
					break;
				} catch (Throwable e) {
					Thread.sleep(1000);
					count++;
				}
			
			
			}}}

