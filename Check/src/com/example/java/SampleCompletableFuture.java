package com.example.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SampleCompletableFuture {

    public static void main(String[] s) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFutureOne
                = CompletableFuture.supplyAsync(() -> "Hello");


        Future<String> completableFuture = calculateAsync();

        System.out.println("Whether it is executing in main" );
        int i=0;
        while(!completableFuture.isDone()){
            System.out.println(i++);
        }

        //sample
        Collections.sort(new ArrayList<Integer>(), (o1,o2)-> {
                    if(o1>o2){
                        return 1;
                    }
                    return 0;
                }
        );

        //ThenApply to use future object value in some othe future object
        //ThenCombine ThenAccept
        String result = completableFuture.get();
        System.out.println("Hello".equals(result)+" match" );
       // Arrays.parallelSort();
        



    }

    public static Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(5000);
            System.out.println("Whether it is executing inside thread" );
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }
}
