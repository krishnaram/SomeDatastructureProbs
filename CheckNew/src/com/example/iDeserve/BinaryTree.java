package com.example.iDeserve;

import java.util.ArrayList;
import java.util.Iterator;
//Java program to implement iterative preorder traversal
import java.util.Stack;

//A binary tree node
class Node {

 int data;
 Node left, right;

 Node(int item) {
     data = item;
     left = right = null;
 }
}

public class BinaryTree {

 Node root;
  
 void iterativePreorder()
 {
     iterativePreorder(root);
 }
 
 void spiralOrder()
 {
	 spiralOrder(root);
	 boolean ltr = false;
	 ArrayList<Node> rootList = new ArrayList<Node>();
	 rootList.add(root);
	 System.out.println("====================================================");
	 spiralOrderMe(rootList,ltr);
 }

 // An iterative process to print preorder traversal of Binary tree
 void spiralOrder(Node node) {
      
	 int h = height(node);
     int i;

     /* ltr -> left to right. If this variable is set then the
        given label is transversed from left to right */
     boolean ltr = false;
     for (i = 1; i <= h; i++) 
     {
         printGivenLevel(node, i, ltr);

         /*Revert ltr to traverse next level in opposite order*/
         ltr = !ltr;
     }

 }
 
//An iterative process to print preorder traversal of Binary tree
void spiralOrderMe(ArrayList<Node> nodeList,boolean ltr) {
   /* ltr -> left to right. If this variable is set then the
      given label is transversed from left to right */
   ArrayList<Node> forwardNodeList = new ArrayList<Node>();
   boolean changeSide = ltr;
   for (Node indexNode : nodeList) 
   {
	   System.out.print(indexNode.data+" ");
      if(changeSide)
      {
    	  if(indexNode.right !=null)
  	  	  {
    		  forwardNodeList.add(indexNode.right);
  	  	  }
    	  if(indexNode.left !=null)
    	  {
    		  forwardNodeList.add(indexNode.left);
    	  }
    	  
      }
      else{
    	  	if(indexNode.left !=null)
 	  	 	{

        	  forwardNodeList.add(indexNode.left);
 	  	 	}
    	  	if(indexNode.right !=null)
    	  	{
    	  		forwardNodeList.add(indexNode.right);
    	  	}
    	  	
      }
      changeSide = !changeSide;
      
   }
   /*Revert ltr to traverse next level in opposite order*/
   ltr = !ltr;
   if(forwardNodeList.size() >=1)
   {
	   spiralOrderMe(forwardNodeList,ltr);   
   }
   
}

 /* Compute the "height" of a tree -- the number of
 nodes along the longest path from the root node
 down to the farthest leaf node.*/
 int height(Node node) 
 {
     if (node == null) 
         return 0;
     else
     {
           
         /* compute the height of each subtree */
         int lheight = height(node.left);
         int rheight = height(node.right);

         /* use the larger one */
         if (lheight > rheight) 
             return (lheight + 1);
         else
             return (rheight + 1);
     }
 }

 /* Print nodes at a given level */
 void printGivenLevel(Node node, int level, boolean ltr) 
 {
     if (node == null) 
         return;
     if (level == 1) 
         System.out.print(node.data + " ");
     else if (level > 1) 
     {
         if (ltr != false) 
         {
             printGivenLevel(node.left, level - 1, ltr);
             printGivenLevel(node.right, level - 1, ltr);
         } 
         else
         {
             printGivenLevel(node.right, level - 1, ltr);
             printGivenLevel(node.left, level - 1, ltr);
         }
     }
 }

 // An iterative process to print preorder traversal of Binary tree
 void iterativePreorder(Node node) {
      
     // Base Case
     if (node == null) {
         return;
     }

     // Create an empty stack and push root to it
     Stack<Node> nodeStack = new Stack<Node>();
     nodeStack.push(root);

     /* Pop all items one by one. Do following for every popped item
      a) print it
      b) push its right child
      c) push its left child
      Note that right child is pushed first so that left is processed first */
     while (nodeStack.empty() == false) {
          
         // Pop the top item from stack and print it
         Node mynode = nodeStack.peek();
         System.out.print(mynode.data + " ");
         nodeStack.pop();

         // Push right and left children of the popped node to stack
         if (mynode.right != null) {
             nodeStack.push(mynode.right);
         }
         if (mynode.left != null) {
             nodeStack.push(mynode.left);
         }
     }
 }
 /*
  *              0
  *          1       2
  *        4   5   3   6
  *          7   8     9
  *        
  */

 // driver program to test above functions
 
 static int findHigestWidth(BinaryTree tree){
	 ArrayList<Node> leaveList = new ArrayList<Node>();
	 ArrayList<Node> tempLeaveList = new ArrayList<Node>();
	 int highest = 0;
	 leaveList.add(tree.root);
	 Node presentNode;
	 while(leaveList.size()>=1)
	 {
		 tempLeaveList = leaveList;
		 leaveList = new ArrayList<Node>();
		 Iterator<Node> it = tempLeaveList.iterator();
		 while(it.hasNext()){
			 presentNode = it.next();
			 if(presentNode !=null)
			 {
				 if(presentNode.left!=null)
				  leaveList.add(presentNode.left);
				 if(presentNode.right!=null)
				 leaveList.add(presentNode.right);
			 }
			 
		 }
		 if(highest<leaveList.size())
		 {
			 highest = leaveList.size();
		 }
	 }
	 
	 
	return highest;
	 
			 
 }
 public static void main(String args[]) {
     BinaryTree tree = new BinaryTree();
     tree.root = new Node(0);
     
     tree.root.left = new Node(1);
     tree.root.right = new Node(2);
     
    // tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);
     tree.root.right.left = new Node(3);
     tree.root.right.right = new Node(6);
     
     tree.root.right.right.left = new Node(9);
     tree.root.right.right.right = new Node(4);
     tree.root.left.right.left = new Node(7);
     tree.root.left.right.right = new Node(8);
     
     //System.out.println(findHigestWidth(tree));
    tree.spiralOrder();

 }
}

