package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	private WebElement countOfproductInCart;
	
	public WebElement getCountOfproductInCart() {
		return countOfproductInCart;
	}

	public AddToCartPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	public void clickOnAddToCart() {
		addToCartButton.click();
	}
	
	public String clickOnAddToCartForToys() {
		String conutOfProductsInCart = countOfproductInCart.getText();
		addToCartButton.click();
		return conutOfProductsInCart;
	}

}
