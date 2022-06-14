package ObjectRepositoryAmazonPriceisgraterThan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCartpage {

	public ProductCartpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
  @FindBy(xpath="//span[@class='a-truncate-cut']/ancestor::div[@class='a-fixed-left-grid-inner']")
  private WebElement validatecart;
	
  
	public WebElement getValidatecart() {
	return validatecart;
}


	
	
}
