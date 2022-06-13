package makemytrip;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.genericutility.WebDriverUtility;
import com.makemytrip.objectrepository.CompleteYourBookingPage;
import com.makemytrip.objectrepository.FlightsfromBengalurutoNewDelhi;
import com.makemytrip.objectrepository.MakeMyTripHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {

	@Test
	public void bookTrip() throws Throwable {
		WebDriverUtility wLib = new WebDriverUtility();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wLib.implicitWait(driver, 20);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.makemytrip.com/");
		String act_Title = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		String exp_Title = driver.getTitle();
		SoftAssert asser = new SoftAssert();
		asser.assertEquals(act_Title, exp_Title);
		System.out.println(exp_Title);

		MakeMyTripHomePage homePage = new MakeMyTripHomePage(driver);

		homePage.roundTripFromTo();
		homePage.selectFromToDate("August", 10, driver);
		homePage.selectFromToDate("November", 12, driver);
		homePage.search();

		FlightsfromBengalurutoNewDelhi ffBToDel = new FlightsfromBengalurutoNewDelhi(driver);
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

		wLib.switchWindowWithoutTitle(driver);
		CompleteYourBookingPage cBook = new CompleteYourBookingPage(driver);
		cBook.loginButtonClick();

		String actual_message = "Incorrect OTP Entered. Please try again.";
		String exp_message = cBook.caputureIncorrectMSG();
		asser.assertEquals(actual_message, exp_message);
		Reporter.log(exp_message, true);
		driver.quit();
	}

}
