package day2;

import java.awt.Window;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is select DEPARTURE location and RETURN location and date and time and select last flight click
 * on book now and continue and click on login button and enter the mobile number and click on continue and 
 * enter the WRONG OTP verify error message. 
 * @author CHANNAKESHVA REDDY
 *
 */
public class SelectFlightOnMakeMyTripTest {
	
	@Test
	public void selectFlightOnMakeMyTripTest() throws InterruptedException {
		
		String DEPARTUREdate="10";
		String DEPARTUREmonthAndYear="August 2022";
		
		String RETURNdate="10";
		String RETURNmonth="November";
		String RETURNYear="2022";
		
		String ExpectedHomePageTitle="MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		String ExpectedTitle="MakeMyTrip";
		
        WebDriverUtility wb= new WebDriverUtility();
		
        WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//wb.implictilyWait(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		/**
		 * Validating the Home page Title
		 */
		String AtcualHomePageTitle=driver.getTitle();
		Assert.assertEquals(ExpectedHomePageTitle, AtcualHomePageTitle);
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		wb.customWait(2000);
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Delhi");
		wb.customWait(2000);
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
			
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		wb.customWait(1000);
		/**
		 * This for loop is used to select particular date, month and Year for DEPARTURE
		 */
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+DEPARTUREmonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+DEPARTUREdate+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		wb.customWait(1000);
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		wb.customWait(1000);
		/**
		 * This for loop is used to select particular date, month and Year for RETURN
		 */
		for(;;) {
			try {
				driver.findElement(By.xpath("//span[text()='"+RETURNYear+"']/parent::div[text()='"+RETURNmonth+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+RETURNdate+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		wb.customWait(2000);
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("TITLE IS VERFIRED");
		/**
		 * for notification popup
		 */
		try {
			driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		} catch (Exception e) {}
		/**
		 * it will select last flight and click on radio button
		 */
	    WebElement returnFlight = driver.findElement(By.xpath("(//span[@class='boldFont blackText'])[last()-1]/ancestor::div[@class='listingCard ']/descendant::span[@class='customRadioBtn']"));
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", returnFlight);
	    returnFlight.click();
	    
//	    wb.customWait(2000);
//	    WebElement depetureFlight = driver.findElement(By.xpath("(//span[@class='boldFont blackText'])[last()-71]/ancestor::div[@class='listingCard ']/descendant::span[@class='customRadioBtn']"));
//	    js.executeScript("arguments[0].scrollIntoView(true);", depetureFlight);
//	    depetureFlight.click();
	    
	    List<WebElement> Allprices = driver.findElements(By.xpath("//span[@class='whiteText blackFont fontSize16']"));
	    for (WebElement price : Allprices) {
			System.out.println("PRICE OF FLIGTH : "+price.getText());
		}
	    wb.customWait(2000);
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		wb.customWait(5000);
		/**
		 * Here we switching to new window
		 */
		Set<String> windowId = driver.getWindowHandles();
		ArrayList<String> ActualWindow= new ArrayList<String>(windowId);
		driver.switchTo().window(ActualWindow.get(1));
		
		driver.findElement(By.xpath("//span[text()='Login or']")).click();
		driver.findElement(By.id("username")).sendKeys("9845355967");
		wb.customWait(5000);
		
		WebElement Continue = driver.findElement(By.xpath("//span[text()='Continue']"));
		js.executeScript("arguments[0].click();", Continue);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter OTP here']")).sendKeys("129152");
		driver.findElement(By.xpath("//span[text()='Verify & Create Account']")).click();
		System.out.println("================================Done=============================================================");
	}

}
