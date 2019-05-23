package com.example.interview;

import java.util.HashMap;
import java.util.Map;

public class MapActionIterator {
	public static void main(String[] args) {
		Map<String,String> gfg = new HashMap<String,String>(); 
	      
        // enter name/url pair 
        gfg.put("GFG", "geeksforgeeks.org"); 
        gfg.put("Practice", "practice.geeksforgeeks.org"); 
        gfg.put("Code", "code.geeksforgeeks.org"); 
        gfg.put("Quiz", "quiz.geeksforgeeks.org"); 
          
        // forEach(action) method to iterate map 
        gfg.forEach((k,v) -> System.out.println("Key = "
                + k + ", Value = " + v)); 

	}
}
