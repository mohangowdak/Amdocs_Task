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

public class AmazonHomePage extends WebDriverUtility{
	
	//Step 1: Declaration
		@FindBy(id="twotabsearchtextbox")
		private WebElement searchTextBox;
	
		@FindBy(id="nav-search-submit-button")
		private WebElement searchIcon;
	
		@FindBy(xpath="//div[@class='s-suggestion-container']")
		private List<WebElement> suggestions;
		
		//Step 2: Initialization - use constructor
		public AmazonHomePage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);

		}

		//Step 3: Utilization - Provide getters
		public WebElement getSearchTextBox() {
			return searchTextBox;
		}
		
		public WebElement getSearchIcon() {
			return searchIcon;
		}

		public List<WebElement> getSuggestions() {
			return suggestions;
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
		
		public void scenario1(WebDriver driver) throws InterruptedException {
			//Searching for arts and crafts
			searchTextBox.sendKeys("arts and crafts");
			Thread.sleep(3000);
			
			//clicking on 4th option from top from Autosuggestions
			List<WebElement> suggestionElements = suggestions;
//			System.out.println(elements.size());
			suggestionElements.get(3).click();
			
			}

		public void searchToys(WebDriver driver) {
			searchTextBox.sendKeys("toys");
			searchIcon.click();
			
		}
}
