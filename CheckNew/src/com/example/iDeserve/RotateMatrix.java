package com.example.iDeserve;

import java.util.Scanner;

public class RotateMatrix {

	public static void main(String[] args) {
		 System.out.println("Enter matrix size to get spiral matrix");  
         Scanner sc = new Scanner(System.in);  
         String[] inter = sc.nextLine().trim().split(" ");  
         int size = Integer.parseInt(inter[0]);  
         System.out.println("Matrix Size is: "+size);  
         sc.close();  
         int higestValue = size*size;  
         int rotatedMatrix[][] = new int[size][size];  
         int normalMatrix[][] = new int[size][size];  
         int normalValue = 0;  
         for(int i=0;i<size;i++)  
         {  
              for(int j=0;j<size;j++)  
              {  
                   normalMatrix[i][j] = ++normalValue;  
                   rotatedMatrix[i][j] = 0;  
              }  
         }  
         System.out.println("Normal Matrix is:\n");  
         for(int i=0;i<size;i++)  
         {  
              for(int j=0;j<size;j++)  
              {  
                   System.out.printf("%5d",normalMatrix[i][j]);  
              }  
              System.out.println("");  
         }
         
         for(int j=size-1;j>=0;j--)
         {
        	 for(int i=0;i<size;i++)
        	 {
        		
        		 rotatedMatrix[(j-size+1)*-1][i] = normalMatrix[i][j];
        	 }
         }
         
         System.out.println("Rotated Matrix is:\n");  
         for(int i=0;i<size;i++)  
         {  
              for(int j=0;j<size;j++)  
              {  
                   System.out.printf("%5d",rotatedMatrix[i][j]);  
              }  
              System.out.println("");  
         }
	}

}
