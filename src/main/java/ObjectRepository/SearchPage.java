package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {	
		
		WebDriver driver;

		public SearchPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//div[@class='style-scope ytd-video-renderer']")
		private WebElement firstVideo;

		public WebElement getFirstVideo() {
			return firstVideo;
		}
	}


