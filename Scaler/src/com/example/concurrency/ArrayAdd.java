package com.example.concurrency;

import java.util.concurrent.*;

public class ArrayAdd <T> implements Callable {
    int from;
    int to;
    int[] array;

    public  ArrayAdd(int from, int to, int[] array){
        this.from = from;
        this.to = to;
        this.array = array;
    }
    @Override
    public T call() throws Exception {
        Integer sum = 0;
        for(int i=from;i<to;i++){
            sum = array[i];
        }
        return (T) sum;
    }

    public  static  void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = new int[1000];
        for(int i=0;i<1000;i++){
            arr[i] =i+1;
        }
        Integer sum =0;
        ExecutorService executorService = Executors.newFixedThreadPool( 10);
        for(int i=0;i<1000;i=i+10){
           Integer interval =(Integer) executorService.submit(new ArrayAdd<Integer>(i,i+10,arr)).get();
           sum += interval;
        }
        System.out.println(sum);
    }
}
