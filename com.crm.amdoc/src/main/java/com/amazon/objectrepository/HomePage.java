package com.amazon.objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.genericutility.ExcelUtility;
import com.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	ExcelUtility eLib = new ExcelUtility();

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchTextBox;

	@FindBy(xpath = "//div[@class='autocomplete-results-container']/descendant::div[@class='s-suggestion-container']")
	private List<WebElement> listAutoSugg;

	public List<WebElement> getListAutoSugg() {
		return listAutoSugg;
	}

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	// business logic

	/**
	 * This will click on search link
	 * 
	 * @throws Throwable
	 */
	public void passvalueInSearchBar(String text, WebDriver driver) throws Throwable {
		searchTextBox.sendKeys(text);
		Thread.sleep(1000);
		int count = 0;
		for (WebElement w : listAutoSugg) {
			count++;

			if (count == 4) {

				w.click();
			}
		}

	}

	public void searchItemClick(String text) {
		searchTextBox.sendKeys(text, Keys.ENTER);
	}

}
