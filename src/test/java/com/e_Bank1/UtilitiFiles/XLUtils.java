package com.e_Bank1.UtilitiFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static  XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fo;
	
	//create method for Rowcount
	
	public static int getRowCount(String xlFile,String sheetName) throws IOException
	{
		  fi=new FileInputStream(xlFile);
		  wb=new XSSFWorkbook(fi);
		  sh=wb.getSheet(sheetName);
		  return sh.getPhysicalNumberOfRows();
	}
	
	//create method for Columncount
	
		public static int getColumnCount(String xlFile,String sheetName,int rowNo) throws IOException
		{
			  fi=new FileInputStream(xlFile);
			  wb=new XSSFWorkbook(fi);
			  sh=wb.getSheet(sheetName);
			  row=sh.getRow(rowNo);
			  return row.getPhysicalNumberOfCells();
 		}
		
		//create method for getting celldata from excel
		
			public static String getCellData(String xlFile,String sheetName,int rowNo,int columnNo) throws IOException
			{
				  fi=new FileInputStream(xlFile);
				  wb=new XSSFWorkbook(fi);
				  sh=wb.getSheet(sheetName);
				  row=sh.getRow(rowNo);
				  cell=row.getCell(columnNo);
				  String data;
				  DataFormatter formatter=new DataFormatter();
				  data=formatter.formatCellValue(cell);
				  wb.close();
				  fi.close();
				  return data;
 	 		}
			
			//create method for set celldata from excel
			
			public static void setCellData(String xlFile,String sheetName,int rowNo,int columnNo,String data) throws IOException
			{
				  fi=new FileInputStream(xlFile);
				  wb=new XSSFWorkbook();
				  sh=wb.getSheet(sheetName);
				  row=sh.getRow(rowNo);
				  cell=row.getCell(columnNo);
 				  cell.setCellValue(data);
				  fo=new FileOutputStream(xlFile);
				  wb.write(fo);
				  wb.close();
				  fi.close();
				  fo.close();

  	 		}
		
	

}
