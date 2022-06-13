package com.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;



/*
 * This class contains all the generic method for excel
 */
public class ExcelUtility {
	
	
	/*
	 * This method will get the data from the excel
	 */
	public String getDataFromExcel(String name, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/main/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(name);
		Row r = sh.getRow(rowNum);
		String value = r.getCell(cellNum).getStringCellValue();
		return value;
	}
	
	
	
	

}
