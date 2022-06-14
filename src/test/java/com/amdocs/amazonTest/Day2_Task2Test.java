package com.amdocs.amazonTest;

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

public class Day2_Task2Test  extends BaseAnnotationClass{
	@Test
	public void practicalTest() throws Throwable {
		
		
		
		
		String itemToSearch = eLib.getDataFromExcel("Search1", 1, 0);
		/* Navigate to homepage */
		HomePage homePage = new HomePage(driver);
		wlib.waitUntilPageLoad(driver);

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
		wlib.switchToWindow(driver, actualProdName);

		/*Validate the quantity*/
		ProductPage productPage = new ProductPage(driver);
		String quantity = wlib.selectGetFistOption(productPage.getQuantity());
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
		wlib.waitForElementVisibility(driver, cp.getProductNames());
		String actualProdName1 = cp.getProductNames().getText();
		
		Assert.assertTrue(actualProdName1.contains(expectedProdName), "Assert Failes ProductNAme");
		System.out.println(actualProdName1);
		s.assertAll();

	}
}
