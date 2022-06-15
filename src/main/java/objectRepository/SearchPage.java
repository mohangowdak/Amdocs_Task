package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage
{
	WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//div[@class='a-section a-spacing-base']/descendant::span[@class='a-price-whole']")
	private WebElement prices;
	public WebElement getPrices() {
		return prices;
	}

	@FindBy(xpath = "//div[@class='a-section a-spacing-base']/descendant::span[contains(@class,'a-size-base')]")
	private WebElement productNAme;
	public WebElement getproductNAme() 
	{
		return prices;
	}
	
	@FindBy(id = "a-autoid-0-announce")
	private WebElement filterPrice;
	
	@FindBy(xpath = "//a[text()='Price: Low to High']")
	private WebElement filterPriceOptions;
	public WebElement getFilterPrice() {
		return filterPrice;
	}

	public WebElement getFilterPriceOptions() {
		return filterPriceOptions;
	}


}
