package com.example.iDeserve;

public class MissingEle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 7, 6, 5, 3,2,9,10};
		int len = 10;
		int interLen = len-arr.length;
		int[] missing = new int[interLen];
		int sum = 0;
		
		int sumTotal = 0;
		
		for(int i=0;i<len;i++)
		{
			sumTotal = sumTotal+i+1;
			if(i<arr.length)
			{sum = sum+arr[i];
			
			if(arr[i]+1<arr.length)
			arr[arr[i]+1] = 0;
			}
			
			
		}
		
		System.out.println(sum);
		System.out.println(sumTotal);
		int interSum = sumTotal -sum;
		
		
	}

}
