package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.WebDriverUtility;

public class GooglePage {
	
	@FindBy(css="svg[class='gb_Te']")
	private WebElement googleAppsIcon;
	
	@FindBy(xpath="//span[text()='YouTube']")
	private WebElement youTubeIcon;
	
	public GooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getGoogleAppsIcon() {
		return googleAppsIcon;
	}

	public WebElement getYouTubeIcon() {
		return youTubeIcon;
	}
	
	public void clickOnYouTube(WebDriver driver) {
		googleAppsIcon.click();
		driver.switchTo().frame(1);
		youTubeIcon.click();
	}

}
