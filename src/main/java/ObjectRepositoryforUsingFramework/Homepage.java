package ObjectRepositoryforUsingFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@aria-label='Search']")
	private WebElement searchtextbox;

	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	private WebElement clicksearchbutton;
	
	public WebElement getSearchtextbox() {
		return searchtextbox;
	}
	public WebElement getClicksearchbutton() {
		return clicksearchbutton;
	}

	
	public void entertextinsearchbox(String productname)
	{
		searchtextbox.sendKeys(productname);
	}
	public void clickonsearchbutton()
	{
		
		clicksearchbutton.click();
	}

}
