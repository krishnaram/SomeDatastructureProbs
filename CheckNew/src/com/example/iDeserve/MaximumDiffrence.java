package com.example.iDeserve;

public class MaximumDiffrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 3, 10, 6, 4, 8, 1};
		
		int minEle = arr[0];
		int maxDifference = 0;
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-minEle >maxDifference) {
				maxDifference = arr[i] - minEle;
			}
			else if(arr[i]<minEle) {
				minEle = arr[i];
			}
		}
		System.out.println("Max difference:"+maxDifference+" min element:"+minEle);
	}

}
