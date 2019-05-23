package com.example.app;

import java.util.Random;

public class MyArrayList {

	String[] strArray;
	
	public MyArrayList(){
		strArray = new String[1];
	}
	
	public void add(String str){
		String[] strArrayNew = new  String[strArray.length+1];
		strArrayNew[strArray.length] = str;
		this.strArray = strArrayNew;
	}
	
	public void remove(int i){
		
	}
	public static void main(String[] args){
		MyArrayList m = new MyArrayList();
		m.add("ram");
		m.add("krishna");
		 Random rand = new Random();  // Choose a different seed
		 System.out.println(rand);
	       int index = rand.nextInt(m.strArray.length);
	       System.out.println(index);
	       
	}
}
