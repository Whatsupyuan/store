package com.captain.store;

import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import sun.font.TrueTypeFont;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestConcurrentMap implements Runnable {

    public static ConcurrentMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
    public static HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
    public static Lock lock = new ReentrantLock();

    public static ArrayList<String> arrayList = new ArrayList<String>();
    public static Vector<String> vector = new Vector<String>();

    public static void add() {
        for (int i = 1; i <= 100000; i++) {
            map.put(i, i + "st");
        }
    }

    public static void add(Map<Integer, String> map, int size) {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= size; i++) {
            map.put(i, i + "st");
        }
        System.out.println(map.getClass().getName() + " " + "用时为:" + (System.currentTimeMillis() - start));
    }

    public static void add(List<String> list, int size) {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= size; i++) {
            list.add(i + "st");
        }
        System.out.println(map.getClass().getName() + " " + "用时为:" + (System.currentTimeMillis() - start));
    }

    /**
     * synchronized 使用方式
     *
     * @throws Exception
     */
    public static void expend() throws Exception {
        synchronized (map) {
            int size = map.size();
            String v = map.get(size);
            System.out.println("获取value值为 :" + v + " , 开始消耗");
            String exV = map.remove(size);
            if (v.equals(exV)) {
                System.out.println("消耗完成 , " + v + " , 线程 :" + Thread.currentThread().getName() + " , 剩余 : " + map
                        .size());
            } else {
                throw new Exception("消耗失败" + v);
            }
        }
    }

    /**
     * tryLock() 使用方法
     * @throws Exception
     */
    public static void expendTryLock() throws Exception {
        if (lock.tryLock()) {
            try {
                int size = map.size();
                String v = map.get(size);
                System.out.println("获取value值为 :" + v + " , 开始消耗");
                String exV = map.remove(size);
                if (v.equals(exV)) {
                    System.out.println("消耗完成 , " + v + " , 线程 :" + Thread.currentThread().getName() + " , 剩余 : " + map
                            .size());
                } else {
                    throw new Exception("消耗失败" + v);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * lock() 使用方式
     *
     * @throws Exception
     */
    public static void expendLock() throws Exception {
        lock.lock();
        try {
            int size = map.size();
            String v = map.get(size);
            System.out.println("获取value值为 :" + v + " , 开始消耗");
            String exV = map.remove(size);
            if (StringUtils.isBlank(v) || StringUtils.isBlank(exV)) return;
            if ( v.equals(exV)) {
                System.out.println("消耗完成 , " + v + " , 线程 :" + Thread.currentThread().getName() + " , 剩余 : " + map
                        .size());
            } else {
                throw new Exception("消耗失败" + v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    @Override
    public void run() {
        while (!map.isEmpty()) {
            try {
                expendLock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    @Test
//    public void test() {
//
//    }

    /*@Test
    public void addData() {
        int size = 1000000;
        TestConcurrentMap.add(map, size);
        TestConcurrentMap.add(hashMap, size);
    }*/

    @Test
    public void addDateTest() {
        int size = 10000000;
        TestConcurrentMap.add(arrayList , size);
        TestConcurrentMap.add(vector , size);
    }

    public static void main(String[] args) {
        add();
        TestConcurrentMap testRun = new TestConcurrentMap();
        Thread t1 = new Thread(testRun, "消耗1");
        Thread t3 = new Thread(testRun, "消耗3");
        Thread t2 = new Thread(testRun, "消耗2");
        Thread t4 = new Thread(testRun, "消耗4");
        Thread t5 = new Thread(testRun, "消耗5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
