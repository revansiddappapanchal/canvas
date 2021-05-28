package com.canvas.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
  //read data from property file
	public String readPropData(String propPath,String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		String propvalue = prop.getProperty(key,"Incorrect key");
		return propvalue;
	}
	
	//read data from excel file
	public String getCellData(String excelpath,String sheet,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		String excelValue = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		return excelValue;
	}
	
	//write data into excel file
	public void setCellData(String excelPath,String sheet,int row,int cell,String data) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);
	}
	//get last row number
	public int getRowCount(String excelPath,String sheet) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int rc = wb.getSheet(sheet).getLastRowNum();
		System.out.println(rc);
		return rc;
	}


}
