package com.example.leetcodemedium;

public class InsertGCDivisorsList {

    public static void main(String[] str){
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        System.out.println("Sample test passing insert Greatest Common Divisors: " + insertGreatestCommonDivisors(head) + "\r\n");
       /* head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        System.out.println("Sample test passing insert Greatest Common Divisors: " + insertGreatestCommonDivisors(head) + "\r\n");*/
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head){
        ListNode realHead = head;
        ListNode cur = head;
        ListNode next = cur.next;
        int gcd =0;
        while(next !=null){
            gcd = gcd(cur.val, next.val);
            ListNode gcdNode = new ListNode(gcd);
            cur.next= gcdNode;
            gcdNode.next = next;
            cur = next;
            next = next.next;
        }
        return realHead;
    }

    static int gcd(int a, int b)
    {
        // Find Minimum of a and b
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }

        // Return gcd of a and b
        return result;
    }

}
