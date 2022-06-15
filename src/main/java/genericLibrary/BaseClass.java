package genericLibrary;

	import java.io.IOException;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Reporter;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;


	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass 
	{

		//create Object of all Utilities
		public ExcelFileUtility eLib=new ExcelFileUtility();
		public PropertyFileUtility pLib=new PropertyFileUtility();
		public WebDriverUtility wLib=new WebDriverUtility();
		public WebDriver driver=null;
		public static WebDriver sDriver;
			
		@BeforeSuite
		public void configBS() {
			System.out.println("=========connect to database=======");
		}

		//@Parameters("BROWSER")
		@BeforeClass
		public void configBC() throws Throwable {
			System.out.println("======Launch the Browser=======");
			
			
			/* launch the browser */
			String BROWSER = pLib.readDatafromPropertyfile("browser");
			if (BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}			
			wLib.waitForPageLoad(driver);
			String URl = pLib.readDatafromPropertyfile("url2");
			driver.get(URl);
			sDriver = driver;

		}

		@BeforeMethod
		public void configBM() throws IOException {

			//System.out.println("==========Login to application============");
		}

		@AfterMethod
		public void configAM() {

			//System.out.println("=============Logout out to application =============");
		}

		@AfterClass
		public void configAC() {

			System.out.println("========Close the Browser========");
			/* close the browser */
			driver.quit();
		}

		@AfterSuite
		public void configAS() {
			System.out.println("=========close the database=======");
		}

	}