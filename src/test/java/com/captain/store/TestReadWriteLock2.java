package com.captain.store;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class TestReadWriteLock2 {

    private final int LIST_SIZE_LIMIT = 10000;

    public Thread read(ListProcess2 listProcess2) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                while (listProcess2.getListSize() < LIST_SIZE_LIMIT) {
                    listProcess2.read();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }) ;
    }


    public Thread write(ListProcess2 listProcess2) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                while (listProcess2.getListSize() < LIST_SIZE_LIMIT) {
                    listProcess2.write(new Random().nextInt(1000));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }) ;
    }


    public static void main(String[] args) {
        ListProcess2 listProcess2 = new ListProcess2();
        TestReadWriteLock twl = new TestReadWriteLock();
        for (int i = 0 ; i < 100 ;i ++) {
            twl.write(listProcess2).start();
            twl.read(listProcess2).start();
        }
    }

}


class ListProcess2 {
    private Vector<Integer> vector = new Vector<Integer>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        lock.readLock().lock();
        try {
            if (vector.isEmpty()) return;
            //vector.remove(0);
            System.out.println("读 : 列表中数量为 : " + vector.size() + " " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }


    public void write(Integer writeParam) {
        /*try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        lock.writeLock().lock();
        try {
            vector.add(writeParam);
            System.out.println("写 : 写入参数成功" + vector.size() + " " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getListSize() {
        return vector.size();
    }
}
