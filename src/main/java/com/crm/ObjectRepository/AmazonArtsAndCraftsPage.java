package com.crm.ObjectRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.WebDriverUtility;

public class AmazonArtsAndCraftsPage extends WebDriverUtility{

	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']")
	private WebElement firstProduct;
	
	@FindBy(xpath="//td[@class='a-span12']/descendant::span[@aria-hidden='true']")
	private WebElement price;
	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCartBttn;
	
	@FindBy(id="nav-cart-count")
	private WebElement cartCount;

	@FindBy(xpath="//span")
	private List<WebElement> productTitle; 
	
	public AmazonArtsAndCraftsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}
	
	public WebElement getFirstProduct() {
		return firstProduct;
	}


	public WebElement getPrice() {
		return price;
	}


	public WebElement getAddToCartBttn() {
		return addToCartBttn;
	}


	public WebElement getCartCount() {
		return cartCount;
	}

	
	public void scenario1(WebDriver driver) {
	//Finding the first product
	String actual = "Little-Birdie-Bitsy-Decor-Varnish";
	firstProduct.click();
	
//	driver.findElement(By.xpath("//span[text()='Little Birdie Gloss Itsy Bitsy Decor Varnish, 100ml,Multicolour']")).click();
//	String actual ="INDIKONB 40 Colors 3 mm Seed Beads Jewellery Making Material - includes Small Multicolor Seed Beads & Nylon Wire Thread - Jewelry Making Set for Embroidery Work, Art and Craft (3 mm - 8/0, 40 Colours)";

	
	//Switching to the window of the product
	switchTowindow(driver, actual);

	
	//Fetching the price
	String pr = price.getText();
	String p = pr.substring(1);
	double price = Double.parseDouble(p);
	SoftAssert s = new SoftAssert();
	s.assertTrue(price > 500, "Price greater than 500");
	System.out.println("Price is greater than 500");
	
	
	addToCartBttn.click();
	cartCount.click();
	
	List<WebElement> wb = productTitle;
	for(int i=0; i<wb.size(); i++) {
		String title = wb.get(i).getText();
		s.assertEquals(actual, title);
		System.out.println("Title of the product is present");
		break;
	}
	}

}
