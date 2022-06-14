package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.WebDriverUtility;

public class AmazonHome1Page extends WebDriverUtility{
	
	//Step 1: Declaration
		@FindBy(id="twotabsearchtextbox")
		private WebElement searchTextBox;
	
		@FindBy(id="nav-search-submit-button")
		private WebElement searchIcon;
	
		
		//Step 2: Initialization - use constructor
		public AmazonHome1Page(WebDriver driver) {
			
			PageFactory.initElements(driver, this);

		}

		//Step 3: Utilization - Provide getters
		public WebElement getSearchTextBox() {
			return searchTextBox;
		}
		
		//business Library
		public void searchItem(String category, WebDriver driver) {
			
			searchTextBox.sendKeys(category);
			searchIcon.click();
			String title = driver.getWindowHandle();
			SoftAssert s = new SoftAssert();
			boolean flag = false;
			if(title.contains(category)) {
				flag = true;
			}
			s.assertTrue(flag, "Redirected to desiered page");
			
		}
		
}
