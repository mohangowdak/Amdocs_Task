package Amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task4 {
	@Test
	public void ddd()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//click on search bar and pass toys as input
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Toys");
		
		//click on search button
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		
		String winid = driver.getWindowHandle();
		String acttile = driver.switchTo().window(winid).getCurrentUrl();
		
		String exptitle = "Amzon toys ";
		Assert.assertEquals(acttile, exptitle, "Assertion is passed");
	
		
		System.out.println(acttile);
		driver.close();
		
	}

}
