package Amazon;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 {
	@Test

	public void toys() throws Throwable
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		//pass toys as input in search bar
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("toys");

		//click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();

		//select dropdown button
		driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();
		Thread.sleep(3000);

		//select low to high option from drop down
		driver.findElement(By.xpath("//a[@id='s-result-sort-select_1' and @class='a-dropdown-link']")).click();

		//click on first product 
		driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/descendant::div[@data-index='2']")).click();

		//in order to switch to other windows
		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> itr=winIds.iterator();

		while(itr.hasNext())
		{
			String chwin = itr.next();
			if(winIds.equals(chwin))
			{
				String chtitle = driver.switchTo().window(chwin).getTitle();
				System.out.println(chtitle);
			}
		}
		Thread.sleep(3000);
		//click on add to cart to add the product
		driver.findElement(By.xpath("//input[@id='add-to-cart-button' and @class='a-button-input']")).click();

		//click on add to cart to view the product
		driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']")).click();

	}

}
