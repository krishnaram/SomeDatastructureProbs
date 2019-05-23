package com.example.iDeserve;

import java.util.ArrayList;
import java.util.Iterator;



public class BinarySerachTree {

	Node root;
	
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
	
	// adding new node 
    public void insert(int data)
    {
    	if(this.root == null)
    	{
    		this.root = new Node(data);
    	    return;  
    	}
        this.root = this.insertRec(this.root, data);
    }
     
    /* A utility function to insert a new node with 
    given data in BST */
    Node insertRec(Node node, int data)
    {   
        /* If the tree is empty, return a new node */
    	if(node == null)
    	{
    		node = new Node(data);
    		return node;
    	}
        /* Otherwise, recur down the tree */
        if (data <= node.data) {
            node.left = this.insertRec(node.left, data);
        } else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }
	
    
    public void inorderTraversal(Node node){
    	if(node== null)
    		return;
    	inorderTraversal(node.left);
    	System.out.print(node.data+" ");
    	inorderTraversal(node.right);
    	
    }
	public BinarySerachTree(){
		this.root = null;
	}
	
	 // This class initialises the value of sum to 0
    public class Sum {
        int sum = 0;
    }
 
    // Recursive function to add all greater values in
    // every node
    void modifyBSTUtil(Node node, Sum S)
    {
        // Base Case
        if (node == null)
            return;
             
        // Recur for right subtree    
        this.modifyBSTUtil(node.right, S); 
         
        // Now *sum has sum of nodes in right subtree, add
        // root->data to sum and update root->data
        S.sum = S.sum + node.data;
        node.data = S.sum;
         System.out.println(S.sum);
        // Recur for left subtree
        this.modifyBSTUtil(node.left, S); 
    }
 
    // A wrapper over modifyBSTUtil()
    void modifyBST(Node node)
    {
        Sum S = new Sum();
        this.modifyBSTUtil(node, S);
    }
    
    static int findHigestWidth(BinarySerachTree tree){
   	 ArrayList<Node> leaveList = new ArrayList<Node>();
   	 ArrayList<Node> tempLeaveList = new ArrayList<Node>();
   	 int highest = 0;
   	 leaveList.add(tree.root);
   	 Node presentNode;
   	 while(leaveList.size()>1)
   	 {
   		 tempLeaveList = leaveList;
   		 leaveList = new ArrayList<Node>();
   		 Iterator<Node> it = tempLeaveList.iterator();
   		 while(it.hasNext()){
   			 presentNode = it.next();
   			 if(presentNode !=null)
   			 {
   				 leaveList.add(presentNode.left);
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySerachTree tree = new BinarySerachTree();
        
        /* Let us create following BST
            50
         /     \
        30      70
       /  \    /  \
     20   40  60   80 */
      
      tree.insert(50);
      tree.insert(30);
      tree.insert(20);
      tree.insert(40);
      tree.insert(70);
      tree.insert(60);
      tree.insert(80);
      
      tree.inorderTraversal(tree.root);
      System.out.println();
      tree.modifyBST(tree.root);
      System.out.println();
      
      // print inoder tarversal of the modified BST
      tree.inorderTraversal(tree.root);
      System.out.println(findHigestWidth(tree));
      
  }

}
