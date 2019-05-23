package com.example.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence = "zero one one two three four five six seven eight nine ten";
		String[] words = sentence.split(" ");
		Map<String,Integer> fibSeries = new HashMap<String,Integer>();
		fibSeries.put("zero", 0);
		fibSeries.put("one", 1);
		
		int fibLast = 1;
		int fibBeforeLast = 0;
		for(int i=2;fibLast<=10;i++) {
			int fib = fibLast+fibBeforeLast;
			fibSeries.put(words[i+1], fib);
			fibBeforeLast = fibLast;
			fibLast = fib;
			System.out.println(words[i+1]+" "+fib);
		}
		/*System.out.println(fibSeries.size());
		for(int i=0;i<words.length;i++)
		{
			if()
		}*/
	}

}

/*class Employee{
	String name;
	List<Employee> downTree;
	
	public Employee(String name,String downTreeName) {
		this.name = name;
		this.downTree = new ArrayList<Employee>();
		if(downTreeName !=null)
		{
			this.downTree.add(new Employee(downTreeName, null));
		}
	}
	
	public void addEmployee(String name) {
		if(name == null)
		this.downTree.addAll(name);
	}
	
}
*/