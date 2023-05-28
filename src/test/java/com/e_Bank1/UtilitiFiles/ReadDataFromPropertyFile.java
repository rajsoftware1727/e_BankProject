package com.e_Bank1.UtilitiFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static FileInputStream file;
	public static  Properties properties;
	
	public static Object dataReadFromPropertyFile(String key) throws IOException
	{
		  file=new FileInputStream(System.getProperty("user.dir")+"//PropertyFile//data.properties");
		  properties=new Properties();
		  properties.load(file);   //it will load all the data from property file
		  return properties.get(key);
		
	}

}
