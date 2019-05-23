package com.example.tg;

import java.util.ArrayList;

/*
 * Thinking Hat..!!!
Rohan was asked to be solve the following problem: 'given a permutation of numbers 1,..,n, calculate the number of inversions in it, i.e., the number of pairs of numbers i, j from 1..n, such that ialgorithm: 
'for each number in the permutation, if it is located to the right of its correct position in sorted sequence, add to the output value the distance between this two positions'. 

Formally, Rohan's answer is given as: Sum ( max {0, i-pi[i]} ), where pi[i] i s the i-the element of the permutation . So, for permutation 4,1,2,3, the algorithm would give the answer 0+1+1+1 = 3, and for the permutation 3,4,5,1,2, the answer 0+0+0+3+3 =6.

Obviously, this algorithm is wrong (it gives wrong results e.g. for permutation 3,2,1), but... sometimes it gives correct results. 

Rohan would like to calculate what are the chances that this algorithm gives the correct result. Specifically, he wants to know how many different permutations of fixed length, which start with a given prefix (several starting numbers), lead to a correct answer to this problem.

Input Specification:

(1) Length of the permutation ( 1<= length<= 30)

(2) A prefix of the permutation


Output Specification:
 In how m any ways we can augment the prefix to a complete permutation so that the Rohan's
algorithm gives correct results.
Note: Output should
be -1 of no solution exits.

Input = 5 , {1,4}
Output = 3

Input = 5 , {6,4,2,1}
Output = -1


Instructions: 
1) Do not write main function. 
2) You can print and debug your code at any step of the code.
3) You need to return the required output from the given function. 
4) Do not change the function and parameter names given in editor code.
5) Return type must be the same as mentioned in the problem statement. 
6) When you submit your code, test cases of different complexity level are executed in the background and marks are given based on number of test cases passed. 
7) If you do not plan to complete the code in one sitting, then please save your work on a local machine. The code is saved only when it has been submitted using Submit button. 
 */
public class PrefixPermutation {

	public static void main(String[] args) {
		System.out.println(correctResult(5,new int[]{2,1,4}));

	}
	
	  public static int correctResult(int input1,int[] input2)
	  {
		  int ways = 0;
		  int temp = 0;
		  ArrayList<Integer> dupsCheck = new ArrayList<Integer>();
		  for(int i = 0;i<input2.length;i++)
		  {
			  if(input2[i]>input1 || dupsCheck.contains(input2[i]))
			  {
				  return -1;
			  }
			  dupsCheck.add(input2[i]);
			  temp = input2[i];
			  while(input1> temp)
			  {
				  temp++;  
			  }
			  ways++;
			  System.out.println(ways);
		  }
	     return ways;
	  }

}
