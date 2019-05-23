package com.example.alco;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//The child can implement serializable, when parent not implementing serializable 
public class Child extends Parent implements Runnable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 10;
	public static void display() throws FileNotFoundException{
		System.out.println("In B");
	}
	public void fun(){
		System.out.println("derived fun");
	}

	public static void main(String[] args) {
		Integer a2 = 129, b1 = 129;
        System.out.println(a2 == b1);
        
        List<String> newList = new ArrayList<String>();
        
        newList.add("a");
        newList.add("a1");
        newList.add("a2");
        newList.add("a3");
        
        for(String n:newList)
        {
        	//newList.add(n);
        }
 
        
        Integer c = 100, d = 100;
        System.out.println(c == d);
		// TODO Auto-generated method stub
		Parent a = new Parent();
		// ParentInterFace p = new Pa
		try {
			a.display();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Child b= new Child();
		try {
			b.display();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //In child
		Parent a1= new Child();
		
		Parent fun = new Child();
		
		//Child fun method is called
		try {
			fun.fun();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Parents variable is called 
		// Fun is over rided but not the variable
		System.out.println(fun.x);
		
		LinkedList<String> cList = new LinkedList<String>();
		ArrayList<String> cAList = new ArrayList<String>();
		cList.add("Ram");
		cAList.add("Ram");
		cAList.add("");
		//cList.rem
		//cAList.remo
		try{
			int result = 5/0;
		}catch(Exception e){
			e.printStackTrace();
			//int x = 5/0;
			//If system.exit finally wont execute
			//System.exit(1);
		}
		//Less scoped exception cant be given after more scoped exception catch clause
		/*catch(NumberFormatException e){
			e.printStackTrace();
		}*/
		finally{
			System.out.println("In finally");
		}
		
		
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
