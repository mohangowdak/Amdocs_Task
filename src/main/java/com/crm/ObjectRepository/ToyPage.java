package com.crm.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.WebDriverUtility;

public class ToyPage extends WebDriverUtility{
	
	@FindBy(xpath="//label[text()='Quantity:']/ancestor::span[@class='a-dropdown-container']/descendant::select[@name='quantity']")
	private WebElement quantity;
	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCartBttn;
	
	@FindBy(id="nav-cart-count")
	private WebElement cartCount;

	@FindBy(xpath="//span")
	private List<WebElement> productTitle; 
	
    public ToyPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}

    
	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getAddToCartBttn() {
		return addToCartBttn;
	}

	public WebElement getCartCount() {
		return cartCount;
	}

	public List<WebElement> getProductTitle() {
		return productTitle;
	}

	//business library
	
	public void toy(WebDriver driver) {
		
		String actual = "SC-Mart-Transparent-Plasticine-Educational";
		switchTowindow(driver,actual);
		
		WebElement qty = quantity;
		Select sel = new Select(qty);
		String quantitystring = sel.getFirstSelectedOption().getText();
		int quantity = Integer.parseInt(quantitystring);
		SoftAssert s = new SoftAssert();
		s.assertTrue(quantity > 0, "Quanity is greater than zero");
		System. out. println("Quantity is greater than zero");
		
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
