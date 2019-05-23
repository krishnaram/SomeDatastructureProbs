package com.example.amazon;

import java.util.Arrays;

public class FindNextHighest {

	 public static void main(String[] args) 
	 {
	        char digits[] = { '5','3','4','9','7','6' };
	        int n = digits.length;
	        findNext(digits, n);
	        //Next number with same set of digits is 536479
	 }
	 
	// Utility function to swap two digit
	    static void swap(char ar[], int i, int j) 
	    {
	        char temp = ar[i];
	        ar[i] = ar[j];
	        ar[j] = temp;
	    }

	private static void findNext(char[] digits, int n) {
		int i=0;
		
		for(i=n-1;i>0;i--)
		{
			if(digits[i]>digits[i-1])
			{
				break;
			}
				
		}
		
		// If no such digit is found, then all 
        // digits are in descending order means 
        // there cannot be a greater number with 
        // same set of digits
        if (i == 0) 
        {
            System.out.println("Not possible");
        } 
        else
        {
            int x = digits[i - 1], min = i;
             
            // II) Find the smallest digit on right 
            //Here min first is 7 then 6
            // side of (i-1)'th digit that is greater 
            // than number[i-1]
            for (int j = i + 1; j < n; j++) 
            {
                if (digits[j] > x && digits[j] < digits[min]) 
                {
                    min = j;
                }
            }
 
            // III) Swap the above found smallest 
            // digit with number[i-1]
            swap(digits, i - 1, min);
 
            // IV) Sort the digits after (i-1) 
            // in ascending order
            Arrays.sort(digits, i, n);
            System.out.print("Next number with same" +
                                    " set of digits is ");
            for (i = 0; i < n; i++)
                System.out.print(digits[i]);
        }
	}

}
