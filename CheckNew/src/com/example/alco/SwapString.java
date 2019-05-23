package com.example.alco;

public class SwapString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("str1");
		String str2 = new String("str2");
		
		swap(str1, str2);
		int[] arr = new int[2];
		System.out.println(Math.ceil(3.14));
		System.out.println((int)Math.round((5-3)/2));
		System.out.println(str1);
		System.out.println(str2);
	}

	public static void swap(String str1,String str2){
		String temp;
		temp = str1;
		str1 = str2;
		str2 = temp;
		
		str1.concat("_append");
		str2.concat("_append");
		
		System.out.println(str1);
		System.out.println(str2);
	}
}
