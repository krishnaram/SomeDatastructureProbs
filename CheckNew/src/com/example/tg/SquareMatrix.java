package com.example.tg;

public class SquareMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*"E#D#E#E#E",          
		"D#I#S#K#E",            
		"E#S#E#E#E",           
		"E#C#E#E#E",
		"E#E#E#E#E"*/
		String[] s = {"S#S",   
				"S#S"
				 };
		String word = "SSS";
		System.out.println(word_count(s, word));
	}
	
	 public static int word_count(String[] input1,String input2)
	 {
		 input2 = input2.toUpperCase();
		 char[][] inputArray = new char[input1.length][input1.length];
		 String[] temp;
		 int i =0,j=0;
		 for(String s:input1)
		 {
			 temp = s.split("#");
			 j=0;
			 if(temp.length == input1.length)
			 {
				 for(String str:temp)
				 {
					 inputArray[i][j] = Character.toUpperCase(str.charAt(0));
					 j++;
				 }
				 i++; 
			 }
			 else{
				 return 0;
			 }
			 
		 }
		 int match = 0;
		 for(int k =0;k<inputArray.length;k++)
		 {
			 for(int l =0;l<inputArray[k].length;l++)
			 {
				 if(inputArray[k][l] == input2.charAt(0))
				 {
					 if(input2.length()>1)
					 {
						 if(traverseRight(k, l, input2,inputArray))
						 {
							 match ++;
						 }
						 if(traverseDown(k, l, input2,inputArray))
						 {
							 match++;
						 }
						 if(traverseDiagonalDown(k, l, input2,inputArray))
						 {
							 match++;
						 }
						 if(traverseDiagonalUp(k, l, input2,inputArray))
						 {
							 match++;
						 }
					 }
					 else{
						 match++;
					 }
					
				 }
			 }
		 }
		 
		 return match;
	 }
	 
	 public static boolean traverseRight(int k,int l,String input,char[][] inputArray){
		 StringBuffer matcher = new StringBuffer();
		 for(int i=l;i<inputArray[k].length;i++)
		 {
			 matcher.append(inputArray[k][i]);
			 if(input.contains(matcher.toString()))
			 {
				 if(input.length() == matcher.length() && input.equals(matcher.toString()))
				 {
					 //System.out.println(matcher+"here traverseRight");
					 return true;
				 }
				 else if(input.length() == matcher.length())
				 {
					 return false;
				 }
			 }
			 else{
				 return false;
			 }
		 }
		 
		 return false;
	 }
	 public static boolean traverseDiagonalUp(int k,int l,String input,char[][] inputArray){
		 StringBuffer matcher = new StringBuffer();
		 for(int i=l;i<inputArray.length;i++)
		 {
			 if(k<inputArray.length)
			 {
				 matcher.append(inputArray[k][i]);
				// System.out.println(matcher);
				 if(input.contains(matcher.toString()))
				 {
					 if(input.length() == matcher.length() && input.equals(matcher.toString()))
					 {
						// System.out.println(matcher+"here traverseDiagonalUp");
						 return true;
					 }
					 else if(input.length() == matcher.length())
					 {
						 return false;
					 }
				 }
				 else{
					 return false;
				 }
				 k++;
			 }
			 
			 
		 }
		 return false;
	 }
	 public static boolean traverseDiagonalDown(int k,int l,String input,char[][] inputArray){
		 StringBuffer matcher = new StringBuffer();
		 for(int i=l;i<inputArray.length;i++)
		 {
			 if(k>=0)
			 {
				 matcher.append(inputArray[k][i]);
				 //System.out.println(matcher+" here");
				 if(input.contains(matcher.toString()))
				 {
					 if(input.length() == matcher.length() && input.equals(matcher.toString()))
					 {
						// System.out.println(matcher+"here traverseDiagonalDown");
						 return true;
					 }
					 else if(input.length() == matcher.length())
					 {
						 return false;
					 }
				 }
				 else{
					 return false;
				 }
				 k--; 
			 }
			 
			 
		 }
		 return false;
	 }
	 public static boolean traverseDown(int k,int l,String input,char[][] inputArray){
		 StringBuffer matcher = new StringBuffer();
		 for(int i=k;i<inputArray.length;i++)
		 {
			 matcher.append(inputArray[i][l]);
			 if(input.contains(matcher.toString()))
			 {
				 if(input.length() == matcher.length() && input.equals(matcher.toString()))
				 {
					 //System.out.println(matcher+"here trverse down");
					 return true;
				 }
				 else if(input.length() == matcher.length())
				 {
					 return false;
				 }
			 }
			 else{
				 return false;
			 }
		 }
		 
		 return false;
	 }


}
