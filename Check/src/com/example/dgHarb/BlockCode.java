package com.example.dgHarb;

public class BlockCode {
	static int  count;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		
		{
			count++;
			if(count == 10)
			{
				count = 0;
			}
		}
		int[] sortRandom = {10,12,15,2,7,9};
		int given = 7;
		int temp = 0;
		int mid = sortRandom.length/2;
		int der = binarySearch(sortRandom,0,sortRandom.length-1,given,sortRandom[0]);
		System.out.println("near  greater number or same number "+der);
	}
	private static int binarySearch(int[] sortRandom,int start, int length, int given, int temp) {
		if(length >= start)
		{
			int midIndex = start+ (length - start)/2;
			System.out.println("MidIndex"+midIndex);
			int mid = sortRandom[midIndex];
			if(mid==given)
			{
				return mid;
			}
			else if((temp>mid && mid>given) || (given>temp && mid>given)) 
			{
				temp = mid;
				
			}
			int midFrontTemp = binarySearch(sortRandom,midIndex+1, length,given,temp);
			int midBackTemp = binarySearch(sortRandom,start,midIndex-1,given,temp);
			if((temp>midFrontTemp && midFrontTemp>given) || (given>midFrontTemp && midFrontTemp>given))
			{
				temp = midFrontTemp;
			}
			if((temp>midBackTemp && midBackTemp>given) || (given>midBackTemp && midBackTemp>given))
			{
				temp = midBackTemp;
			}
			
			return temp;
		}
		
		
		return temp;
	}
	
	
	

}
