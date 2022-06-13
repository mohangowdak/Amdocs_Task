package day2;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomclasses.AddToCartPage;
import pomclasses.AddedToCartPage;
import pomclasses.AmazonHomePage;
import pomclasses.BaseClass;
import pomclasses.LoginPage;
import pomclasses.ShoppingCartPage;
/**
 * This class is developed to Search for toy and check the quantity present in the cart and product to the cart  
 * @author CHANNAKESHVA REDDY
 *
 */
public class SearchForToyTest extends BaseClass{
	
        @Test
		public void searchForToy() throws InterruptedException {
        /**
        * Creating LoginPage object and call the LoginPage non-static method and provide the driver reference and url
        * Here we navigate to amazon Homepage
        */
        LoginPage lp=new LoginPage();
        lp.LoginPage(driver, "https://www.amazon.in/");
        /**
         * Here we Providing the data in the search bar
         */
        AmazonHomePage am=new AmazonHomePage(driver);
        am.ClickOnSearch("toys");
	    /**
	     * Here we verifying the Product Name before add to the Cart
	     */
        String BeforeAddingToyName = am.ClickOnToysLowToHigh(driver);
        /**
		 * Here we check the quantity present in the cart
		 * Add the product to the cart and verifying in the cart
		 */
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        String conutOfProductsInCart = addToCartPage.clickOnAddToCartForToys();
        /**
         * Here we verifying the number of product in the Cart
         */
		System.out.println("Total Products In The Cart = "+conutOfProductsInCart);
		
		AddedToCartPage addedToCartPage = new AddedToCartPage(driver);
		addedToCartPage.clickOnGoToCartButton();
		/**
		 * Here will check the the add product in cart is right are not
		 */
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		/**
		 * Here we verifying the Product Name After add to the Cart
		 */
		String AfterAddingToyName = shoppingCart.actualProductTitle();
		/**
		 * Here we verifying the Before added product name and After added product name are SAME or NOT
		 */
		Assert.assertEquals(BeforeAddingToyName, AfterAddingToyName);
		
		System.out.println("===============Product is Verifed In Cart=======================");

	}

	
}
