package ObjectRepositoryAmazonPriceLowToHigh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.Webdriverutility;

public class Toysproductpage extends Webdriverutility {

	public Toysproductpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='quantity']")
	private WebElement checkquntityofproduct;
	
	@FindBy(xpath="//input[@title='Add to Shopping Cart']")
	private WebElement clickonadtocart;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	private WebElement clickonviewcart;
	
	public void validatequntity()
	{
		checkquntityofproduct.getText();
	}
	public void addtocartproduct()
	{
		clickonadtocart.click();
	}
	public void clickviewcart()
	{
		clickonviewcart.click();
		capturewindowtitle(driver, "smart-wagon");
	}
}

