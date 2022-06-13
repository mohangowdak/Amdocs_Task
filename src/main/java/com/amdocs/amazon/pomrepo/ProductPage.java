package com.amdocs.amazon.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(id="add-to-cart-button")
	private WebElement addToCartBtn;
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	@FindBy(xpath="//h1[@id='title']")
	private WebElement prodName;
	public WebElement getProdName() {
		return prodName;
	}
	@FindBy(xpath="//select[@id='quantity']")
	private WebElement quantity;
	public WebElement getQuantity() {
		return quantity;
	}
	
}
