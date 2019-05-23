package com.example.tg;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * 
 6
 3 5 2 6 3 1
 4 1 2 2 1 1
 Ans:5
 
 6
 3 5 2 6 3 1
 4 5 2 2 5 6
 Ans:6
 
 6
 3 5 2 6 3 1
 4 5 -1 2 5 6
 
 7
 2 2 2 1 1 2 2 2
 0 0 0 1 1 2 2 2
 
 8
 2 2 2 1 1 2 2 2
 0 0 0 1 1 2 2 2
 
 7
 2 2 2 1 2 2 2
 0 0 0 1 1 2 2
 
 7
 2 2 2 1 2 2 2
 1 1 1 2 2 3 3
 
  7
 1 1 1 1 2 2 2
 1 1 1 2 2 3 3
 
  7
 2 2 2 1 2 1 1
 1 1 1 2 2 3 3
 ans:7
 */

public class BobTheBear {
  
	public static void main(String args[] ) throws Exception {

    	//Write code here
    	 Scanner sc = new Scanner(System.in);  
		 int numberOfSalmons = Integer.parseInt(sc.nextLine().trim());
		 int[] timeArray = new int[numberOfSalmons];
		 int[] lengthArray = new int[numberOfSalmons];
		 int[] tempArray = new int[numberOfSalmons];
		 String[] lengthString = sc.nextLine().trim().split(" ");
		 String[] timeString = sc.nextLine().trim().split(" ");
		 boolean nonExitFlag = true;
		 //Prepare length array
		 for(int i=0;i<numberOfSalmons;i++){
			 timeArray[i] = Integer.parseInt(timeString[i]);
			 
			 if(!(timeArray[i]>=0 && timeArray[i]<=1000000000)){
				 nonExitFlag = false;
			 }
		 }
		 
		//Prepare time array
		 for(int i=0;i<numberOfSalmons;i++){
			 lengthArray[i] = Integer.parseInt(lengthString[i]);
			 if(!(lengthArray[i]>=1 && lengthArray[i]<=1000000000)){
				 nonExitFlag = false;
			 }
		 }

		 
		 boolean flag = true;
		 List<String> numberOfSalmonFoundList = new ArrayList<String>();
		 String separator = ",";
		 StringBuffer currentSalmons = new StringBuffer("");
		 String currentSalmonString = "";
		 int firstBig = 0;
		 if(numberOfSalmons >=1 && numberOfSalmons <=1000 && nonExitFlag == true){
			 while(flag){
				 flag= false;
				 
				 currentSalmons = new StringBuffer("");
				 for(int i =0;i<numberOfSalmons;i++){
					 if(timeArray[i] <= 0 && lengthArray[i]>0){
							lengthArray[i] = lengthArray[i]-1;
							flag= true;
					}
					 else if(lengthArray[i]>0 ){
						timeArray[i] = timeArray[i]-1; 
						flag= true;
					}
					
					if(timeArray[i] <= 0 && lengthArray[i]>0)
					{
						currentSalmons.append(separator).append(i);
					}
				 }
				 if(currentSalmons.length() >=1)
				 {
					 currentSalmonString = currentSalmons.substring(separator.length());
					 numberOfSalmonFoundList.add(currentSalmonString);
				 }
			 }
			 
			 int intCount=0;
			 int count = 0;
			 for(int i =0;i<numberOfSalmonFoundList.size();i++){
				 count = 0;
				 tempArray = new int[numberOfSalmons];
				 for(String str:numberOfSalmonFoundList.get(i).split(",")){
						 tempArray[Integer.parseInt(str)] = 1;
						 count++;
				 }
				 for(int j=i+1;j<numberOfSalmonFoundList.size();j++){
					 intCount=0;
					 for(String str:numberOfSalmonFoundList.get(j).split(",")){
						 if( tempArray[Integer.parseInt(str)] != 1){
							 intCount++;
						 }
					 }
					 if(count+intCount>firstBig){
						 firstBig = count+intCount;
					 }
				 }
				
			 }
		 }
		 
		 System.out.println(firstBig);
   }
}