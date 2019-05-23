package com.example.iDeserve;

public class BinaryTCreat {

	/* A O(n) program for construction of BST from
	   postorder traversal */
	 
	 /* A binary tree node has data, pointer to left child
	   and a pointer to right child */
	class Node 
	{
	    int data;
	    Node left, right;
	 
	    Node(int data) 
	    {
	        this.data = data;
	        left = right = null;
	    }
	}
	
	public static void main(String[] args) 
    {
		BinaryTCreat tree = new BinaryTCreat();
        int post[] = new int[]{1, 7, 5, 50, 40, 10};
        int post2[] = new int[]{1, 7, 5, 50};
        int size = post.length;
        int temp;
        //Bubble sort
        
        for(int i=0;i<post.length;i++)
        {
        	for(int j=i+1;j<post.length;j++)
        	{
        		if(post [i]> post [j])
        		{
        			temp = post[i];
        			post[i] = post[j];
        			post[j] = temp;
        		}
        	}
        }
        
        for(int i=0;i<post2.length;i++)
        {
        	for(int j=i+1;j<post2.length;j++)
        	{
        		if(post2 [i]> post2 [j])
        		{
        			temp = post2[i];
        			post2[i] = post2[j];
        			post2[j] = temp;
        		}
        	}
        }
        
        Node root = tree.constructTree(post, size);
        Node subtree = tree.constructTree(post2, post2.length);
 
        System.out.println("Inorder traversal of the constructed tree:");
        tree.printInorder(root);
        System.out.println("Inorder traversal of the constructed subtree:");
        tree.printInorder(subtree);
        boolean flag = findSubTree(root,subtree);
        int daimeter = daimeter(root);
        System.out.println("Daimeter  is "+ daimeter);
    }

	private static int daimeter(Node root)
	{
		if(root == null)
			return 0;
		int lD = daimeter(root.left)+1;
		int rD = daimeter(root.right)+1;
		return lD>rD ? lD:rD;
	}
	private static boolean findSubTree(Node root, Node subtree) {
		// TODO Auto-generated method stub
		if(root == null || subtree == null)
		{
			
		}
		if(root.data == subtree.data)
		{
			findSubTree(root.left, subtree.left);
			findSubTree(root.right, subtree.right);
		}
		
		return false;
	}

	

	private Node constructTree(int[] post, int size) {
		// TODO Auto-generated method stub
		Node root;
		if(size == 1)
		{
			root = new Node(post[size-1]);
			return root;
		}
		if(size == 2)
		{
			if(post[0] <=post[1])
			{
				root = new Node(post[0]);
				root.right = new Node(post[1]);
				return root;
			}
			else{
				root = new Node(post[1]);
				root.right = new Node(post[0]);
				return root;
			}
		}
		int mid = size/2;
		root = new Node(post[mid]);
		if(post.length >= 3)
		{
			int[] postLeft = new int[mid];
			int[] postRight = new int[post.length-(mid+1)];
			for(int i=0;i<mid;i++)
			{
				postLeft[i] = post[i];
			}
			root.left = constructTree(postLeft,postLeft.length);
			
			for(int i=mid+1;i<post.length;i++)
			{
				postRight[i-(mid+1)] = post[i];
			}
				root.right = constructTree(postRight,postRight.length);
		}
		
		return root;
	}
	
	 // A utility function to print inorder traversal of a Binary Tree
    void printInorder(Node node) 
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
