package amdocs.pratical_Test;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Book_Flight_In_MakeMyTrip_Test {
	
	@Test
	public void makeMyTrip() throws InterruptedException
	{
		int date1=10;
		int date2=12;
		SoftAssert sAssert = new SoftAssert();
		String src="Bangalore";
		String dest="Delhi";
		String monthandyear1="August 2022";
		String monthandyear2="November2022";
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--Disable-Notification");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//p[text()='"+src+", India']")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//p[text()='"+dest+", India']")).click();
		driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
		Thread.sleep(2000);		
		WebElement ele1 = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
		for (int i = 0; i <2; i++) 
		{
			ele1.click();
		}
		driver.findElement(By.xpath("//div[.='"+monthandyear1+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date1+"']")).click();
		driver.findElement(By.xpath("//p[.='Tap to add a return date for bigger discounts']")).click();
		WebElement ele2 = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
		for (int i = 0; i <3; i++) 
		{
			ele2.click();
		}
		driver.findElement(By.xpath("//div[.='"+monthandyear2+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date2+"']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();
		String excTitle="Flights from Bengaluru to New Delhi, and back";
		try {
			driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		} catch (Exception e) {

		}
		Thread.sleep(5000);
		String actTitle = driver.findElement(By.xpath("//p[@class='font24 blackFont whiteText appendBottom20 journey-title']")).getText();
		Thread.sleep(5000);
		sAssert.assertTrue(actTitle.contains(excTitle));
		Reporter.log(actTitle);
		sAssert.assertAll();
		Thread.sleep(5000);
		//int y = driver.findElement(By.xpath("//label[@id='flightCard-47']")).getLocation().getY();
		JavascriptExecutor j=(JavascriptExecutor) driver ;
		j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//label[@id='flightCard-47']/descendant::span[@class='customRadioBtn']")).click();

		driver.findElement(By.xpath("((//div[@class='paneView'])[1]/descendant::button[text()='VIEW ALL'])[last()]"))
		.click();
		Thread.sleep(2000);

		j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.findElement(By.xpath(
				"((//div[@class='paneView'])[1]/descendant::div[@class='listingCard ']/descendant::span[@class='customRadioBtn'])[last()]"))
		.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Book Now']"))
		.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Set<String> wins = driver.getWindowHandles();
		Iterator<String> tabs = wins.iterator();
		while (tabs.hasNext()) {
			String tab = tabs.next();
			String currntWin = driver.switchTo().window(tab).getTitle();
			if (currntWin.contains("reviewDetails"))
				break;

		}

		driver.findElement(By.xpath("//span[text()='Login or']")).click();
		driver.findElement(By.id("username")).sendKeys("9035113448");
        Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Enter OTP here']")).sendKeys("9035");

		driver.findElement(By.xpath("//button[@data-cy='verifyAndCreate']")).click();
		//driver.close();
	}

}
