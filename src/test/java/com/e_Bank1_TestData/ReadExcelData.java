package com.e_Bank1_TestData;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.e_Bank1.UtilitiFiles.XLUtils;

public class ReadExcelData {
	public static int rowCount;
	public static int columnCount;
	public static String sheetName;
	public static String filePath;
	public static String data[][]=null;

	@DataProvider(name="raj")
	public String[][] readExcelData() throws IOException
	{
	//public static void main(String args[]) throws IOException
	{
		filePath=System.getProperty("user.dir")+"//src//test//java//com//e_Bank1_TestData//DataProvider.xlsx";
		sheetName="Login";
		rowCount=XLUtils.getRowCount(filePath,sheetName);
	   	columnCount=XLUtils.getColumnCount(filePath,sheetName,1);

 		data=new String[rowCount-1][columnCount];
		for(int row=1;row<rowCount;row++)
		{
 
			for(int column=0;column<columnCount;column++)
			{
			data[row-1][column]=XLUtils.getCellData(filePath, sheetName,row,column);
 
			}
		}
		return data;
		//Read array data
		/* for(String[] i:data)
		 {
			 for(String j:i)
			 {
				 System.out.println(j);
			 }
		 }*/
  		
 		
		
		
	}

	}
}
