package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.converter.AbstractExcelUtils;
import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtilLogin {
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	static FileInputStream fis = null;
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"\\src\\test\\java\\util\\login.xlsx";
	// String[][] data = null;

	public static Object[][] getTestData(int sheetNum) throws Exception {
		String celData = null;
		File f1 = new File(TESTDATA_SHEET_PATH);
		fis = new FileInputStream(f1);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheetAt(sheetNum);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object data[][] = new Object[rowCount - 1][colCount];

		// data = new String[sheet.getColumns()][sheet.getRows()];
		for (int i = 1; i < rowCount; i++) 	{
			for (int j = 0; j < colCount; j++) {
				sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
				System.out.println(i);
				celData = sheet.getRow(i).getCell(j).getStringCellValue();
				celData.toString();
				data[i - 1][j] = celData;
			}
		}
		return data;
	}
}
