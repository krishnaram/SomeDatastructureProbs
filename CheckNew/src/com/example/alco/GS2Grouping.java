package com.example.alco;

import java.util.HashSet;
import java.util.Set;

public class GS2Grouping {

	public static void main(String[] args) {
		int[] newArray = {5,2,1,3,4,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(distinct(newArray));
		
	}

	private static int distinct(int[] queue) {
		Set<String> distinct= new HashSet<String>();
		
		for(int i=0;i<queue.length;i++)
		{
			for(int j=i+1;j<queue.length;j++)
			{
				if(queue[i]<queue[j])
				{
					for(int k=j+1;k<queue.length;k++)
					{
						if(queue[j]<queue[k])
						{
							System.out.println(queue[i]+""+queue[j]+""+queue[k]);
							distinct.add(queue[i]+""+queue[j]+""+queue[k]);
						}
					}
				}
				else if (queue[i]>queue[j]) {
					for(int k=j+1;k<queue.length;k++)
					{
						if(queue[j]>queue[k])
						{
							System.out.println(queue[i]+""+queue[j]+""+queue[k]);
							distinct.add(queue[i]+""+queue[j]+""+queue[k]);
						}
					}
				}
				
			}
		}
		return distinct.size();
		// TODO Auto-generated method stub
		
	}
	
	

}
