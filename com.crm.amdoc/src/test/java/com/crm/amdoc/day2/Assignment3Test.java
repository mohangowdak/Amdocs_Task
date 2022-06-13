package com.crm.amdoc.day2;


import org.testng.annotations.Test;

import com.genericutility.BaseClassYouTube;
import com.youtube.objectrepository.YouTubeHomePage;
import com.youtube.objectrepository.YouTubeSearchResultPage;



public class Assignment3Test extends BaseClassYouTube {

	@Test
	public void videoYoutube() throws Throwable {

		YouTubeHomePage homePage = new YouTubeHomePage(driver);
		homePage.enterSearchValue(eLib.getDataFromExcel("Sheet2", 1, 0));
		YouTubeSearchResultPage search_Result = new YouTubeSearchResultPage(driver);
		search_Result.clickOnVideo();
		search_Result.clickOnPause();
		
		String subscribers = search_Result.captureSubs();
		String num = "";
		for (int i = 0; i < subscribers.length(); i++) {
			if (subscribers.charAt(i) >= '0' && subscribers.charAt(i) <= '9') {
				num += subscribers.charAt(i);
			} else if (subscribers.charAt(i) == 'K') {
				num = num.concat("000");
			} else if (subscribers.charAt(i) == 'M') {
				num = num.concat("0000");
			}
		}
		
		int numm = Integer.parseInt(num);
		if (numm > 1000) {
			System.out.println(numm);
		}

	}
}
