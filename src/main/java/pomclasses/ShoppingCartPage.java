package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	@FindBy(xpath="//span[@class='a-truncate-cut']")
	private WebElement productTitle;
	
	public ShoppingCartPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getProductTitle() {
		return productTitle;
	}
	
	public String actualProductTitle() {
		return productTitle.getText();
	}

}
