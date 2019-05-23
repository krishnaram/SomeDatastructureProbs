package com.example.tg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 
11
-1 0 0 1 1 2 2 3 4 5 6
1
Ans:2

11
-1 0 0 0 1 1 2 2 3 4 5 6
1
Ans:0 (wrong input)

11
-1 0 0 1 1 1 2 2 3 4 5 6
1
Ans:0 (wrong input)

11
-1 0 0 1 1 2 2 3 4 5 6
10
Ans:4

11
-1 0 0 1 1 2 2 3 4 5 6
5
Ans:3

11
-1 0 0 1 1 2 2 3 4 5 6
2
Ans:2

14
-1 0 0 1 1 2 2 3 4 5 6 3 4 6
2
Ans:4

14
-1 0 0 1 1 2 2 3 4 5 6 3 4 6
1
Ans:3

15
-1 0 0 1 1 2 2 3 4 5 6 3 4 6 5
1
Ans:4

14
-1 0 0 1 1 2 2 3 4 5 6 3 4 6
0
Ans:0

14
-1 0 0 1 1 2 2 3 4 5 6 3 4 6
9
Ans:7

3
-1 0 0
1
Ans:1

4
-1 0 0 1
3
Ans:2

3
-1 0 0
2
Ans:1

1
-1 0
0
Ans:0

3
-1 0 0
0
Ans:0

5
-1 0 0 1 1
2
Ans:2


14
-1 0 0 1 1 2 2 3 4 5 6 3 4 6
2
Ans:4

14
-1 0 0 0 1 1 2 2 3 4 5 6 3 4 6
2
Ans:wrong input

10
-1 0 0 1 2 3 2 1 3 5
6
Ans:4

10
-1 0 0 1 2 3 2 1 3 5
3
Ans:3

11
-1 0 0 1 2 3 2 1 3 5 28
3
Ans:0

46
-1 0 0 1 2 3 2 1 3 5 6 7 8 9 10 11 12 13 14 15 16 15 16 17 18 19 20 21 22 25 27 11 12 13 14 28 29 30 31 32 33 34 35 36 37 38
18
Ans:10

46
   1 2 3 4 5 6 7 8 91011121314 15 16 17 18  19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45
-1 0 0 1 2 3 2 1 3 5 6 7 8 9 10 11 12 13 14 15 16 15 16 17 18 19 20 21 22 25 27 11 12 13 14 28 29 30 31 32 33 34 35 36 37 38
10
Ans:10

46
-1 0 0 1 2 3 2 1 3 5 6 7 8 9 10 11 12 13 14 15 16 15 16 17 18 19 20 21 22 25 27 11 12 13 14 28 29 30 31 32 33 34 35 36 37 38
11
Ans:9

46
-1 0 0 1 2 3 2 1 3 5 6 7 8 9 10 11 12 13 14 15 16 15 16 17 18 19 20 21 22 25 27 11 12 13 14 28 29 30 31 32 33 34 35 36 37 38
10
Ans:10

46
-1 0 0 1 2 3 2 1 3 5 6 7 8 9 10 11 12 13 14 15 16 15 16 17 18 19 20 21 22 25 27 11 12 13 14 28 29 30 31 32 33 34 35 36 37 38
12
Ans:9

46
-1 0 0 1 2 3 2 1 3 5 6 7 8 9 10 11 12 13 14 15 16 15 16 17 18 19 20 21 22 25 27 11 12 13 14 28 29 30 31 32 33 34 35 36 37 38
33
Ans:10

46
-1 0 0 1 2 3 2 1 3 5 6 7 8 9 10 11 12 13 14 15 16 15 16 17 18 19 20 21 22 25 27 11 12 13 14 28 29 30 31 32 33 34 35 36 37 38
28
Ans:11

46
-1 0 0 1 2 3 2 1 3 5 6 7 8 9 10 11 12 13 14 15 16 15 16 17 18 19 20 21 22 25 27 11 12 13 14 28 29 30 31 32 33 34 35 36 37 38
36
Ans:11

47
-1 0 0 1 2 3 2 1 3 5 6 7 8 9 10 11 12 13 14 15 16 15 16 17 18 19 20 21 22 25 27 11 12 13 14 28 29 30 31 32 33 34 35 36 37 38
10
Ans:wrong input


11
-1 0 0 0 1 1 2 2 3 4 5 6
1
Ans:0 (Wrong input)

11
-2 0 0 1 1 2 2 3 4 5 6
1
Ans:0 (Wrong input)

11
0 0 1 1 2 2 3 4 5 6 3
1
Ans:0 (Wrong input)

11
-1 0 0 -2 1 2 2 3 4 5 6
1
Ans:0 (Wrong input)

11
-1 0 0 1 1 2 2 3 4 5 6 -1
1
Ans:0 (Wrong input)

11
-1 0 0 1 1 2 2 3 4 5 6 0
1
Ans:0 (Wrong input)

11
-1 0 0 1 1 2 2 3 4 5 -1
1
Ans:0

11
-1 0 0 1 1 2 2 3 4 5 -2
1
Ans:0

11
-1 0 0 -11 1 2 2 3 4 5 6
1

11
-1 0 0 1 1 2 2 3 4 5 6
1
Ans:2


11
-1 0 0 1 1 2 2 3 4 5 6
6
Ans:2

11
-1 0 0 1 1 2 2 3 4 5 6 10 11 12
6
Ans:0

11
-1 0 0 1 1 2 2 3 4 6
6
Ans:0
 */
public class AltimetrikCG1 {
	  public static void main(String args[] ) throws Exception {
		  try {

			  Scanner sc = new Scanner(System.in);  
			  int numberOfNode = Integer.parseInt(sc.nextLine().trim());
			  int arrayOfNodes[] = new int[numberOfNode];
			  int sortedNodes[] = new int[numberOfNode];
			  String nodesLineInput = sc.nextLine().trim();
			  String [] arrayOfNodesString = nodesLineInput.split(" ");
			  int numberOfLeafNodes = 0;
			  boolean negativeExists = false;
			  int numberOfZero = 0;
			  for(int i =0;i<numberOfNode;i++) {
				  arrayOfNodes[i] = Integer.parseInt(arrayOfNodesString[i]);
				  if(arrayOfNodes[i] < 0 && i!=0) {
					  negativeExists = true;
				  }
				  else if(i ==0 && arrayOfNodes[i] != -1) {
					  negativeExists = true;
				  }
				  else if(arrayOfNodes[i] >0) {
					  sortedNodes [i] = arrayOfNodes[i];  
				  }
				  else if(arrayOfNodes[i] == 0) {
					  numberOfZero++;
				  }
				  
				  
			  }
			  int deleteNode = Integer.parseInt(sc.nextLine().trim());
			  //Here if number of zeros greater than 2 then it wont pass 
			  //If any negative number exsits other than -1 in 0th index it wont pass
			  //If number of nodes given is greater or lesser than length given it wont pass 
			  if(arrayOfNodes[0] == -1 && !negativeExists && numberOfZero<=2 && arrayOfNodesString.length == arrayOfNodes.length) {
				  
				  Arrays.sort(sortedNodes);
				  //Finding all leave nodes
				  int leafNodes[] =  findCounts(sortedNodes, numberOfNode);
				  if(leafNodes == null) {
					  throw new NullPointerException();
				  }
				  
				  //It is constant value used to indicate that node is deleted
				  int deletedNodeValue = -5;
				  ArrayList<Integer> deleteNodes = new ArrayList<Integer>();
				  if(deleteNode > -1 && deleteNode < arrayOfNodes.length) {
					  //The node of parent become leave when it have only one child
					  /*if(arrayOfNodes[deleteNode] > 0) {
						  leafNodes[arrayOfNodes[deleteNode]-1] = leafNodes[arrayOfNodes[deleteNode]-1]-1;
					  }*/
					  arrayOfNodes[deleteNode] = deletedNodeValue;
					  
					  //Adding index to be deleted
					  deleteNodes.add(deleteNode);
				  }
				
				  
				  
				  for(int i=deleteNode+1;i<arrayOfNodes.length;i++) {
					  //Finding all the nodes under that subtree and deleting
					 if(deleteNodes.contains(arrayOfNodes[i])) {
						deleteNodes.add(i);
						 arrayOfNodes[i] = -5;
					 }
				  }
				  
				  //To check whether still that leave node exists if exists increase the count
				  for(int i =0; i<leafNodes.length-1;i++) {
					  if(leafNodes[i] == 0) {
						  if(arrayOfNodes[i+1] != deletedNodeValue ) {
							  numberOfLeafNodes++;
						  }
					  }
				  }
			  }
			 
			  System.out.println(numberOfLeafNodes);
		  }
		  catch(Exception e) {
			 // e.printStackTrace();
			  System.out.println(0);
		  }
	   }
	  
	  //Array have all negative numbers
	  static int[] findCounts(int arr[], int n) 
	    {
	        // Traverse all array elements
	        int i = 0;
	         
	        while (i < n) 
	        {
	            
	            if (arr[i] <= 0) 
	            {
	                i++;
	                continue;
	            }
	 
	            // Find index corresponding to this element
	            int elementIndex = arr[i] - 1;
	 
	            // If the elementIndex has an element that is not
	            if (arr[elementIndex] > 0) 
	            {
	                arr[i] = arr[elementIndex];
	                // to store initial count of 'arr[i]'
	                arr[elementIndex] = -1;
	            } 
	            else
	            {
	                // If this is NOT first occurrence of arr[i],
	                 arr[elementIndex]--;
	                 
	                arr[i] = 0;
	                i++;
	            }
	        }
	        
	        for(int j =0;j<arr.length;j++) {
	        	arr[j] =  Math.abs(arr[j]);
	        	if(arr[j] >2) {
	        		return null;
	        	}
	        }
	       return arr;
	    }
}



