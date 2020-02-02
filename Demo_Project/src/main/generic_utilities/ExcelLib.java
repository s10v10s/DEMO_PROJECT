package com.billingsdk.genericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib 
{	
	 File  filePath = new File("C:\\Users\\vvdn\\Desktop\\CSDK\\VVDN_NTGU_CSDK.xlsx");
	
	public  String getExcelData1(String sheetName , int rowNum, int colNum) throws EncryptedDocumentException, 
	InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(colNum);
		String data = cel.getStringCellValue();
		return data;
	}
	
	public  int getRowCount(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount = rowCount+1;
	}
	
	public  void setExcelData(String sheetName ,  int rowNum, 
			                 int colNum, String data) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellType(cel.CELL_TYPE_STRING);
		FileOutputStream fos = new FileOutputStream(filePath);
		cel.setCellValue(data);
		wb.write(fos);
		wb.close();
	}
	
	public String getExcelData(String sheetName , int rowNum, int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		//String val = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return val;
	}
	
	
	
}
