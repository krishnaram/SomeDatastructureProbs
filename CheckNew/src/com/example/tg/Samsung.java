package com.example.tg;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
public class Samsung {
    public static void main(String args[] ) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	List<ArrayList<Integer>> listIndex = new ArrayList<ArrayList<Integer>>();
    	int n = 0,c[],s[];
    	String line,lineEle[] = new String[2];
    	System.out.println("Input number of candidates:");
    	try {
    		n = Integer.parseInt(sc.nextLine().trim());
        	c = new int[n];
        	s = new int[n];
        	//Map<Integer,Integer> linkedMap = new LinkedHashMap<Integer, Integer>();
        	System.out.println("Enter candidate number and his salary expectaion:");
        	for(int i=0;i<n;i++) {
        		line = sc.nextLine();
        		lineEle = line.trim().split(" ");
        		c[i] = Integer.parseInt(lineEle[0]);
        		s[i] = Integer.parseInt(lineEle[1]);
        	}
        	int temp;
        	//The array of candidates in des order
        	for(int i=0;i<c.length-1;i++) {
        		for(int j =i+1;j<c.length;j++) {
        			if(c[j]>c[i]) {
        				temp = c[i];
        				c[i] = c[j];
        				c[j] = temp;
        				
        				temp = s[i];
        				s[i] = s[j];
        				s[j] = temp;
        			}
        			else if(c[j]==c[i]) {
        				System.out.println(4);
            			System.exit(1);
        			}
        		}
        	}
        	ArrayList<Integer> tempList = new ArrayList<Integer>();
        	tempList.add(0);
        	//Making into smaller lists
        	if(c.length>1) {
        		for(int i =0;i<c.length-1;i++) {
            		if(s[i]>s[i+1]) {
            			tempList.add(i+1);
            		}
            		else {
            			listIndex.add(tempList);
            			tempList = new ArrayList<Integer>();
            			tempList.add(i+1);
            		}
            	}
        		listIndex.add(tempList);
        	}
        	else {
        		System.out.println(1);
        	}
        	
        	for(ArrayList<Integer> lis: listIndex) {
        		for(Integer i:lis) {
        			System.out.print(i);
        		}
        		System.out.println(" ");
        	}
        	/*for(int i =0;i<c.length;i++) {
        		if(linkedMap.containsKey(c[i])) {
        			// Same candidate number repeated twice
        			System.out.println(0);
        			System.exit(1);
        		}
        		else
        			linkedMap.put(c[i],s[i]);
        	}
        	
        	for(Integer i: linkedMap.keySet())
        	{
        		System.out.println("Candidate Id:"+i+" Salary expected:"+linkedMap.get(i));
        	}*/
        	
        	
    	}
    	catch (Exception e) {
    		// Any exception comes please print 0
    		System.out.println(0);
		}
    	finally {
			sc.close();
		}
    	
   }
}
/*
 *
Original case
6
1 2
2 4
3 1
4 5
5 3
6 6

case 1
7
4 31
5 32
6 33
7 35
8 28
9 30
10 50

case 2
7
3 58
4 31
5 36
6 33
7 39
8 42
9 30

case 3
7
3 63
4 61
5 34
6 35
7 37
8 31
9 42

case 4
7
2 1500
4 1000
8 9000
9 2000
12 9200
13 9500
15 9800
 */

