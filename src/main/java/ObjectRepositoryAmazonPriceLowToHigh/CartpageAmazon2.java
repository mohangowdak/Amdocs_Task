package ObjectRepositoryAmazonPriceLowToHigh;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartpageAmazon2 {

	public CartpageAmazon2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='a-truncate-cut']")
	private WebElement validateproductincartornot;

	public WebElement getValidateproductincartornot() {
		return validateproductincartornot;
	}
	
	public void validatecartproductpresentornot()
	{
		String actualproduct = validateproductincartornot.getText();
		System.out.println(actualproduct);
	}
}
