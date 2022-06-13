package amdocs.pratical_Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.jsoup.parser.ParseError;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchForArtsAndCraftsInAmazon_Test {

	@Test
	public void searchForArtsAndCraftsInAmazon() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("arts and crafts");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='s-suggestion s-suggestion-ellipsis-direction'])[4]")).click();
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']"));
		String text=ele.getText();
		ele.click();
		Set<String> winid = driver.getWindowHandles();
		for (String id: winid) {
			String data=driver.switchTo().window(id).getTitle();
			if(data.contains(text))
			{
				break;
			}
		}
		String price = driver.findElement(By.xpath("//div[@id='corePrice_desktop']/descendant::span[@class='a-price a-text-price a-size-medium apexPriceToPay']")).getText();
		price=price.substring(1);
	    float price1 = Float.parseFloat(price);
		SoftAssert soft = new SoftAssert();
		boolean flag=false;
		if(price1>500)
		{
			flag=true;
		}
		soft.assertTrue(flag);
		System.out.println("the price is gratter than 500"+"=>"+price); 
		soft.assertAll();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(2000);
		String actTitle = driver.findElement(By.xpath("//div[@class='a-row a-carousel-header-row a-size-medium _smart-wagon-card_style_recommendationHeadingSponsored__HDqGs']/descendant::h1[@class='a-carousel-heading a-inline-block a-text-normal']")).getText();
		String excTitle=actTitle;
		soft.assertEquals(actTitle, excTitle);
		System.out.println(actTitle);
		soft.assertAll();
		driver.quit();
	}

}
