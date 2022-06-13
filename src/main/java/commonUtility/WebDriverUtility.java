package commonUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	/**
	 * Select by the dropdown by index
	 * @param element
	 * @param index
	 */
	public void SelectByIndex(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * Select by the dropdown by value
	 * @param element
	 * @param value
	 */
	public void SelectByIndex(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * Select by the dropdown by text
	 * @param text
	 * @param element
	 */
	public void SelectByIndex(String text, WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * this method is used to take TakeScreenshot of webpage
	 * @param driver
	 * @throws IOException
	 */
	public void TakeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		File perm = new File("./Screenshot/"+timeStamp+"Selenium.png");
		FileUtils.copyFile(temp, perm);
	}
	/**
	 *  this method is used to take TakeScreenshot of webelement
	 * @param driver
	 * @param Xpath
	 * @param nameofWebElement
	 * @throws IOException
	 */
	public void TakeWebElementScreenshot(WebDriver driver, String Xpath,String nameofWebElement) throws IOException {
		File temp = driver.findElement(By.xpath(Xpath)).getScreenshotAs(OutputType.FILE);
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		File perm = new File("./Screenshot/"+timeStamp+nameofWebElement+".png");
		FileUtils.copyFile(temp, perm);
	}
	/**
	 * this method developed for wait for webElements to load on Webpages
	 * @param driver
	 */
	public void implictilyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * this method is used to wait for to load Webelements
	 * @param timeInMiliseconds
	 * @throws InterruptedException
	 */
	public void customWait(long timeInMiliseconds) throws InterruptedException {
		Thread.sleep(timeInMiliseconds);
	}
	public void switchToWindow(WebDriver driver, int index) {
		
		Set<String> windowId = driver.getWindowHandles();
		ArrayList<String> ActualWindow= new ArrayList<String>(windowId);
		driver.switchTo().window(ActualWindow.get(index));
	}
}
