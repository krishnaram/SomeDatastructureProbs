package com.example.iDeserve;

import java.util.ArrayList;
import java.util.List;

public class ArrayDivisible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] divisible= {0,2,4,8,12,20,18,4};
		int dividor = 4;
		List<String> pair = new ArrayList<String>();
		for(int i=0;i<divisible.length;i++)
		{
			for(int j=0;j<divisible.length;j++)
			{
				if((divisible[i]+divisible[j])%dividor == 0)
				{
					pair.add(divisible[i]+","+divisible[j]);
				}
			}
		}
		for(String p:pair)
		{
			System.out.println(p);
		}
	}

}
