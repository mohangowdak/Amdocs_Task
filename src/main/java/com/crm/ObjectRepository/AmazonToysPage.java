package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.WebDriverUtility;

public class AmazonToysPage extends WebDriverUtility{
	
	@FindBy(xpath="//span[text()='Sort by:']")
	private WebElement sortBy;
	
	@FindBy(id="s-result-sort-select_1")
	private WebElement lowToHigh;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal'][1]")
	private WebElement firstProduct;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-base']/descendant::span[@class='a-price-whole']")
	private WebElement price;
	
	
	public AmazonToysPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}


	public WebElement getSortBy() {
		return sortBy;
	}


	public WebElement getLowToHigh() {
		return lowToHigh;
	}


	public WebElement getFirstProduct() {
		return firstProduct;
	}


	public WebElement getPrice() {
		return price;
	}
	

	//business Library
	public void lowToHigh() {
		
		sortBy.click();
		lowToHigh.click();
	}
	
	public void firstProductAndPrice() {
		
		String pr = price.getText();
		int price = Integer.parseInt(pr);
		SoftAssert s = new SoftAssert();
		s.assertTrue(price < 100, "Price less than 100");
		System.out.println("Price less than 100");
		firstProduct.click();
	}
}
