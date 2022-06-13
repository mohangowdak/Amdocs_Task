package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import commonUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriverUtility wu= new WebDriverUtility();
	public WebDriver driver=null;
	String browser="chrome";
	@BeforeClass
	//@Parameters("Browser")
	public void bs() {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			wu.implictilyWait(driver);
			driver.manage().window().maximize();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			wu.implictilyWait(driver);
			driver.manage().window().maximize();
		}
		else {
			System.out.println("IT SUPPOTR FOR ONLY TWO BROWSER");
		}
	}
	@AfterClass
	public void ac() {
		driver.quit();
	}

}
