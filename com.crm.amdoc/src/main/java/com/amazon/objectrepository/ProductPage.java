package com.amazon.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='productTitle']/ancestor::div[@id='centerCol']/descendant::span[@class='a-price-whole']")
	private WebElement capturePrice;
	
	@FindBy(xpath="//input[@id='add-to-cart-button' and @name='submit.add-to-cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	private WebElement goToCart;
	
	@FindBy(xpath="//span[@class='a-dropdown-container']/descendant::option[@value='8']")
	private WebElement qtyOptionValue;
	
	public WebElement getQtyOptionValue() {
		return qtyOptionValue;
	}

	public WebElement getCapturePrice() {
		return capturePrice;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getGoToCart() {
		return goToCart;
	}

	//Business Logic
	public String captureItemPrice()
	{
		String price = capturePrice.getText();
		return price;
	}
	
	public void addToCart()
	{
		addToCart.click();
		goToCart.click();
	}
	
	public String getQtyOption()
	{
		String qty = qtyOptionValue.getText();
		return qty;
	}

}
