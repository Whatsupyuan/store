package com.captain.store;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDevice {

    private static ConcurrentMap<String, Object> map = new ConcurrentHashMap<String, Object>();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static Object get(String key) {
        Object object = null;
        lock.readLock().lock();
        try {
            object = map.get(key);
            if (null == object) {
                lock.readLock().unlock();
                lock.writeLock().lock();
                try {
                    if (null == object) {
                        // 从数据库中查询数据
                        object = "222";
                        map.put(key, object);
                    }
                } finally {
                    lock.writeLock().unlock();
                }
                lock.readLock().lock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return object;
    }
}
