package com.example.tg;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangeOfK {

	public static void main(String[] args) {
//		12
//		3
//		4
//		6
//		15
//		
		System.out.println(CoinChange(12,new int[]{3,4,6,15}));

	}
	
	//Got 40% in last submit
	public static String CoinChange(int input1,int[] input2)
    {
		try{
			long[] table = new long[input1+1];

		    // Initialize all table values as 0
		    Arrays.fill(table, 0);   //O(n)
		    Long count;
		    ArrayList<Long> duplicate = new ArrayList<Long>();
		    if(input1 > 0)
		    {
		    	for(int i=0;i<input2.length;i++)
				{
					//Checks duplicate and also checks whether it is less than given value
					//also make sure all the coins are existing not less than 1
					if(input2[i] <= input1 && input2[i] >= 1 && !duplicate.contains(Long.valueOf(input2[i])))
					{
						 for (int j=1; j<table.length; j++)
				         {
							if(j%input2[i] == 0)
							{
								if(table[j] >0)
								{
									if(j+input2[i] <=input1)
									{
										table[j+input2[i]] = table[j+input2[i]]+ table[j];
									}
										
								}
								 table[j]++;
							}
							else if(table[j] >0)
							{
								if(j+input2[i] <=input1)
								{
									table[j+input2[i]] = table[j+input2[i]]+ table[j];
								}
								
							}
				         }
					} //If array of coins having non existing coins
					else if(input2[i] < 1)
					{
						table[input1] = 0;
						break;
					}
					duplicate.add(Long.valueOf(input2[i]));
					
				}
		    }
			
			count = table[input1];
			return count.toString();
		}
		catch(Exception e)
		{
			return 0+"";
		}
		
    }

}
