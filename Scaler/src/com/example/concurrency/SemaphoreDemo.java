package com.example.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String args[])
            throws InterruptedException
    {
        // creating a Semaphore object
        // with number of permits 3 and fairness true
        Semaphore sem = new Semaphore(3, true);

        // isFair() method
        System.out.println("is Fairness enabled : "
                + sem.isFair());

        // Main thread try to acquire 2 permits
        // tryAcquire(int permits) method
        sem.tryAcquire(2);

        // availablePermits() method
        System.out.println("Available permits : "
                + sem.availablePermits());

        // drainPermits() method
        System.out.println(
                "number of permits drain by Main thread : "
                        + sem.drainPermits());

        // permit released by Main thread
        sem.release(1);

        // creating two threads with name A and B
        SemaphoreThread mt1 = new SemaphoreThread(sem, "A");
        SemaphoreThread mt2 = new SemaphoreThread(sem, "B");

        // starting threads A
        mt1.start();

        // starting threads B
        mt2.start();

        // toString method
        System.out.println(sem.toString());

        // waiting for threads A and B
        mt1.join();
        mt2.join();

        FooBar fooBar = new FooBar(5);
        Thread foo = new Thread();
        Thread bar= new Thread();

        fooBar.foo(bar);
        fooBar.bar(foo);
    }

    static class FooBar {
        private int n;
        private Semaphore first;
        private Semaphore second;

        public FooBar(int n) {
            this.n = n;
            first= new Semaphore(0);
            second=new Semaphore(0);
            first.release();
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                first.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                second.release();
            }

        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                second.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                first.release();
            }
        }
    }


}

