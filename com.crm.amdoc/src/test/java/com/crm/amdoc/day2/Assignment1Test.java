package com.crm.amdoc.day2;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amazon.objectrepository.ArtsAndCraftsForAdultsPage;
import com.amazon.objectrepository.HomePage;
import com.amazon.objectrepository.ProductPage;
import com.amazon.objectrepository.ShoppingCartPage;
import com.genericutility.BaseClass;
import com.genericutility.WebDriverUtility;

public class Assignment1Test extends BaseClass {

	@Test
	public void autoSugg() throws Throwable {

		WebDriverUtility wLib = new WebDriverUtility();
		HomePage homePage = new HomePage(driver);
		homePage.passvalueInSearchBar(eLib.getDataFromExcel("Sheet1", 2, 0), driver);

		ArtsAndCraftsForAdultsPage art_Page = new ArtsAndCraftsForAdultsPage(driver);
		String name = art_Page.nameCapture();
		System.out.println(name);

		wLib.switchToWindow(driver, name);

		ProductPage product_Page = new ProductPage(driver);
		String price = product_Page.captureItemPrice();
		product_Page.addToCart();
		int price1 = Integer.parseInt(price);

		SoftAssert sf = new SoftAssert();

		if (price1 > 500) {
			System.out.println(price);
		}

		ShoppingCartPage cartPage = new ShoppingCartPage(driver);
		String actual_text = cartPage.captureItemName();
		System.out.println(actual_text);
		String exp_text = name.substring(0, 20);
		sf.assertTrue(actual_text.contains(exp_text));
		Reporter.log(actual_text, true);
		sf.assertAll();

	}

}
