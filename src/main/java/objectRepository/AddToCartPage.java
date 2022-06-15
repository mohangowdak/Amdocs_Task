package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage 
{
	WebDriver driver;
	public AddToCartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='sw-atc-buy-box']/descendant::a[contains(text(),'Go to Cart')]")
	private WebElement goToCartBtn;
	public WebElement getGoToCartBtn() {
		return goToCartBtn;
	}
	
	

}
