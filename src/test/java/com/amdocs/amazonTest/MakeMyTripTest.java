package com.amdocs.amazonTest;


import com.amdocs.amazon.genericUtils.BaseAnnotationClass;
import com.amdocs.makemytrip.pomrepo.BookingPage;
import com.amdocs.makemytrip.pomrepo.FlightBookingPage;
import com.amdocs.makemytrip.pomrepo.HomePage;


import org.openqa.selenium.JavascriptExecutor;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MakeMyTripTest  extends BaseAnnotationClass{


	@Test
	public void bookTrip() throws Throwable {
		

		
		
		String act_Title = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		String exp_Title = driver.getTitle();
		SoftAssert asser = new SoftAssert();
		asser.assertEquals(act_Title, exp_Title);
		System.out.println(exp_Title);

		HomePage homePage = new HomePage(driver);

		homePage.roundTripFromTo();
		homePage.selectFromToDate("August", 10, driver);
		homePage.selectFromToDate("November", 12, driver);
		homePage.search();

		FlightBookingPage ffBToDel = new FlightBookingPage(driver);
		ffBToDel.hiddonPopupClose();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(5000);
		ffBToDel.departFlightSelect();
		ffBToDel.returnFlightSelect();

		String price = ffBToDel.departFlightSelectedPrice();
		System.out.println(price);
		Thread.sleep(12000);
		ffBToDel.bookNow();

		wlib.switchToWindow(driver, "reviewDetails");
		BookingPage cBook = new BookingPage(driver);
		cBook.loginButtonClick("9035113448", "9035");

		String actual_message = "Incorrect OTP Entered. Please try again.";
		String exp_message = cBook.caputureIncorrectMSG();
		asser.assertEquals(actual_message, exp_message);
		Reporter.log(exp_message, true);
		driver.quit();
	}

}
