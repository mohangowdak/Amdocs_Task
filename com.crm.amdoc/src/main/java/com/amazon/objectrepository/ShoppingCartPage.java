package com.amazon.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='a-truncate-cut']")
	private WebElement captureShoppingCartItem;

	public WebElement getCaptureShoppingCartItem() {
		return captureShoppingCartItem;
	}
	
	public String captureItemName()
	{
		String name = captureShoppingCartItem.getText();
		return name;
	}

}
