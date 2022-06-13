package commonUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fin = new FileInputStream("./src/main/resources/AmdocsData.xlsx");
		Workbook wk = WorkbookFactory.create(fin);
		Sheet sheet = wk.getSheet(sheetName);
		return sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
	}

}
