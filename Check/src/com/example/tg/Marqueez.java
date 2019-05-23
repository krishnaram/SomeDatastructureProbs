package com.example.tg;

import java.util.Scanner;

public class Marqueez {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		char[] newChars = str.toCharArray();
		
		boolean repeat = false;
		int count =1;
		boolean change = true;
		while(change)
		{
			change = false;
			
			for(int i = 1;i<newChars.length;i++)
			{
				if(newChars[i] == '\0')
				{
					continue;
				}
				if(newChars[i] == newChars[i-1])
				{
					repeat = true;
					count++;
				}
				else{
					
					repeat = false;
					if(count >=3)
					{
						change = true;
						for(int j = count;j>0;j--)
						{
							newChars[i-j] = '\0';
							
							
						}
					}
					
					count= 1;
				}
			}
			StringBuffer newString = new StringBuffer();
			for(int i=0;i<newChars.length;i++)
			{
				if(newChars[i]!='\0')
					newString.append(newChars[i]);
			}
			newChars = newString.toString().toCharArray();
		}
		
		
		StringBuffer newString = new StringBuffer();
		for(int i=0;i<newChars.length;i++)
		{
			if(newChars[i]!='\0')
				newString.append(newChars[i]);
		}
		System.out.println(newString.toString());
	}

}
