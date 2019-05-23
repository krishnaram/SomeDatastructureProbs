package com.example.app;

public class StringSplitPipe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pipeString = "TICAGRELOR|303001|synonym lib|125002";
		
		String[] pipeStrings = pipeString.split("\\|");
		
		for(String i:pipeStrings)
		{
			System.out.println(i);
		}

	}

}
