package com.example.amazon;

public class Add2ListRepresent {
	
	static Node rotateList(Node head) {
		Node rotateList = null;
		Node next = null;
		Node previous = null;
		while(head !=null)
		{
			next =head.next;
			head.next = previous;
			previous = head;
			head = next;
		}
		printList(previous);
		System.out.println("here");
		return rotateList;
	}
	
	static Node addList(Node first,Node second){
		Node res = null;
		Node result = null;
		Node temp = null;
		int carry = 0;
		int newData = 0;
		int sum = 0;
		while(first!=null && second !=null)
		{
			newData =carry+first.value + second.value;
			sum = newData%10;
			carry = newData/10;
			temp = new Node(sum);
			
			first = first.next;
			second = second.next;
			
			if(res == null)
			{
				res= temp;
				result = res;
				//res = temp.next;
			}
			else{
				res.next = temp;
				res = res.next;
				//res = temp.next;
			}
		}
		if(first!=null)
		{
			while(first!=null)
			{
				newData =carry+first.value;
				sum = newData%10;
				carry = newData/10;
				temp = new Node(sum);
				
				first = first.next;
				
				
				if(res == null)
				{
					res= temp;
					result = res;
					//res = temp.next;
				}
				else{
					res.next = temp;
					res = res.next;
					//res = temp.next;
				}
			}
			
		}
		else if(second !=null)
		{
			while(second!=null)
			{
				newData =carry+second.value;
				sum = newData%10;
				carry = newData/10;
				temp = new Node(sum);
				
				second = second.next;
				
				
				if(res == null)
				{
					res= temp;
					result = res;
					//res = temp.next;
				}
				else{
					res.next = temp;
					res = res.next;
					//res = temp.next;
				}
			}
		}
		
		if(carry>0)
		{
			temp = new Node(carry);
			res.next = temp;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node header = new Node(7);
		header.next = new Node(5);
	//	header.next.next = new Node(9);
	//	header.next.next.next = new Node(4);
	//	header.next.next.next.next = new Node(6);
		
		printList(header);
		
		Node header2 = new Node(8);
		header2.next = new Node(4);
		
		printList(header2);
		
		Node result = addList(header, header2);
		
		printList(result);
		rotateList(result);
		
	}
	
	public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println("");
    }

}

class Node{
	int value;
	Node next;
	
	public Node(int value){
		this.value = value;
		this.next = null;
	}
	
}
