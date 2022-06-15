package Amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericLibrary.WebDriverUtility;
import ObjectRepository.HomePage;
import ObjectRepository.SearchPage;
import ObjectRepository.VideoPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Task3 {

	@Test
	public void practicalTest() throws Throwable {
		WebDriver driver=null;
		/* Navigate to homepage */
		HomePage hp = new HomePage(driver);
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.waitForPageLoad(driver);

		
		//click on search bar and pass selenium training.
		hp.searchIteam(driver, "Selenium Training");
		Thread.sleep(1000);
		
		//click on search button
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		
		//click on first video link
		SearchPage sp = new SearchPage(driver);
		sp.getFirstVideo().click();
		
		Thread.sleep(20000);
		VideoPage vp = new VideoPage(driver);
		vp.getPlayBtn().click();

		String[] subCount = driver.findElement(By.id("owner-sub-count")).getText().split(" ");

		Assert.assertTrue(subCount[0].contains("K") || subCount[0].contains("M"),"Subscribers less than thousand");
		System.out.println("Subscribers : "+subCount[0]);
		driver.quit();
	}
}