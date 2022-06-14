package ObjectRepositoryforyoutube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Triningvideospage {

	public Triningvideospage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//yt-formatted-string[@class='style-scope ytd-video-renderer']")
	private WebElement clickfirstvideo;

	public WebElement getClickfirstvideo() {
		return clickfirstvideo;
	}
	
	public void selectfirstvideo()
	{
		clickfirstvideo.click();
	}
}
