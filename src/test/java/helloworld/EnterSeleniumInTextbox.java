package helloworld;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import GenericUtility.Webdriverutility;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Here search for java in google and take screenshot of that page
 * @author sachin
 *
 */
public class EnterSeleniumInTextbox {

	@Test
	public void takescrennshot() throws IOException {
		Webdriverutility wlt=new Webdriverutility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wlt.waitforpagetobeload(driver);
		driver.get("https://www.google.com/");
		
	   WebElement homepage = driver.findElement(By.xpath("//input[@name='q']"));
	   homepage.sendKeys("java",Keys.ENTER);
	   
       wlt.takescreenshot(driver);
        driver.close();
	}
}
