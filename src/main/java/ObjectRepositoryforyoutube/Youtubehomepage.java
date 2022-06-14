package ObjectRepositoryforyoutube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Youtubehomepage {

	public Youtubehomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='search']")
	private WebElement searchtextbox;

	@FindBy(xpath="//button[@class='style-scope ytd-searchbox']")
	private WebElement clickonsearchbutton;

	public WebElement getSearchtextbox() {
		return searchtextbox;
	}
	
	
	public WebElement getClickonsearchbutton() {
		return clickonsearchbutton;
	}


	public void searchbox(String searchingname)
	{
		searchtextbox.sendKeys(searchingname);
	}
	public void clicksearchbutton()
	{
		clickonsearchbutton.click();
	}
}
