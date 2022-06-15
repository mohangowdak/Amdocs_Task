package GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.*;

public class BaseClass2 {
	public class BaseAnnotationClassCB {

		/* create Objects */
		public PropertyFileUtility flib = new PropertyFileUtility();
		public WebDriverUtility wlib = new WebDriverUtility();
		public ExcelFileUtility eLib = new ExcelFileUtility();
		public WebDriver driver = null;
		//public static WebDriver sdriver = null;

		@BeforeSuite
		public void configBS() {
			System.out.println("connect to database");
		}

		@Parameters("BROWSER")
		@BeforeClass
		public void configBC(String BROWSER) throws Throwable {
			System.out.println("Launch the Browser");
			
			
			/* launch the browser */
			//String BROWSER = flib.readDatafromPropertyfile("browser");
			if (BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("firefox")) {

				
				driver = new FirefoxDriver();
			}
			wlib.maximizeWindow(driver);
			
			wlib.waitForPageLoad(driver);
			String URl = flib.readDataFromPropertyFile("url");
			
			driver.get(URl);

			//sdriver = driver;

		}

		@BeforeMethod
		public void configBM() throws IOException {

			//System.out.println("Login to application");

		}

		@AfterMethod
		public void configAM() {

			//System.out.println("Logout out to application");
			

		}

		@AfterClass
		public void configAC() {

			System.out.println("Close the Browser");
			/* close the browser */
			driver.quit();

		}

		@AfterSuite
		public void configAS() {
			System.out.println("close the database");
		}

	}

}
