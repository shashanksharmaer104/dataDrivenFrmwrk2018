package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.frameworks.dataDrivenFrmwrk2018.Constant;

public class ExcelUtils {

	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	private static XSSFRow Row;
	private static XSSFCell Cell;
	
	//This method is to set the File path and to open the Excel file
	public static void setExcelFile(String path, String sheetName) {
		try {
			FileInputStream excelFile = new FileInputStream(path);
			
			ExcelWBook = new XSSFWorkbook(excelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//This method is to read the test data from the Excel cell
	public static String getCellData(int row, int col) {
		try {
			Cell = ExcelWSheet.getRow(row).getCell(col);
			String cellData = Cell.getStringCellValue();			
			return cellData;
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	//This method is to write in the Excel cell
	public static void setCellData(String result, int row, int col) {
		try {
			Row = ExcelWSheet.getRow(row);
			Cell = Row.getCell(col, Row.RETURN_BLANK_AS_NULL);
			
			if(Cell == null) {
				Cell = Row.createCell(col);
				Cell.setCellValue(result);
			}else{
				Cell.setCellValue(result);
			}
			
			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
			ExcelWBook.write(fileOut);
			
			fileOut.flush();
			fileOut.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object[][] getTableArray(String filePath, String sheetName) {
		String[][] tabArry = null;
		try {
			FileInputStream ExcelFile = new FileInputStream(filePath);
			
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			int startRow = 1;
			int startCol = 1;
			
			int ci,cj;
			ci=0;
			
			int totalRows = ExcelWSheet.getLastRowNum();
			int totalCols = 2;
			
			tabArry = new String[totalRows][totalCols];
			
			for (int i = startRow; i <= totalRows; i++,ci++) {
				cj=0;
				
				for (int j = startCol; j <= totalCols; j++,cj++) {
					tabArry[ci][cj] = getCellData(i, j);
					System.out.println(tabArry[ci][cj]);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tabArry;
	}
}
