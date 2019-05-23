package com.example.interview.mine;

import java.util.ArrayList;

public class HighestNumberForming {

	public static void main(String[] args) {
		ArrayList<Integer> arr; 
        arr = new ArrayList<>(); 
          
        //output should be 6054854654 
        arr.add(548); 
        arr.add(60); 
        arr.add(54); 
        arr.add(546);
        arr.add(746);
        
        
        printLargest(arr); 

	}

	private static void printLargest(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int indexToExchange;
		int temp;
		String number1;
		String number2;
		for(int i=0;i<arr.size()-1;i++) {
			indexToExchange = i;
			for(int j=i+1;j<arr.size();j++) {
				number1 = ""+arr.get(indexToExchange)+arr.get(j);
				number2 = ""+arr.get(j)+arr.get(indexToExchange);
				if(Integer.parseInt(number1)<Integer.parseInt(number2)) {
					indexToExchange = j;
				}
			}
			temp = arr.get(indexToExchange);
			arr.set(indexToExchange, arr.get(i));
			arr.set(i, temp);
		}
		for(Integer i: arr) {
			System.out.println(i);
		}
	}

}
