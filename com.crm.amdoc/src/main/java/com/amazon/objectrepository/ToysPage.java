package com.amazon.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToysPage {
	
	public ToysPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='a-dropdown-prompt']")
	private WebElement sortByDropDown;
	
	@FindBy(xpath="//a[@id='s-result-sort-select_1']")
	private WebElement sortLowToHighOption;
	
	@FindBy(xpath="//div[@class='sg-col-inner']/descendant::span[@class='a-price-whole']")
	private List<WebElement> listOfAllPrice;
	
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']")
	private WebElement firstItemName;

	public WebElement getSortByDropDown() {
		return sortByDropDown;
	}

	public WebElement getSortLowToHighOption() {
		return sortLowToHighOption;
	}
	public WebElement getFirstItemName() {
		return firstItemName;
	}

	public List<WebElement> getListOfAllPrice() {
		return listOfAllPrice;
	}
	
	//Business Logic
	

	public void sortLowToHigh()
	{
		sortByDropDown.click();
		sortLowToHighOption.click();
	}
	
	public String captureFirstPrice()
	{ 
		int count=0; String price="";
		for (WebElement w : listOfAllPrice) {
			count++;

			price = w.getText();
			String price1 = price.replaceAll(",", "");
			int price2 = Integer.parseInt(price1);
			
			if (count == 1) {				
				
				if (price2 < 100) {
					System.out.println(price2);
					w.click();
			
			}
			}
		}
		return price;
			
			
	}
	
	public String nameCapture()
	{
		String name = firstItemName.getText();
		
		
		return name;
	}

	
}
