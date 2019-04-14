package com.app.collectionInterviewQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortHashMapKeys {
	
	
	public void TestMethod()
	{
		Map<Integer, String> st= new HashMap<Integer,String>();
		st.put(1, "Imran");
		st.put(2, "Sheikh");
		st.put(9, "Khan");
		st.put(6, "Test");
		st.put(5, "Logica");
		
		for(Map.Entry<Integer, String> mp: st.entrySet())
		{
			System.out.println("Keys: " + mp.getKey() + " Values: " + mp.getValue());
		}
		
		System.out.println("==========After Sorting===============");
		
		
		Map<Integer,String> newMap= new TreeMap<Integer, String>(st);
		Set stKey= newMap.entrySet();
		Iterator itr= stKey.iterator();
		
		while(itr.hasNext()) {
	        Map.Entry pair = (Map.Entry)itr.next();
	        //System.out.print(pair.getKey() + ": ");
	        System.out.println(pair.getValue());
	    } 
		
		
		
		
				
		
	}
	
	public static void main(String[] args) {
		
		SortHashMapKeys obj= new SortHashMapKeys();
		obj.TestMethod();
	}

}
