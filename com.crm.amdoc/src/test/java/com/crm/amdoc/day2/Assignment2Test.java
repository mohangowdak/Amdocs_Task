package com.crm.amdoc.day2;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amazon.objectrepository.HomePage;
import com.amazon.objectrepository.ProductPage;
import com.amazon.objectrepository.ShoppingCartPage;
import com.amazon.objectrepository.ToysPage;
import com.genericutility.BaseClass;
import com.genericutility.WebDriverUtility;

public class Assignment2Test extends BaseClass {

	@Test
	public void priceSort() throws Throwable {

		WebDriverUtility wLib = new WebDriverUtility();
		HomePage homePage = new HomePage(driver);
		homePage.searchItemClick(eLib.getDataFromExcel("Sheet1", 1, 0));
		ToysPage toy_Page = new ToysPage(driver);
		toy_Page.sortLowToHigh();
		String price = toy_Page.captureFirstPrice();
		System.out.println(price);
		String item_name = toy_Page.nameCapture();

		wLib.switchToWindow(driver, item_name);

		int exp_qty = 8;
		ProductPage product_page = new ProductPage(driver);
		String qty = product_page.getQtyOption();
		System.out.println(qty);
		int qty1 = Integer.parseInt(qty);

		SoftAssert sf = new SoftAssert();
		sf.assertEquals(qty1, exp_qty);
		product_page.addToCart();
		ShoppingCartPage cartPage = new ShoppingCartPage(driver);
		String cart_title_exp = item_name.substring(0, 15);
		String cart_title_act = cartPage.captureItemName();

		sf.assertTrue(cart_title_act.contains(cart_title_exp));
		Reporter.log(cart_title_act, true);
		sf.assertAll();

	}

}
