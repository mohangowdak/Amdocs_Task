package amdocs.pratical_Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchForToysInAmazon_Test {
	
	@Test
	public void searchForToys() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		SoftAssert sAssert = new SoftAssert();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("toys");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		driver.findElement(By.xpath("//a[text()='Price: Low to High']")).click();
		String price = driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']/descendant::span[@class='a-price-whole']")).getText();
		int actPrice=Integer.parseInt(price);
		sAssert.assertTrue(actPrice<100);
		System.out.println(actPrice);
		sAssert.assertAll();
		driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']")).click();
		String text = driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']/descendant::span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
		Set<String> winid = driver.getWindowHandles();
		   for (String id: winid) {
			  String data=driver.switchTo().window(id).getTitle();
			  if(data.contains(text))
			  {
				  break;
				  
			  }
		}
		WebElement ele = driver.findElement(By.xpath("//select[@id='quantity']"));
		Select s= new Select(ele);
		WebElement firstopt = s.getFirstSelectedOption();
		String quantity = firstopt.getText();
		int actQuan = Integer.parseInt(quantity);
		sAssert.assertEquals(actQuan, 8);
		System.out.println(actQuan);
		sAssert.assertAll();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		String actTitle = driver.findElement(By.xpath("//div[@class='a-row a-carousel-header-row a-size-medium _smart-wagon-card_style_recommendationHeadingSponsored__HDqGs']/descendant::h1[@class='a-carousel-heading a-inline-block a-text-normal']")).getText();
		String expTitle=actTitle;
		sAssert.assertEquals(expTitle, actTitle);
		System.out.println(actTitle);
		sAssert.assertAll();
		driver.quit();
		
	}

}
