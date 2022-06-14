package helloworld;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemytrip 
{

	@Test
	
	public void bookflight() throws InterruptedException {
		
	
	
		String MonthAndYear="Aug 2022";
		String date="10";
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Actions action=new Actions(driver);
		action.moveByOffset(20, 20).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']/descendant::span[@class='tabsCircle appendRight5']")).click();
		/*givein name  */
		 driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//p[text()='Bangalore, India']")).click();
		 driver.findElement(By.xpath("//label[@for='toCity']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[@class='calc60']/descendant::p[text()='Mumbai, India']")).click();
		
		 
		 
		 //driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		  
		
		  driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		  Thread.sleep(1000);
			driver.findElement(By.xpath("//div[text()='August']/ancestor::div[@class='DayPicker-Month']/descendant::div[@class='dateInnerCell']/following::p[text()='18']")).click(); 
			
		
		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollby(0,3000);");
	}
			 
	}


