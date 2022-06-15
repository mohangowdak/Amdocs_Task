package AmdoxAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task6
{
	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.youtube.com");
		
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("ra ra rakkamma");
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		driver.findElement(By.xpath("//yt-formatted-string[@aria-label='Ra Ra Rakkamma Hindi Lyric Video | Vikrant Rona | Kichcha Sudeep |Jacqueline Fernandez|Anup Bhandari by T-Series 3 weeks ago 3 minutes, 44 seconds 11,691,308 views']")).click();
		
		
		
	}

}
