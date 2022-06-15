package MakeMyTrip;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightBooking {
	
	static WebDriver driver;

	@Test
	public void bookTicket() throws InterruptedException {
		String from = "Bengaluru";
		String to = "Delhi";
		String departmonth = "August";
		String departDate = "10";
		String returnmonth = "November";
		String returnDate = "12";
		
		//Lauching browser
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//open makemytrip website
		driver.get("https://www.makemytrip.com/");

		
		//driver.findElement(By.className("langCardClose")).click();
		
		//click on roundtrip radio button
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		
		//choose from city
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		// Thread.sleep(1000);

		//here passing bangalore as from location
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
		
		//click on bangalore location , this takes as dynamic
		driver.findElement(By.xpath("//p[contains(text(),'" + from + "') and @class='font14 appendBottom5 blackText']")).click();

		//choose to city
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		Thread.sleep(1000);
		
		//here passing Delhi as to location
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
		
		//click on Delhi location , this takes as dynamic
		driver.findElement(By.xpath("//p[contains(text(),'" + to + "') and @class='font14 appendBottom5 blackText']")).click();
		
		calender(departmonth, departDate);
		calender(returnmonth, returnDate);
		
		//click on search button
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		//handling window popup
		try {

			driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();

		} catch (Exception e) {

		}

		//fetching first panel view and get all flights
		List<WebElement> actual = driver.findElements(By.xpath("//div[@class='paneView']/p"));
		
		//fetching each flight and store it to another variable
		for (WebElement act : actual) {
			
			System.out.println(act.getText());
		}
		
		//This is to used for scrolling action till end of the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		//scroll till the end of the page & click on view all 
		driver.findElement(By.xpath("((//div[@class='paneView'])[1]/descendant::button[text()='VIEW ALL'])[last()]")).click();
		Thread.sleep(2000);

		//again scroll down till end
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		//click on radio button
		driver.findElement(By.xpath("((//div[@class='paneView'])[1]/descendant::div[@class='listingCard ']/descendant::span[@class='customRadioBtn'])[last()]")).click();
		
		Thread.sleep(1000);
		
		//click on book now button
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
		
		//click on continue button
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		//switch to another window
		Set<String> wins = driver.getWindowHandles();
		
		//Iterating for windows
		Iterator<String> tabs = wins.iterator();
		while (tabs.hasNext()) {
			String tab = tabs.next();
			//get title of current window
			String currntWin = driver.switchTo().window(tab).getTitle();
			
			//if current window title contains review details , then give break
			if (currntWin.contains("reviewDetails"))
				break;

		}
		
		//click on login button
		driver.findElement(By.xpath("//span[text()='Login or']")).click();
		
		//pass your mobile number
		driver.findElement(By.id("username")).sendKeys("8970906524");
		
		//click on continue button
		driver.findElement(By.xpath("//span[.='Continue']")).click();
		Thread.sleep(2000);
		
		//send OTP here
		driver.findElement(By.xpath("//input[@placeholder='Enter OTP here']")).sendKeys("3735");
		
		//click on verify button
		driver.findElement(By.xpath("//button[@data-cy='verifyAndCreate']")).click();
	}


	//This is to handle calender using infinite for loop
	static public void calender(String month, String Date) {
		for (;;) {
			try {
				//Select month and date
				driver.findElement(By.xpath("//div[text()='" + month + "']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='" + Date + "']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
	}

}
