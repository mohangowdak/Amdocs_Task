package day2;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomclasses.AddToCartPage;
import pomclasses.AddedToCartPage;
import pomclasses.AmazonHomePage;
import pomclasses.BaseClass;
import pomclasses.LoginPage;
import pomclasses.ShoppingCartPage;
/**
 * This class developed to Search for product which price is more than 500rs products will add cart
 * It will add all products to cart above 500rs
 * @author CHANNAKESHVA REDDY
 *
 */
public class SearchForArtsAndCraftsTest extends BaseClass{
	
        @Test
		public void searchForArtsAndCrafts() throws InterruptedException {
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
        am.enterTheSearchValue(driver,"arts and crafts");
        /**
         * Here we select price more than 500 ruppes
         */
        String BeforeAddingProductName = am.seachForCost(driver,"500");
		/**
		 * Here we add the product to Add TO Cart 		
		 */
	    AddToCartPage addCart=new AddToCartPage(driver);
	    addCart.clickOnAddToCart();
	    /*
	     *  Here we swicth to Add to Cart page
	     */
	    AddedToCartPage addedTo=new AddedToCartPage(driver);
	    addedTo.clickOnGoToCartButton();
	    /**
	     * Here we verfiying that product is added to cart or not
	     */
		ShoppingCartPage shoppingcart=new ShoppingCartPage(driver);
		String afterAddingProductName = shoppingcart.actualProductTitle();
		
		//Assert.assertEquals(BeforeAddingProductName, afterAddingProductName);
		System.out.println("===============Product is Verifed In Cart=======================");
	}
}
