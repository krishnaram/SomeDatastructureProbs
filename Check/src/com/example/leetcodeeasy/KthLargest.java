package com.example.leetcodeeasy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class  KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        minHeap=new PriorityQueue<>();

        for(int num:nums)
        {
            add(num);
        }
    }

    public int add(int val) {
        if(minHeap.size()<k)
        {
            minHeap.offer(val);
        }
        else if(val>minHeap.peek())
        {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();

    }

    public static void main(String[] args){
        KthLargest kthLargest = new KthLargest(3,new int[]{4,5,8,2});
        kthLargest.add(3);kthLargest.add(5);kthLargest.add(10);kthLargest.add(9);kthLargest.add(4);


    }
}
