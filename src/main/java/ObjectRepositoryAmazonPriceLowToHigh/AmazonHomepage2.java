package ObjectRepositoryAmazonPriceLowToHigh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomepage2 {

public AmazonHomepage2(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

	@FindBy(id="twotabsearchtextbox")
	private WebElement textboxfield;

	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement clicksearchbutton;
	
	
	public WebElement getTextboxfield() {
		return textboxfield;
	}

	public WebElement getClicksearchbutton() {
		return clicksearchbutton;
	}

	public void searchbox(String productname)
	{
		textboxfield.sendKeys(productname);
	}
	
	public void clicksearchbutton()
	{
		
		clicksearchbutton.click();
	}
}
