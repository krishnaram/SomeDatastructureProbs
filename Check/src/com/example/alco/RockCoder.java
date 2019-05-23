package com.example.alco;

import java.util.ArrayList;


//A binary tree node
class Tree {

int x;
Tree l, r;

Tree(int item) {
   x = item;
   l = r = null;
}
}


	public class RockCoder {
		
		 // driver program to test above functions
		 public static void main(String args[]) {
			 Tree tree = new Tree(4);
		     tree.l = new Tree(5);
		     tree.r = new Tree(6);
		     
		     tree.r.l = new Tree(3);
		     tree.r.r = new Tree(6);
		     
		     tree.l.l = new Tree(7);
		     tree.l.l.l = new Tree(8);
		     tree.l.l.r = new Tree(9);
		     tree.l.l.l.l = new Tree(5);
		     System.out.println(solution(tree));
		 }
		
	    public static int solution(Tree T) {
	        // write your code in Java SE 8
	        ArrayList<Integer> distinctList = new ArrayList<Integer>();
	        distinctList.add(T.x);
	        distinctList = findDistinct(T,distinctList);
	        return distinctList.size();
	    }
	    
	     public static ArrayList<Integer> findDistinct(Tree T,ArrayList<Integer> distinctList)
	     {
	         ArrayList<Integer> lList = new ArrayList<Integer>();
	          ArrayList<Integer> rList = new ArrayList<Integer>();
	          lList = cloneList(distinctList,lList);
	          rList = cloneList(distinctList,rList);
	      if(T.l != null)
	      {
	          if(!lList.contains(T.l.x))
	          {
	              lList.add(T.l.x);
	             //System.out.println(distinctList.size()+" left");
	              
	              lList = findDistinct(T.l,lList);
	          }
	          
	      }
	       if(T.r!=null)
	      {
	          if(!rList.contains(T.r.x))
	          {
	               rList.add(T.r.x);
	             // System.out.println(distinctList.size()+" right");
	              
	              rList = findDistinct(T.r,rList);
	          }
	      }
	      return lList.size()>rList.size()? lList: rList;
	     }
	     
	     public static ArrayList<Integer> cloneList(ArrayList<Integer> parent,ArrayList<Integer> child)
	     {
	         for(Integer i:parent)
	         {
	          child.add(i.intValue());   
	          System.out.print(i.intValue());
	         }
	         System.out.println();
	         return child;
	     }
}


