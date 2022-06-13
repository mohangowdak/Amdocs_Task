package amdocs.pratical_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayFirstVideoInYoutube_Test {

	@Test
	public void playFirstVideoInYoutube() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		SoftAssert sAssert = new SoftAssert();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Selenium Training");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='style-scope ytd-search-pyv-renderer']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
		Thread.sleep(2000);
		String[] subCount = driver.findElement(By.id("owner-sub-count")).getText().split(" ");
		sAssert.assertTrue(subCount[0].contains("K") || subCount[0].contains("M"),"Subscribers less than thousand");
		System.out.println("Subscriber is more than"+"=>"+subCount[0]);
        driver.close();
	}

}
