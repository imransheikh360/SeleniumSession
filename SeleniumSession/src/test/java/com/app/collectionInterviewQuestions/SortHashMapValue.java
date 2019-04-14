package com.app.collectionInterviewQuestions;
// Java program to sort hashmap by values 
import java.util.*; 
import java.lang.*; 

public class SortHashMapValue { 

	// function to sort hashmap by values 
	public static HashMap<Integer,String> sortByValue(HashMap<Integer,String> hm) 
	{ 
		// Create a list from elements of HashMap 
		List<Map.Entry<Integer,String> > list = 
			new LinkedList<Map.Entry<Integer,String> >(hm.entrySet()); 

		// Sort the list 
		Collections.sort(list, new Comparator<Map.Entry<Integer,String> >() { 
			public int compare(Map.Entry<Integer,String> o1, 
							Map.Entry<Integer,String> o2) 
			{ 
				return (o1.getValue()).compareTo(o2.getValue()); 
			} 
		}); 
		
		// put data from sorted list to hashmap 
		HashMap<Integer,String> temp = new LinkedHashMap<Integer,String>(); 
		for (Map.Entry<Integer,String> aa : list) { 
			temp.put(aa.getKey(), aa.getValue()); 
		} 
		return temp; 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 

		HashMap<Integer,String> hm = new HashMap<Integer,String>(); 

		// enter data into hashmap 
		hm.put(98, "Math"); 
		hm.put(85, "Data Structure"); 
		hm.put(91, "Database"); 
		hm.put(95, "Java"); 
		hm.put(79, "Operating System"); 
		hm.put(80, "Networking"); 
		Map<Integer,String> hm1 = sortByValue(hm); 

		// print the sorted hashmap 
		for (Map.Entry<Integer,String> en : hm1.entrySet()) { 
			System.out.println("Key = " + en.getKey() + 
						", Value = " + en.getValue()); 
		} 
	} 
} 
