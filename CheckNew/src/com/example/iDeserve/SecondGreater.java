package com.example.iDeserve;

public class SecondGreater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray = {12,10,15,18,99,20};
		int temp =0 ;
		int secGrt =0 ;
		for(int i = 0;i<myArray.length;i++)
		{
			if(temp<myArray[i])
			{
				secGrt = temp;
				temp = myArray[i];
				
			}
			else if(secGrt<myArray[i])
			{
				secGrt = myArray[i];
			}
			
		}
		System.out.println("================================================");
		System.out.println(secGrt);
	}

}
