package com.amdocs.amazonTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amdocs.amazon.genericUtils.BaseAnnotationClass;
import com.amdocs.amazon.pomrepo.AddToCartPage;
import com.amdocs.amazon.pomrepo.CartPage;
import com.amdocs.amazon.pomrepo.HomePage;
import com.amdocs.amazon.pomrepo.ProductPage;
import com.amdocs.amazon.pomrepo.SearchPage;

public class Day2_Task1Test extends BaseAnnotationClass {

	@Test
	public void searchTest() throws Throwable {

		String itemToSearch = eLib.getDataFromExcel("Search", 1, 0);
		/* Navigate to homepage */
		HomePage hp = new HomePage(driver);
		wlib.waitUntilPageLoad(driver);

		/* Enter the value to search */
		hp.getSearchBox().sendKeys(itemToSearch);

		/* Select the 4th option fromautosuggestion */
		WebElement autoSug = hp.getAutoSuggestion();
		Thread.sleep(1000);
		wlib.waitAndClick(autoSug);
		// autoSug.click();

		/* validate the prices is more than 500 */

		SoftAssert s = new SoftAssert();
		SearchPage searchPage = new SearchPage(driver);
		WebElement sh_price = searchPage.getPrices();
		String actPrice = sh_price.getText();
		int actPriceInt = 0;
		try
		{
		
		 actPriceInt = Integer.parseInt(actPrice);
		}
		catch(Exception e)
		{
			actPrice = sh_price.getText().replace(",", "");
			actPriceInt = Integer.parseInt(actPrice);
		}
		s.assertTrue(actPriceInt > 500, "Price is low");
		System.out.println("The product price " + actPrice);

		/* Select the product */
		sh_price.click();
		String actualProdName = searchPage.getproductNAme().getText();
		wlib.switchToWindow(driver, actualProdName);

		/* Add the product to cart */
		ProductPage productPage = new ProductPage(driver);
		String expectedProdName = productPage.getProdName().getText();
		productPage.getAddToCartBtn().click();
		
		
		/* Go to cart */
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		addToCartPage.getGoToCartBtn();

		/* Validate the product in the cart */
		CartPage cartPage = new CartPage(driver);
		
		wlib.waitForElementVisibility(driver, cartPage.getProductNames());
		 String actualProdName1 = cartPage.getProductNames().getText().substring(0, 20);
		
		 Thread.sleep(2000);
		Assert.assertTrue(actualProdName1.contains(expectedProdName), "Assert Failes ProductNAme");
		System.out.println(actualProdName1);
		s.assertAll();

	}

}
