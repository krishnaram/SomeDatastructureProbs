package com.example.leetcodemedium;

import java.lang.reflect.Array;

public class SplitLinkedList {

    public static void main(String[] str){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println("Sample test passing splitList to parts: " + splitListToParts(head,3) + "\r\n");
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        System.out.println("Sample test passing splitList to parts: " + splitListToParts(head,3) + "\r\n");
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            count ++;
            curr = curr.next;
        }
        int size;
        int rem =0;
        if(count%k ==0){
            size= count/k;
        }
        else{
            size= count/k;
            rem = count%k;
        }
        ListNode[] splitList = new ListNode[size];
        if(k>size){
            splitList = new ListNode[k];
        }
        else{
            splitList = new ListNode[size];
        }

        curr = head;
        ListNode arrayStart;
        boolean interFlag =false;
        ListNode interNode ;
        int index = 0;
        while(curr != null){
            count = 0;
            interNode = curr;
            while((count+1)< size && interNode != null){
                interNode = interNode.next;
                count++;
            }
            if(rem>0){
                interNode = interNode.next;
                rem--;
            }
            splitList[index] = curr;
            if(interNode != null){
                curr = interNode.next;
                interNode.next = null;
            }
            else{
                curr = null;
            }
            ListNode test = splitList[index];
            while(test != null){
                System.out.print(test.val+"->");
                test = test.next;
            }
            System.out.println("");

            index++;
        }
        return splitList;
    }
}
