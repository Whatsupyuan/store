package com.captain.store;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DeadReetLock {
    public static Lock lock1 = new ReentrantLock();
    public static Lock lock2 = new ReentrantLock();
}

class DeadLockThread implements Runnable {

    public boolean flag = false;

    public DeadLockThread(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (false) {
            DeadReetLock.lock1.lock();
            System.out.println(Thread.currentThread().getName() + " " + "lock1 已锁住");
            DeadReetLock.lock2.lock();
            System.out.println(Thread.currentThread().getName() + " " + "lock2 已锁住");

        } else {
            DeadReetLock.lock2.lock();
            System.out.println(Thread.currentThread().getName() + " " + "lock2 已锁住");
            DeadReetLock.lock1.lock();
            System.out.println(Thread.currentThread().getName() + " " + "lock1 已锁住");
        }

    }
}


public class DeadLock {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockThread(false));
        Thread t2 = new Thread(new DeadLockThread(true));
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
