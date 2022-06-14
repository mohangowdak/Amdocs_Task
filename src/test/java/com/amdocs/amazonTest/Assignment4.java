package com.amdocs.amazonTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amdocs.amazon.genericUtils.BaseAnnotationClass;
import com.amdocs.youtube.pomrepo.HomePage;
import com.amdocs.youtube.pomrepo.SearchPage;
import com.amdocs.youtube.pomrepo.VideoPage;

public class Assignment4 extends BaseAnnotationClass {
	
	
	@Test
	public void practicalTest() throws Throwable
	{
		
		/* Navigate to homepage */
		HomePage homePage = new HomePage(driver);
		wlib.waitUntilPageLoad(driver);

		/* Enter the video name "Selenium Training" to search */
		homePage.searchIteam(driver, "Selenium Training");
		
		/*Play the first Video */
		SearchPage searchPage = new SearchPage(driver);
		searchPage.getFirstVideo().click();
		
		/*play the video for 15 seconds and Pause*/
		Thread.sleep(15000);
		VideoPage videoPage = new VideoPage(driver);
		videoPage.getPlayBtn().click();
		
		/*Validate the subscribe more than 1000 and print the subscribers count*/
		String[] subCount = videoPage.getSubCount().getText().split(" ");
		Assert.assertTrue(subCount[0].contains("K") || subCount[0].contains("M"),"Subscribers less than thousand");
		System.out.println("Subscribers : "+subCount[0]);
	}

}
