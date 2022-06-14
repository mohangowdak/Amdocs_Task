package ObjectRepositoryAmazonPriceisgraterThan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import GenericUtility.Webdriverutility;

public class Artsandcraftsproductpage extends Webdriverutility{

	public Artsandcraftsproductpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/ancestor::div[@class='sg-col-inner']/descendant::span[@class='a-price-whole'])[1]")
	private WebElement validatefirstproductprice;
	
	@FindBy(xpath="(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/ancestor::div[@class='sg-col-inner']/descendant::span[@class='a-price-whole'])[1]")
	private WebElement clickfirstproduct;
	
	@FindBy(xpath="//input[@value='Add to Cart']")
	private WebElement clickonaddtocart;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	private WebElement clickviewcart;

	public WebElement getvalidatefirstproductprice() {
		return validatefirstproductprice;
	}

	public WebElement getClickfirstproduct() {
		return clickfirstproduct;
	}

	public WebElement getClickonaddtocart() {
		return clickonaddtocart;
	}
	
	
	public WebElement getClickviewcart() {
		return clickviewcart;
	}

	public void validateproductprice()
	{
	  String price = validatefirstproductprice.getText();
		String price1 = price.replaceAll(",","");
		  int actualprice = Integer.parseInt(price1);
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(actualprice>500);
			System.out.println(actualprice);
	}
	public void clickonfirdtproduct()
	{
		clickfirstproduct.click();
		switchtowindow(driver, "Fevicryl-DIY-Self-Painting-India");
	}
	public void clickonaddtocart()
	{
		clickonaddtocart.click();
		capturewindowtitle(driver, "cart/smart-wagon");
	}
	public void clickonviewcart()
	{
		clickviewcart.click();
	}
}
