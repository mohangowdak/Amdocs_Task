package com.cast.AmdocsTests;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author sushmitha
 *
 */
public class MakeMyTripTest {
	
	
	@Test
	public void makeMyTrip() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//		//opening makemytrip.com 
		driver.get("https://www.makemytrip.com/");
		
		//Validating Home Page
		SoftAssert s = new SoftAssert();
		String actualTitle = driver.getTitle();
		String expectedTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		s.assertEquals(actualTitle, expectedTitle);
		System.out.println("Home Page");
		
//		//Selecting roundtrip
		driver.findElement(By.xpath("//li[@data-cy=\"roundTrip\"]")).click();
	
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();

		
//		//Sending delhi for From text
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold  appendBottom5' and text()='From']")).click();
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("mumbai");
		Thread.sleep(2000);

     	//selecting NewDelhi from Auto suggestions
		driver.findElement(By.xpath("//div[@id='react-autowhatever-1']/descendant::li[@id='react-autowhatever-1-section-0-item-0']")).click();
		
		//Sending Bengaluru for To text
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("bengaluru");
		Thread.sleep(2000);
		
		//selecting Bengaluru from Auto suggestions
		driver.findElement(By.xpath("//p[@class='font14 appendBottom5 blackText' and text()='Bengaluru, India']")).click();
		
		//Select date from calender
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10']")).click();
		
		//Selecting Departure Date
		int departureDate = 10;
		String departureMonthYear = "August";
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String departureDateXpath = "//div[text()='"+departureMonthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+departureDate+"']";
		String departureArrowXpath = "//span[@aria-label='Next Month']";

		for(;;) {
			
			try {
				
				driver.findElement(By.xpath(departureDateXpath)).click();
				break;
				
			}
			catch(Exception e) {
				driver.findElement(By.xpath(departureArrowXpath)).click();
			}
		}
		Thread.sleep(2000);
		
		//Selecting Return Date
		int returnDate = 12;
		String returnMonthYear = "November";
		
    	driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10' and text()='RETURN']")).click();
		String returnDateXpath = "//div[text()='"+returnMonthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+returnDate+"']";		
		String returnArrowXpath = "//span[@aria-label='Next Month']";
		for(;;) {
			
			try {
				
				driver.findElement(By.xpath(returnDateXpath)).click();
				break;
				
			}
			catch(Exception e) {
				driver.findElement(By.xpath(returnArrowXpath)).click();
			}
		}
		
		//clicking on search
		
		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		
		
//		driver.get("https://www.makemytrip.com/flight/search?tripType=R&itinerary=BOM-BLR-10/08/2022_BLR-BOM-12/11/2022&paxType=A-1_C-0_I-0&cabinClass=E&sTime=1654829017671&forwardFlowRequired=true&mpo=&semType=&intl=false");
		Thread.sleep(5000);

		//closing the pop up
		boolean present;
		try {
		   driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		   present = true;
		} catch (Exception e) {
		   present = false;
		}
		Thread.sleep(3000);
		
		
		//Scroll till end of the page and selecting the last flight for departure
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		int viewY = viewAll.getLocation().getY();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("((//div[@class='paneView'])[1]/descendant::button[text()='VIEW ALL' and @class='button actionBtn'])[last()]")).click();
		
		System.out.println("ViewAll successful");
		WebElement departureFlight = driver.findElement(By.xpath("((//div[@class='paneView'])[1]/descendant::span[@class='customRadioBtn'])[last()]"));
		
		int y = departureFlight.getLocation().getY();
		System.out.println(y);
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,"+y+")",departureFlight);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,"+y+")",departureFlight);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,"+y+")",departureFlight);
		Thread.sleep(2000);
		departureFlight.click();
		
		String priceString = driver.findElement(By.xpath("((//div[@class='paneView'])[1]/descendant::p[@class='blackText fontSize16 blackFont'])[last()-2]")).getText();
		String priceconv = priceString.substring(2).replace(",","");	
		int price = Integer.parseInt(priceconv);
		s.assertTrue(price>0, "price is greater than zero");
		System.out.println("price is greater than zero");
		
		
		
		//Selecting the last flight for return
		
//		int returnView = returnViewAll.getLocation().getY();
		
//		int negReturnViewY = (~(returnView-1));
//		driver.get("");
//		js.executeScript("window.scrollBy(0,-2000)");
//		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0,-2000)");
//		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0,-1000)");
		
		for(int i=0; i<9; i++) {
			js.executeScript("window.scrollBy(0,-500)", "");
		}
		Thread.sleep(3000);
		WebElement returnViewAll = driver.findElement(By.xpath("((//div[@class='paneView'])[2]/descendant::button[text()='VIEW ALL' and @class='button actionBtn'])[last()]"));
		Thread.sleep(3000);
		returnViewAll.click();
		Thread.sleep(3000);
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		
//		WebElement returnFlight = driver.findElement(By.xpath("((//div[@class='paneView'])[2]/descendant::span[@class='customRadioBtn'])[last()]"));
////		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		int y1 = returnFlight.getLocation().getY();
////		int negY1 = (~(y1-1));
////		System.out.println(negY1);
//		js.executeScript("window.scrollBy(0,"+y1+")",returnFlight);
//		returnFlight.click();
		
		//Click on Book Now
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
		
		//click on continue in the pop up
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		//click on login button
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		 String partialWinTitle = "/flight/reviewDetails";
	
		 while(it.hasNext())
		 {
			 String winId = it.next();
			 String currentWinTitle = driver.switchTo().window(winId).getTitle();
			 
			 if(currentWinTitle.contains(partialWinTitle)) {
				 break;
			 }
			 
		 }
		driver.findElement(By.xpath("//span[text()='Login or']")).click();
		
		//sending phone number in login popup
		driver.findElement(By.id("username")).sendKeys("8660937824");
		
		//clicking on continue in the login pop up
		driver.findElement(By.xpath("//span[text()='Continue']']")).click();
		
		//Entering wrong otp
		driver.findElement(By.id("otp")).sendKeys("866093");
		
		//click on Login
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();
		
		//Fetching wrong OTP message 
		String wrongOTP = driver.findElement(By.xpath("//p[@class='validity font12 redText appendTop5 makeFlex']")).getText();
		
		s.assertEquals(wrongOTP,"Incorrect OTP! Please enter the OTP delivered to you.");
		//closing browser
		driver.quit();
				
		
	}

}
