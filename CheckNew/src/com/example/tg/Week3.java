package com.example.tg;

public class Week3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String reversed = reversingOfWords("Man bites dog");
		System.out.println(reversed);
	}
	
	public static String reversingOfWords(String input1)
    {
		String[] split = input1.trim().split(" ");String output = "";int i=split.length-1;
		while(output.trim().length()!=input1.length())
		{	output = output.concat(split[i--]+ " ");System.out.println(output);}
		return output.trim();
	    //Write code here
	    
    }


}
