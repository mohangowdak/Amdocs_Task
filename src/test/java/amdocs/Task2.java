package amdocs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AddToCartPage;
import objectRepository.CartPage;
import objectRepository.HomePage;
import objectRepository.ProductPage;
import objectRepository.SearchPage;

public class Task2 extends BaseClass
{
	@Test
	public void task2() throws Throwable
	{
		String itemToSearch = eLib.getDataFromExcel("Task2", 1, 0);
		WebDriver driver=null;
		/* Navigate to homepage */
		HomePage homePage = new HomePage(driver);
		wLib.waitForPageLoad(driver);

		/* Enter the value to search */
		homePage.searchIteam(driver, itemToSearch);

		/*Sort the item  from low to high price*/
		SoftAssert s = new SoftAssert();
		SearchPage searchPage = new SearchPage(driver);
		searchPage.getFilterPrice().click();
		searchPage.getFilterPriceOptions().click();
		

		/* validate the prices is greater than 100 */

		
		WebElement sh_price = searchPage.getPrices();
		String actPrice = sh_price.getText();
		int actPriceInt = Integer.parseInt(actPrice);
		s.assertTrue(actPriceInt < 100, "Price is greater than 100");
		System.out.println("The product price" + actPrice);

		/* Select the product */
		sh_price.click();
		String actualProdName = searchPage.getproductNAme().getText();
		wLib.switchToWindow(driver, actualProdName);

		/*Validate the quantity*/
		ProductPage productPage = new ProductPage(driver);
		String quantity = wLib.selectGetFistOption(productPage.getQuantity());
		int actQuan = Integer.parseInt(quantity);
		s.assertEquals(actQuan, 8);
		System.out.println(actQuan);
		
		
		/* Add the product to cart */
		
		String expectedProdName = productPage.getProdName().getText();
		productPage.getAddToCartBtn().click();
		
		
		/* Go to cart */
		AddToCartPage ap = new AddToCartPage(driver);
		ap.getGoToCartBtn();

		/* Validate the product in the cart */
		CartPage cp = new CartPage(driver);
		Thread.sleep(1000);
		wLib.waitForElementToBeClickable(driver, cp.getProductNames());
		String actualProdName1 = cp.getProductNames().getText();
		
		Assert.assertTrue(actualProdName1.contains(expectedProdName), "Assert Failes ProductNAme");
		System.out.println(actualProdName1);
		s.assertAll();

	}

}



