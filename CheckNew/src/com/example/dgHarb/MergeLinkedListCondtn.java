package com.example.dgHarb;

import com.example.amazon.LinkedList;
import com.example.amazon.LinkedList.Node;

public class MergeLinkedListCondtn {

	public static void main(String[] args) {
		 LinkedList llist = new LinkedList();
	     llist.push(10);
	     llist.push(8);
	     llist.push(4);
	     llist.push(2);
	     
	     LinkedList llist2 = new LinkedList();
	     llist2.push(1);
	     llist2.push(3);
	     llist2.push(12);
	     
	     printList(llist);
	}
	
	public static void mergeList(LinkedList first,LinkedList second) {
		
	}
	
	public static int getLength(LinkedList l) {
		int i = 0;
		Node node = l.head;
		while(node != null) {
			i++;
		}
		return i;
	}
	
	public static LinkedList.Node getLast(LinkedList l) {
		Node node = l.head;
		while(node != null) {
			if(node.next == null) {
				return node;
			}
			node = node.next;

		}
		return null;
		
	}
	
	public static void printList(LinkedList l) {
		Node node = l.head;
		while(node != null) {
			System.out.println(node.data);
			node = node.next;

		}
	}

}

