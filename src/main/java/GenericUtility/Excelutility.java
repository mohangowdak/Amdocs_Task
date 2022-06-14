package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author sachin
 *
 */

public class Excelutility {
	/**
	 * using this logic we can fetch the data from excel sheet
	 * @param sheetname
	 * @param cellnum
	 * @param rownum
	 * @return
	 * @throws Throwable
	 */

	public String getdata(String sheetname,int cellnum,int rownum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/main/resources/commondata/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		String data = row.getCell(cellnum).getStringCellValue();
		wb.close();
		return data;
	}
}
