package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	String path;
	//XSSF and HSSF 
	XSSFWorkbook wb ;
	XSSFSheet sheet;
	XSSFRow row ;
	XSSFCell cell;
	
	public ExcelReader(String path)
	{
		this.path = path;
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		
	}
	
	public String getCellData(String sheetName , String colName , int rowNum)
	{
		int index = wb.getSheetIndex(sheetName);
		int col_Num = 0;
		sheet = wb.getSheetAt(index);
		
		//for row
		row = sheet.getRow(0);
		for(int i =0;i< row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
			{
				col_Num = i;
			}
		}
		
		//for column
		row = sheet.getRow(rowNum - 1);
		cell = row.getCell(col_Num);
		return cell.getStringCellValue();
		
		
	}

}
