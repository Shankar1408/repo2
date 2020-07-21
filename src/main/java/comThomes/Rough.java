package comThomes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rough {
	static Workbook book;
	static Sheet sheet;
	static FileInputStream fis = null;
	public static String TESTDATA_SHEET_PATH = "F:\\telia\\login.xlsx";

	public static void main(String[] args) throws IOException {
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + "\\src\\main\\resources\\resourcesFiles\\chromedriver.exe");
//		 WebDriver driver = new ChromeDriver();
		 
		 
		String celData=null;
		//System.out.println("value is int .."+AbstractExcelUtils.getColumnWidthInPx(sheetNum));
		//AbstractExcelUtils.
		File src = new File(TESTDATA_SHEET_PATH);// takes the location of file
		fis = new FileInputStream(src);// this will read the above file
		XSSFWorkbook w1 = new XSSFWorkbook(fis);
		XSSFSheet sheet = w1.getSheet("login");
		int rowCount = sheet.getLastRowNum();
		Object[][] data = new Object[sheet.getLastRowNum()-1][sheet.getRow(0).getLastCellNum()];
		//5 rows,2 col object 4,2
		int colCount = sheet.getRow(0).getLastCellNum();
		for (int i = 1; i <rowCount; i++) {// take row count51 0
			//System.out.println("Row count "+rowCount);
			//Row row = sheet.getRow(i);
			for (int j = 0; j <colCount; j++)//
			{
				//System.out.println("coulmn count "+row.getLastCellNum());
				celData = sheet.getRow(i).getCell(j).toString();
				data[i-1][j]=celData;
				System.out.println(data[1][0]);

			}
		}
		 
	}}
		
	 
		

 
