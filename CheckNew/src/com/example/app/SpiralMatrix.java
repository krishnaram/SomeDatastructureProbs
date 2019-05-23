package com.example.app;

import java.util.Scanner;

public class SpiralMatrix {

	public static void main(String[] args) {
		 try{  
             System.out.println("Enter matrix size to get spiral matrix");  
             Scanner sc = new Scanner(System.in);  
             String[] inter = sc.nextLine().trim().split(" ");  
             int size = Integer.parseInt(inter[0]);  
             System.out.println("Matrix Size is: "+size);  
             sc.close();  
             int higestValue = size*size;  
             int spiralMatrix[][] = new int[size][size];  
             int normalMatrix[][] = new int[size][size];  
             int normalValue = 0;  
             for(int i=0;i<size;i++)  
             {  
                  for(int j=0;j<size;j++)  
                  {  
                       normalMatrix[i][j] = ++normalValue;  
                       spiralMatrix[i][j] = 0;  
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
             int lastValue=0;  
             int step = 1;  
             int step1Col = 0;  
             int step1Row = 0;  
             int step2Col = 0;  
             int step2Row = 0;  
             int step3Col = 0;  
             int step3Row = 0;  
             int step4Col = -1;  
             int step4Row = 0;  
             while (lastValue < higestValue) {  
                  step = 1;  
                  //this is the step where value assigned in Horizontal incrementing positional way  
                  if(step == 1)  
                  {  
                       step1Row = step4Row;  
                       step1Col = ++step4Col;  
                       for(int j=step1Col;j<size;j++)  
                       {  
                            if(spiralMatrix[step1Row][j] == 0)  
                            {  
                                 spiralMatrix[step1Row][j] = ++lastValue;  
                                 step1Col = j;  
                            }  
                            else{  
                                 break;  
                            }  
                       }  
                       step = ++step;  
                  }  
                  //this is the step where value assigned in Vertical incrementing positional way  
                   if (step == 2)  
                  {  
                       step2Col = step1Col;  
                       step2Row = step1Row+1;  
                       for(int i=step2Row;i<size;i++)  
                       {  
                            if(spiralMatrix[i][step1Col] == 0)  
                                 {  
                                      spiralMatrix[i][step1Col] = ++lastValue;  
                                      step2Row = i;  
                                 }  
                                 else{  
                                      break;  
                                 }  
                       }  
                       step = ++step;  
                  }  
                  //this is the step where value assigned in Horizontal decrementing positional way  
                   if(step==3)  
                  {  
                       step3Row = step2Row;  
                       step3Col = step2Col-1;  
                            for(int j=step3Col;j>=0;j--)  
                            {  
                                 if(spiralMatrix[step3Row][j] == 0)  
                                 {  
                                      step3Col = j;  
                                      spiralMatrix[step3Row][j] = ++lastValue;  
                                 }  
                                 else{  
                                      break;  
                                 }  
                            }  
                       step = ++step;  
                  }  
                  //this is the step where value assigned in Vertical incrementing decrementing positional way  
                  if(step==4)  
                  {  
                            step4Row = --step3Row;  
                            step4Col = step3Col;  
                            for(int i=step4Row;i>=0;i--)  
                            {  
                                 if(spiralMatrix[i][step4Col] == 0)  
                                 {  
                                      step4Row = i;  
                                      spiralMatrix[i][step4Col] = ++lastValue;  
                                 }  
                                 else{  
                                      break;  
                                 }  
                            }  
                       step = ++step;  
                  }  
             }  
             System.out.println("Spiral Matrix is:\n");  
             for( int i=0;i<size;i++)  
             {  
                  for( int j=0;j<size;j++)  
                  {  
                       System.out.printf("%5d ",spiralMatrix[i][j]);  
                  }  
                  System.out.println("");  
             }  
        }  
        catch(Exception e)  
        {  
             e.printStackTrace();  
             System.out.println("Something Went wrong............Please run again.....");  
        }  

	}

}
