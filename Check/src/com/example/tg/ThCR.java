package com.example.tg;

public class ThCR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int highest = ThirstyCrowProblem(new int[]{5,58},1);
		System.out.println("Stones "+highest);
	}

	public static int ThirstyCrowProblem(int[] input1,int input2)
    {
		int stones = 0;
		int numPots = 0;
		for(int i= 0;i<input1.length;i++)
		{
			if(input1[i] <= 0 || input2 <= 0)
			{
				return -1;
			}
		}
		while(numPots != input2)
		{
			for(int i= 0;i<input1.length;i++)
			{
				
				
				if(input1[i] != 0)
				{
					input1[i] = input1[i]-1;
					
					
					stones ++;
					if(input1[i] == 0)
					{
						numPots++;
					}

					
				} 
				
				
			}
			if(numPots == input2)
			{
				break;
			}
		}
		
		return stones;
	    //Write code here
    }
}
