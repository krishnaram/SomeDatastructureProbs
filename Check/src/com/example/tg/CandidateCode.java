package com.example.tg;

public class CandidateCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = (int)(Math.random()*1000)%6+1;
		//System.out.println(Math.random());
		System.out.println(i);
		
		char[] charArray = {'a', 'b', 'c'};
		String str = String.valueOf(charArray);
		charArray = str.toCharArray();
		
		int[] myarr ={1, 0 ,1, 1, 0, 1, 0, 1, 1, 1, 0, 1};
		
		int higest = 0;
		int tempHigest = 0;
		int indexConverted = 0;
		System.out.println(str);
		for(int j=0;j<myarr.length;j++)
		{
			if(myarr[j] == 0)
			{
				myarr [j] = 1;
				for(int k=0;k<myarr.length;k++)
				{
					if(myarr[k] == 1)
					{
						tempHigest++;
					}
					else{
						if(tempHigest > higest)
						{
							higest = tempHigest;
							indexConverted = j;
						}
						tempHigest = 0;
						
					}
				}
				myarr [j] = 0;
			}
			
			
			
			tempHigest = 0;
		}
		
		
		System.out.println(higest);
		System.out.println(indexConverted);
	}

}
