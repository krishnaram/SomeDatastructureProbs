package com.example.iDeserve;


public class AddPloynomials {
	static class Node 
	{
	    int data;
	    int pow;
	    Node right;
	 
	    Node(int data,int pow) 
	    {
	        this.data = data;
	        this.pow = pow; 
	        right = null;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node dLL = new Node(5, 2);
		dLL.right = new Node(4, 1);
		dLL.right.right = new Node(2, 0);
		
		Node dLL2 = new Node(5, 1);
		dLL2.right = new Node(5, 0);
		
	}

}
