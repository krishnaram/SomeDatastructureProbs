package com.example.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContinuesMatrix {
	
	
	

	public static void main(String[] args) {
		
			File file = new File("file.txt");
			 FileWriter fw = null;
			try {
				fw = new FileWriter(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 PrintWriter pw = new PrintWriter(fw);
		// TODO Auto-generated method stub
		int[][] matrix ={{1,0,0,0,0}
						,{1,1,0,1,1}
						,{1,0,1,0,1}
						,{0,0,1,0,1}};
		
		int tempHighest = 0;
		int highest = 0;
		
		
		
		
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				tempHighest = 0;
				if(matrix[i][j] == 1)
				{
					pw.println("=================================================");
				 tempHighest = findConsecutiveLength(i,j,matrix,1,pw);
				 pw.println("=================================================");
				 	if(tempHighest>highest)
				 	{
				 		highest = tempHighest;
				 	}
					 
				}
				
			}
		}
		pw.println(highest);
		pw.close();
		try {
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static int findConsecutiveLength(int i, int j, int[][] oldMatrix, int tempHighest,PrintWriter pw) {
		pw.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		pw.println("i"+i+" j"+j+" val:"+oldMatrix[i][j]);
		int temp = tempHighest;
		int[][] matrix = new int[oldMatrix.length][oldMatrix[0].length];
		for(int l=0;l<oldMatrix.length;l++)
		{
			for(int k=0;k<oldMatrix[l].length;k++)
			{
				matrix[l][k] = oldMatrix[l][k];
				 pw.print("   ");
				 pw.print(matrix[l][k]);
			}
			pw.println();
		}
		if(i>oldMatrix.length-1 || j>oldMatrix[0].length-1)
		{
			return tempHighest;
		}
		matrix[i][j] = 0;
		pw.println("Higesht: "+tempHighest);
		int oneMoretemp = 0;
		//row next or before
		if(i+1<matrix.length)
		{
			
			if(matrix[i+1][j] == 1)
			{
				pw.println("Row next:");
				temp = findConsecutiveLength(i+1,j,matrix, tempHighest+1,pw);
			}
		}
		if(i-1>=0)
		{
			
			if(matrix[i-1][j] == 1)
			{
				pw.println("Row before:");
				oneMoretemp = findConsecutiveLength(i-1,j,matrix, tempHighest+1,pw);
				if(temp<oneMoretemp)
				{
					temp = oneMoretemp;
				}
			}
		}
		//col next or before
		if(j+1<matrix[i].length)
		{
			
			if(matrix[i][j+1] == 1)
			{
				pw.println("Col next:");
				oneMoretemp = findConsecutiveLength(i,j+1,matrix, tempHighest+1,pw);
				if(temp<oneMoretemp)
				{
					temp = oneMoretemp;
				}
			}
		}
		if(j-1>=0)
		{
			
			if(matrix[i][j-1] == 1)
			{
				pw.println("Col before:");
				oneMoretemp = findConsecutiveLength(i,j-1,matrix, tempHighest+1,pw);
				if(temp<oneMoretemp)
				{
					temp = oneMoretemp;
				}
			}
		}
		//Diagonal 1st
		if(i+1<matrix.length && j+1<matrix[i].length)
		{
			if(matrix[i+1][j+1] == 1)
			{
				pw.println("Diagonal next:");
				oneMoretemp = findConsecutiveLength(i+1,j+1,matrix, tempHighest+1,pw);
				if(temp<oneMoretemp)
				{
					temp = oneMoretemp;
				}
			}
			
		}
		if(i-1>=0 && j-1>=0)
		{
			if(matrix[i-1][j-1] == 1)
			{
				pw.println("Diagonal next behind:");
				oneMoretemp = findConsecutiveLength(i-1,j-1,matrix, tempHighest+1,pw);
				if(temp<oneMoretemp)
				{
					temp = oneMoretemp;
				}
			}
		}
		//Diagonal 2nd
		if(i+1<matrix.length && j-1>=0)
		{
			if(matrix[i+1][j-1] == 1)
			{
				pw.println("Diagonal back :");
				oneMoretemp = findConsecutiveLength(i+1,j-1,matrix,tempHighest+1,pw);
				if(temp<oneMoretemp)
				{
					temp = oneMoretemp;
				}
			}
		}
		if(i-1>=0 && j+1<matrix[i].length)
		{
			if(matrix[i-1][j+1] == 1)
			{
				pw.println("Diagonal back  behind:");
				oneMoretemp = findConsecutiveLength(i-1,j+1,matrix,tempHighest+1,pw);
				if(temp<oneMoretemp)
				{
					temp = oneMoretemp;
				}
			}
		}
		
		
		return temp;
		// TODO Auto-generated method stub
		
	}

}
