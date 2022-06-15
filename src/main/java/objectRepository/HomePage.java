package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchBox;

	@FindBy(id = "nav-search-submit-text")
	private WebElement searchOption;

	@FindBy(xpath = "(//div[@class='s-suggestion s-suggestion-ellipsis-direction'])[4]")
	private WebElement autoSuggestion;
	
	
	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchOption() {
		return searchOption;
	}

	public WebElement getAutoSuggestion() {
		return autoSuggestion;
	}
	public void searchIteam(WebDriver driver, String ItemName)
	{
		searchBox.sendKeys(ItemName);
		searchOption.click();
	}

}
