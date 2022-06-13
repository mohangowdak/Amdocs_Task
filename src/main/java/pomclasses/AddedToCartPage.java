package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddedToCartPage {
	
	@FindBy(xpath="//a[contains(text(),'Go to Cart')]")
	private WebElement goToCartButton;
	
	public AddedToCartPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	public WebElement getGoToCartButton() {
		return goToCartButton;
	}
	public void clickOnGoToCartButton() {
		goToCartButton.click();
	}
}