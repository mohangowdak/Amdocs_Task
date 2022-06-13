package com.amdocs.amazon.genericUtils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/*
 * This class contains methods that is used to read and write the data into the cell
 */

public class ExcelUtility {
/**
 * This method is used for reading the data from the Cell
 * @param sheetName
 * @param rowNum
 * @param celNum
 * @return
 * @throws Throwable
 */
	
	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(celNum);
		String data = cel.getStringCellValue();
		wb.close();
		return data;
	}
}
