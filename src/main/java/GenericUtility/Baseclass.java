package GenericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public WebDriver driver=null;
	public Fileutility fil=new Fileutility();
	public Webdriverutility wutil=new Webdriverutility();
	public Excelutility exl=new Excelutility();

	@BeforeTest
	public void beforetest() throws Throwable
	{
		String browser1= fil.fetchcommondata("browser");
		   String amazon = fil.fetchcommondata("url");
		    String youtube = fil.fetchcommondata("url3");
		    String google = fil.fetchcommondata("url2");
			if(browser1.equals("chrome")){
				WebDriverManager.chromedriver().setup();
				driver =new ChromeDriver();
				}else if(browser1.equals("edge")) {
					WebDriverManager.edgedriver().setup();
					driver =new FirefoxDriver();
					}else {
					throw new Exception("browser is not compatible");
				}
			driver.get(amazon);
			driver.manage().deleteAllCookies();
			wutil.waitforpagetobeload(driver);
			wutil.maximize(driver);

	}
	
	
	@AfterTest 
	public void aftertest()
    {
		driver.close();	
	}
	
	
}
	
	



	

