package day1;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commonUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchForSelenuiumInChrome {

	public static void main(String[] args) throws IOException {
		
		WebDriverUtility wb= new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wb.implictilyWait(driver);
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.name("btnK")).click();
		
		wb.TakeScreenshot(driver);
		driver.close();
	}

}
