package com.amazon.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArtsAndCraftsForAdultsPage {
	
	public ArtsAndCraftsForAdultsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])[5]")
	private WebElement selectOneItem;
	
	@FindBy(xpath="(//span[text()='RESULTS']/ancestor::span[@class='rush-component s-latency-cf-section']/descendant::div[contains(@class,'a-section a-spacing-small')]/child::div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style'])[5]")
	private WebElement selectItemNameCapture;

	public WebElement getSelectOneItem() {
		return selectOneItem;
	}

	public WebElement getSelectItemNameCapture() {
		return selectItemNameCapture;
	}
	
	
	//Business Logic
	public String nameCapture()
	{
		String name = selectItemNameCapture.getText();
		selectOneItem.click();
		
		return name;
	}
	


}
