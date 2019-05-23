package com.example.dgHarb;


//Asked in morgan stanely
public class CheckLeafNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		
		root.left.right = new Node(6);
		
		root.left.right.left = new Node(7);
		
		int count = checkLeafNode(root, 0);
		
		if(count == -1) {
			System.out.println("All nodes are not in same level");
		}
		else {
			System.out.println("All nodes are in same level");
		}
	}
	
	public static int checkLeafNode(Node root,int count) {
		count++;
		int leftCount=count,rightCount=count;
		//Just return count when it is leave
		if(root.left == null && root.right == null) {
			return count;
		}
		
		if(root.left!=null) {
			leftCount = checkLeafNode(root.left, leftCount);
		}
		if(root.right!=null) {
			rightCount = checkLeafNode(root.right, rightCount);
		}
		
		System.out.println("Node data "+root.data);
		System.out.println("left "+leftCount+" right"+rightCount);
		if(root.left == null || root.right==null)
		{
			count = leftCount>rightCount?leftCount:rightCount;
		}
		else if(root.left !=null &&root.right!=null)
		{
			if(leftCount!=rightCount) {
				return -1;
			}
			else {
				return leftCount;
			}
		}
		return count;
	}

}

class Node{
	int data;
	Node left = null;
	Node right = null;
	
	public Node(int data) {
		this.data = data;
	}
	
}
