package com.example.tg;

import java.util.Scanner;

public class Trxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		char[] newChars = str.toCharArray();
		
		boolean repeat = true;
		int count =1;
		
		String newInterString = new String(newChars);
		
		while(repeat){
			repeat =false;
			for(int i = 1;i<newChars.length;i++)
			{
				if(newChars[i] == newChars[i-1])
				{
					count++;
					repeat =true;
				}
				else{
					if(count >=2)
					{
						for(int j = count;j>0;j--)
						{
							newChars[i-j] = '\0';
						}
					}
					
					count= 1;
				}
			}
		
			newInterString = new String(newChars);
			newInterString =newInterString.replace("\0", "");
			newChars = newInterString.toCharArray();
		}
		
		System.out.println(newInterString+" interString");
		StringBuffer newString = new StringBuffer();
		for(int i=0;i<newChars.length;i++)
		{
			if(newChars[i]!='\0')
				newString.append(newChars[i]);
		}
		System.out.println(newString.toString());
		
	}

}
//abcdeedcbfgf