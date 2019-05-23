package com.example.mutlithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * https://howtodoinjava.com/java/multi-threading/java-thread-pool-executor-example/
 * @author rpanni
 *
 */
public class FixedThreadPool
{
    public static void main(String[] args)
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executor.setKeepAliveTime(2l, TimeUnit.MINUTES);
      //  executor.set
         
        for (int i = 1; i <= 100; i++)
        {
            Task task = new Task("Task " + i,i);
            System.out.println("Created : " + task.getName());
 
            executor.submit(task);
            System.out.println(executor.getMaximumPoolSize()+" :Max pool size");
            System.out.println(executor.getActiveCount()+" :Active count size");
            System.out.println(executor.getCorePoolSize()+" :Core pool size");
            System.out.println(executor.getCompletedTaskCount()+" :Completed task count");
        }
        executor.shutdown();
        executor.submit(new Task("after shutdown", 101));
    }
}
