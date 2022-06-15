package GenericLibrary;

import java.io.FileInputStream;

import java.io.FileOutputStream;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class read data from excel sheet and return value to user
 * @author LHR
 *
 */
public class ExcelFileUtility 
{
/**
 * This method will read data from excel sheet and return value when sheetname, 
 * row no and cell number is specified
 * @param Sheetname
 * @param rowno
 * @param celno
 * @return
 * @throws Throwable 
 */
	public String readDataFromExcel(String Sheetname, int rowno, int celno) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		Row ro = sh.getRow(rowno);
		Cell cel = ro.getCell(celno);
		String value = cel.getStringCellValue();
		return value;
	}
	
	/**
	 * This method will write data into excelsheet
	 * @param Sheetname
	 * @param rowno
	 * @param celno
	 * @param value
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 */
	public void writeDataIntoExcel(String Sheetname, int rowno, int celno, String value) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		Row ro = sh.getRow(rowno);
		Cell cel = ro.createCell(celno);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
	}
	
	/**
	 * This method will return last row number
	 * @param SheetName
	 * @return
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 */
	public int getRowCount(String SheetName) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int ROW = sh.getLastRowNum();
		return ROW;
	}
	
	/**
	 * This method will read multiple data from excel sheet with the help of sheetname
	 * and return 2 dimensional object [][]
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	
	}
	
	

}
