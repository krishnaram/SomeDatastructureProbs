package com.example.amazon;

import  com.example.amazon.Node;
public class BrentsCycle {

	public static Node detectCycle(Node head) {
		if(head==null) {
			return null;
		}
		
		Node firstPointer = head;
		Node secondPointer = head.next;
		
		int power = 1;
		int length =1;
		
		while(secondPointer.next != null && secondPointer != firstPointer)
		{
			if(length == power)
			{
				power=power*2;
				length = 0;
				firstPointer = secondPointer;
				System.out.println(power+" :Power");
				System.out.println(length+" :Length");
			}
			secondPointer =  secondPointer.next;
			length++;
		}
		
		if(secondPointer==null) {
			return null;
		}
		
		firstPointer= secondPointer = head;
		while (length > 0) {
	        secondPointer = secondPointer.next;
	        --length;
	    }
		
		while (secondPointer != firstPointer) {
			 secondPointer = secondPointer.next;
		     firstPointer = firstPointer.next;
		}
		
		return firstPointer;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = head.next.next;
		
		Node loopNode = detectCycle(head);
		
		System.out.println(loopNode.value);
	}

}
