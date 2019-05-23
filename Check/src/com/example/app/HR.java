package com.example.app;

import java.util.List;

public  class HR  implements IHRFunctions {
	
	public   String[] employeeList(String[] listOfEmployees) {
		String sortedEmployeeList[] = new String[listOfEmployees.length];
		
		// write your code here.

		
		return sortedEmployeeList;
	}
	
	public String[] topPerformers(String[] listOfEmployees, List<int[]> parameters) {
		String topPerformers[] = new String[3];
		
		// write your code here.
		
		return topPerformers;
	}
	
	public String parameterTopper(String[] listOfEmployees, List<int[]> parameters, String parameterType) {
		String parameterTopper = "";
		
		// write your code here.
		
		return parameterTopper;
	}
	
	public String[] lazyEmployees(String[] listOfEmployees, int[] attendenceList) {
		String lazyEmployeesList[] = new String[5];
		
		// write your code here.
		
		return lazyEmployeesList;
	}

}
