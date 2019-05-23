package com.example.iDeserve;

public class AjAiMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		int highest = 0;
		for(int i = 0;i<arr.length;i++)
		{
			for(int j = arr.length-1;j>=0;j--)
			{
				if(arr[j]>arr[i])
				{
					if(highest<(j-i))
					{
						highest = j-i; 
					}
				}
			}
		}
		System.out.println(highest);
	}

}
