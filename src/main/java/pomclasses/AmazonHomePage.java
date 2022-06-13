package pomclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtility.WebDriverUtility;

public class AmazonHomePage {
	
	WebDriverUtility wb=new WebDriverUtility();
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement SearchTextBox;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement SearchButton;
	
	@FindBy(id="low-price")
	private WebElement lowPriceButton;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	private WebElement seachlowPriceButton;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']")
	private WebElement clickOnFirstProduct;
	
	@FindBy(xpath="//span[text()='Featured']")
	private WebElement sortByFeature;
	
	@FindBy(xpath="//a[text()='Price: Low to High']")
	private WebElement lowToHighPrice;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']")
	private WebElement ClickOnParticularToy;
	
	public WebDriverUtility getWb() {
		return wb;
	}

	public WebElement getClickOnParticularToy() {
		return ClickOnParticularToy;
	}

	public WebElement getSortByFeature() {
		return sortByFeature;
	}

	public WebElement getLowToHighPrice() {
		return lowToHighPrice;
	}

	public WebElement getClickOnFirstProduct() {
		return clickOnFirstProduct;
	}

	public WebElement getLowPriceButton() {
		return lowPriceButton;
	}

	public WebElement getSeachlowPriceButton() {
		return seachlowPriceButton;
	}

	public AmazonHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTextBox() {
		return SearchTextBox;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}
	public void ClickOnSearch(String value) {
		SearchTextBox.sendKeys(value);
		SearchButton.click();
	}
	public void enterTheSearchValue(WebDriver driver,String value) throws InterruptedException {
		SearchTextBox.sendKeys(value);
		Thread.sleep(5000);
		List<WebElement> allSuggestions = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']/descendant::div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
		allSuggestions.get(3).click();
	}
	public String seachForCost(WebDriver driver,String price) {
		lowPriceButton.sendKeys(price);
		seachlowPriceButton.click();
		List<WebElement> Listprice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for (WebElement ele : Listprice) {
			System.out.println("price ot the item "+ele.getText());
		}
		String BeforeAddingProductName=clickOnFirstProduct.getText();
		clickOnFirstProduct.click();
		wb.switchToWindow(driver, 1);
		return BeforeAddingProductName;
	}
	
	public String ClickOnToysLowToHigh(WebDriver driver) throws InterruptedException {
		sortByFeature.click();
		lowToHighPrice.click();
		wb.customWait(5000);
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	    for (WebElement singlePrice : price) {
	    	String Sp = singlePrice.getText().replace(",", "");
	    	int actualPrice = Integer.parseInt(Sp);
	    	if(actualPrice<100) {
	    	System.out.println(actualPrice);
	    	}
		}
	   String BeforeAddingToyName = ClickOnParticularToy.getText();
	   ClickOnParticularToy.click();
	   wb.switchToWindow(driver, 1);
	   return BeforeAddingToyName;
	}

}
