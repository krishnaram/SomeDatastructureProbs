package com.example.threads;

import com.example.alco.ThreadEx;

public class ParallelThreads {
    public static  void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    System.out.println("i in ThreadOne:"+i);
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=100;i<200;i++){
                    System.out.println("i in ThreadTwo:"+i);
                }
            }
        });
        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for(int i=200;i<300;i++){
            System.out.println("i in ThreadThree:"+i);
        }
    }

}
