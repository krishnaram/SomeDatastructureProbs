package com.example.amazon;

public class BoundryMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix= {{0,1,1,0},{0,1,1,0}};
		findSquareBoundry(matrix);
	}
	
	public static void findSquareBoundry(int[][] mat){
		int highestLen;
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[i].length;j++) {
				if(mat[i][j] ==1)
				{
					highestLen = findDown(i,j,mat[i].length,mat.length);
					
				}
				
			}
		}
	}
	
	public static int findDown(int i,int j,int colHigh, int rowHigh) {
		int len = 0;
		for(int k =i;k<rowHigh;k++)
		{
			
		}
		return len;
	}
	
	public static int findHorizontal(int i,int j,int colHigh, int rowHigh) {
		int len = 0;
		return len;
		
	}
	
	public static int findUp(int i,int j,int colHigh, int rowHigh) {
		int len = 0;
		return len;	
	}
	
	public static int findDownHorizontal(int i,int j,int colHigh, int rowHigh) {
		int len = 0;
		return len;
	}

}
