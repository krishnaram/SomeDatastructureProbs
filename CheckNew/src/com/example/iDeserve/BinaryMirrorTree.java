package com.example.iDeserve;

import com.example.iDeserve.BinaryTCreat.Node;

public class BinaryMirrorTree {

	static class Node 
	{
	    int data;
	    Node left, right;
	 
	    Node(int data) 
	    {
	        this.data = data;
	        left = right = null;
	    }
	}
	
	 // A utility function to print inorder traversal of a Binary Tree
	static void  printInorder(Node node) 
    {
        if (node == null)
            return;
        
        System.out.print(node.data + " ");
        printInorder(node.left);
        printInorder(node.right);
    }
	
	static void  printMirrorInorder(Node node) 
    {
        if (node == null)
            return;
        
        System.out.print(node.data + " ");
        printInorder(node.right);
        printInorder(node.left);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node rootA = new Node(10);
		rootA.left = new Node(9);
		rootA.right = new Node(8);
		rootA.left.left = new Node(7);
		rootA.left.right = new Node(6);
		rootA.right.left = new Node(5);
		rootA.right.right = new Node(4);
		rootA.left.right.left = new Node(4);
		
		Node rootB = new Node(10);
		rootB.left = new Node(8);
		rootB.right = new Node(9);
		rootB.left.left = new Node(4);
		rootB.left.right = new Node(5);
		rootB.right.left = new Node(6);
		rootB.right.right = new Node(7);
		System.out.println("Mirror is: "+findMirror( rootA,  rootB));
		printInorder(rootA);
		System.out.println("\n");
		printMirrorInorder(rootB);
		System.out.println("\n");
		if(pathWithSum(rootA,29) == 0)
		{
			System.out.println("Path exists");
		}
		else{
			System.out.println("There is no Path with this sum");
		}

	}
	
	public static boolean findMirror(Node rootA, Node rootB)
	{
		if(rootA == null && rootB == null )
		{
			return true;
		}
		else if(rootA == null || rootB == null )
		{
			return false;
		}
		else if(rootA.data != rootB.data)
		{
			//System.out.println(rootA.data +" "+rootB.data );
			return false;
		}
		//System.out.println(rootA.data +" "+rootB.data );
		return findMirror(rootA.left, rootB.right) && findMirror(rootA.right,rootB.left);
	}
	
	static int pathWithSum(Node node,int sum) 
    {
        
		System.out.println(node.data);
        int newSum = sum - node.data;
        if(newSum == 0)
        {
        	return 0;
        }
        if (node.left != null)
        { 
        	if(pathWithSum(node.left,newSum) == 0)
        	{
        		return 0;
        	}
        	
        }
        if(node.right != null)
        {
        	if(pathWithSum(node.right,newSum) == 0)
        	{
        		return 0;
        	}
        	
        }
        else{
        	return -1;
        }
		return -1;
      
    }

}
