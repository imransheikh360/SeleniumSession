package com.app.collectionInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class ConvertListToArray {
	
	
	public void TestMethod()
	{
		List<String> names= new ArrayList<String>();
		
		names.add("Imran");
		names.add("Sheikh");
		names.add("Khan");
		names.add("Rahul");
		names.add("Singh");
		for(String s: names)
		{
			System.out.println(s);
		}
		
		
		//Converting List to array
		String [] strArray= new String[names.size()];
		for(int i=0; i<names.size(); i++)
		{
			strArray[i]= names.get(i);
		}
		
		System.out.println("======After converting into array================");
		
		for(int k=0; k<strArray.length; k++)
		{
			System.out.println(strArray[k]);
		}
	}
	
	public static void main(String[] args) {
		ConvertListToArray obj= new ConvertListToArray();
		obj.TestMethod();
	}

}
