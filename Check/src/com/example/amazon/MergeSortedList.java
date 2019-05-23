package com.example.amazon;

public class MergeSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node listA = new Node(10);
		
		listA.next = new Node(4);
		listA.next.next = new Node(5);
		listA.next.next.next = new Node(3);
		listA.next.next.next.next = new Node(6);
		listA.next.next.next.next.next = listA.next.next;
		
		Node listB = new Node(2);
		listB.next = new Node(3);
		listB.next.next = new Node(20);
		
		Add2ListRepresent.printList(listA);
	//	Node result = mergeLists(listA);
	//	Node result = modfiyList(listA);
		Node result = detectAndRemoveLoop(listA);
		
		
		Add2ListRepresent.printList(result);
	}
	
	public static Node detectAndRemoveLoop(Node list)
	{
		
		return list;
	}
	public static Node modfiyList(Node list){
		Node originaList = list;
		Node forward = list;
		//Node last = null;
		Node middle = list;
		//Node tempMiddle = null;
		Node tempSecondHalf = null;
		
		
		//Add2ListRepresent.printList(list);
		Node firstHalf = list;
		Node secondHalf = null;
		
		while(forward !=null)
		{
			//last = forward;
			if(forward.next!=null)
			{
				forward = forward.next.next;
				middle = middle.next;
			}
			else{
				forward = null;
				middle = middle.next;
			}
			
			
		}
			//tempMiddle= middle;
			
			Node prev = null;
	        Node current = middle;
	        Node next = null;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        secondHalf = prev;
	       // Add2ListRepresent.printList(secondHalf);
	        tempSecondHalf= prev;
	        while(firstHalf!=null)
	        {
	        	if(secondHalf !=null)
	        	{
	        		firstHalf.value = firstHalf.value-secondHalf.value;
		        	firstHalf = firstHalf.next;
		        	secondHalf = secondHalf.next;
	        	}
	        	else{
	        		break;
	        	}
	        		
	        }
	        
	      //  Add2ListRepresent.printList(firstHalf);
	        
	        prev =null;
	        current = tempSecondHalf;
	        Add2ListRepresent.printList(tempSecondHalf);
	        next = null;
	        while(current !=null){
	        	next = current.next;
	        	current.next = prev;
	        	prev = current;
	        	 current = next;
	        }
	      //  Add2ListRepresent.printList(prev);
	        
	        
	        
	        
		
		
		
		
		
		return originaList;
	}
	public static Node mergeLists(Node listA,Node listB)
	{
		Node result = null;
		Node constantResult = null;
		
		while(listA !=null && listB!=null)
		{
			if(listA.value<listB.value)
			{	
				result = new Node(listA.value);
				listA = listA.next;
				
			}
			else{
				result = new Node(listB.value);
				listB = listB.next;
			}
			if(constantResult == null)
			{
				constantResult = result;
				result.next = result;
			}

			result  = result.next;
		}
		if(listA!=null)
			mergeWhole(listA, result,constantResult);
		if(listB!=null)
			mergeWhole(listB, result,constantResult);
		
		return constantResult;
	}
	
	public static void mergeWhole(Node list,Node result,Node constantResult)
	{
		while(list!=null)
		{
			result = new Node(list.value);
			
			list = list.next;
			if(constantResult == null)
			{
				constantResult = result;
			}
			result  = result.next;
		}
	}

}
