package day2;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonUtility.ExcelUtility;
import pomclasses.AmazonHomePage;
import pomclasses.BaseClass;
import pomclasses.LoginPage;
/**
 * This class is developed using FrameWork components to search for toys
 * @author CHANNAKESHVA REDDY
 *
 */
public class UsingFrameSearchForToysTest extends BaseClass{
	
	@Test
	public void usingFrameSearchForToys() throws EncryptedDocumentException, IOException {
		/**
		 * Getting the data from external Excel Sheet
		 */
		ExcelUtility Eutility=new ExcelUtility();
		String SearchName = Eutility.getExcelData("Toys", 1, 0);
		String Url = Eutility.getExcelData("Toys", 1, 1);
		String ExpectedData = Eutility.getExcelData("Toys", 1, 2);
		/**
		 * Here we creating the loginPage object and performing the action
		 */
		LoginPage lp=new LoginPage();
		lp.LoginPage(driver, Url);
        /**
         * Here we creating the AmazonHomePage object and performing the action
         */
		AmazonHomePage hp=new AmazonHomePage(driver);
		hp.ClickOnSearch(SearchName);
		
		String ActualData = driver.getTitle();
		Assert.assertEquals(ActualData, ExpectedData);
		System.out.println("PAGE IS REDIRECTED TO TOYS PAGES");
	}

}
