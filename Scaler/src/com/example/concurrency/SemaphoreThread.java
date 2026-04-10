package com.example.concurrency;


import java.util.concurrent.Semaphore;

class SemaphoreThread extends Thread {
    Semaphore sem;
    String threadName;
    public SemaphoreThread(Semaphore sem, String threadName)
    {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }

    @Override public void run()
    {

        // First, get a permit.
        System.out.println(threadName
                + " is waiting for a permit.");

        try {
            // acquire method
            sem.acquire();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadName + " gets a permit");

        // Now, critical section
        // other waiting threads will wait, until this
        // thread release the lock
        for (int i = 0; i < 2; i++) {
            // hasQueuedThreads() methods
            boolean b = sem.hasQueuedThreads();
            if (b)
                // getQueuedLength() methods
                System.out.println("Length of Queue : "
                        + sem.getQueueLength());

            // Now, allowing a context switch -- if
            // possible.
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Release the permit.
        System.out.println(threadName
                + " releases the permit.");

        // release() method
        sem.release();
    }
}