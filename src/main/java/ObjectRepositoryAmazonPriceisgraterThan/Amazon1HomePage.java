package ObjectRepositoryAmazonPriceisgraterThan;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Amazon1HomePage {

	public Amazon1HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement clicktextfield;
	
	@FindBy(xpath="//div[@class='autocomplete-results-container']")
	private WebElement captureallList;
	
	@FindBy(xpath="//div[@class='s-suggestion-container']/descendant::div[starts-with(text(),'arts and crafts')]")
	private List<WebElement> selectfourthoption;

	public WebElement getClicktextfield() {
		return clicktextfield;
	}

	public WebElement getCaptureallList() {
		return captureallList;
	}

	public List<WebElement> getFetchfourthdata() {
		return selectfourthoption;
	}
	public	void clicksearchtextbox()
	{
		clicktextfield.click();
	}
	public void searchtextbox(String productname)
	{
		clicktextfield.sendKeys(productname);
	}
	
	public void selectalllist()
	{
		
		captureallList.getText();
	}
	
	
}


