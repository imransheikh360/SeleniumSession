package com.app.seleniumsession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class ReadCSVFile {
	
	String line;
	public void readCSVFile()
	{
		
		String filePath= "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Files\\ImranCSV.csv";
		File file = new File(filePath);
		
		BufferedReader br= null;
		
		String splitBy= ",";
		try 
		{
			 br = new BufferedReader(new FileReader(filePath));
			 while( (line= br.readLine()) !=null)
			 {
				System.out.println("Complete line is " + line);
				/* String [] col= line.split(splitBy);
				 System.out.println( col[2] + " : " + col[3]);*/
						 
			 }
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		
		ReadCSVFile obj= new ReadCSVFile();
		obj.readCSVFile();
	}
}
