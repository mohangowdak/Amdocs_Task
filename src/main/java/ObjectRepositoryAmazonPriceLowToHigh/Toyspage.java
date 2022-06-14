package ObjectRepositoryAmazonPriceLowToHigh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import GenericUtility.Webdriverutility;

public class Toyspage extends Webdriverutility{

	public Toyspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='a-button-text a-declarative']")
	private WebElement clickonsortby;
	
	@FindBy(xpath="//a[text()='Price: Low to High']")
	private WebElement clickpricelowtohigh;
	
	@FindBy(xpath="(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/ancestor::div[@class='sg-col-inner']/descendant::span[@class='a-price-whole'])[1]")
	private WebElement selectfirstproduct;

	@FindBy(xpath="(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/ancestor::div[@class='sg-col-inner']/descendant::span[@class='a-price-whole'])[1]")
	private WebElement clickonfirstproduct;
	
	
	public WebElement getClickonsortby() {
		return clickonsortby;
	}

	public WebElement getClickpricelowtohigh() {
		return clickpricelowtohigh;
	}
	
	
	public WebElement getselectfirstproduct() {
		return selectfirstproduct;
	}
	

	public WebElement getClickonfirstproduct() {
		return clickonfirstproduct;
	}
	
	
	public void sortbyprice()
	{
		clickonsortby.click();
	}
    public void pricelowtohigh()
	{
		
		clickpricelowtohigh.click();

	}
	public void validateproductprice()
	{
		String price = selectfirstproduct.getText();
		String price1 = price.replaceAll(",","");
		  int actualprice = Integer.parseInt(price);
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(actualprice<100);
			System.out.println(actualprice);
	}
	public void clickfirstproduct()
	{
		clickonfirstproduct.click();
		switchtowindow(driver, "SC-Mart-Transparent-Plasticine-Educational");
	}

	
}
