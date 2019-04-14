package com.app.collectionInterviewQuestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ImplementComparableStudent1 {
	
	
	
	public static void main(String[] args) {
		
		ComparableStudent1 obj1= new ComparableStudent1(011, "Imran", "Noida");
		ComparableStudent1 obj2= new ComparableStudent1(033, "Khan", "Delhi");
		ComparableStudent1 obj3= new ComparableStudent1(031, "Akash", "Zllahabd");
		
	List<ComparableStudent1> sortName= new ArrayList<ComparableStudent1>();
			sortName.add(obj1);
			sortName.add(obj2);
			sortName.add(obj3);
		
		Collections.sort(sortName);
		
		for(ComparableStudent1 st:sortName){  
			//System.out.println(st.rollNo+" "+st.name+" "+st.address);  
			System.out.println(st.name+" "+st.address);  
			}  
		
		
	}

}
