package com.captain.store;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public CountDownLatch countDownLatch = new CountDownLatch(10000);
    public List<Object> list = null;

    public TestCountDownLatch() {
    }

    public TestCountDownLatch(List<Object> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(10);
        int i = 1;
        while(cdl.getCount() > 0){
            cdl.countDown();
            System.out.println("countDown" + " : " + i++);
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }
}
