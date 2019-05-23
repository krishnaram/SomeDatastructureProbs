package com.example.alco;

public class FindOddNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(oddNumbers(2, 5));
	}
	
	 static int[] oddNumbers(int l, int r) {
	        if(r<l)
	        {
	           return new int[1];
	        }
	        int j = 0;
	        int length = (int)Math.ceil((r-l));
	        int[] odds = new int[length];
	        for(int i = l;i<=r;i++)
	        {
	            if(i%2 != 0)
	            {
	                odds[j] = i;
	                j++;
	            }
	        }
	        return odds;
	    }
}
