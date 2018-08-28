package com.captain.store.ticket;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {

    public static int totalTicketCount;
    private Lock lock = new ReentrantLock();

    public SaleTicket(int totalTicketCount) {
        this.totalTicketCount = totalTicketCount;
    }

    @Threa
    public void sale() {
        if(lock.tryLock()) {
            try {
                if (totalTicketCount <= 0) return;
                System.out.println("----------------- " + Thread.currentThread().getName() + " 开始卖票 -----------------");
                System.out.println(Thread.currentThread().getName() + "---" + " 出票成功 ");
                --totalTicketCount;
                System.out.println(Thread.currentThread().getName() + "---" + " 购票成功 ");
                --totalTicketCount;
                System.out.println("----------------- " + Thread.currentThread().getName() + " 购票完成 -----------------");
                System.out.println("----------------- " + "票数剩余:" + totalTicketCount);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        SaleTicket st = new SaleTicket(1000);
//        for(int i=1 ; i<4 ; i++) {
//            ThreadRun tr = new ThreadRun(st);
//            Thread t = new Thread(tr);
//            t.setName("窗口" + i);
//            t.start();
//        }

        ThreadRun tr1 = new ThreadRun(st);
        ThreadRun tr2 = new ThreadRun(st);
        ThreadRun tr3 = new ThreadRun(st);
        ThreadRun tr4 = new ThreadRun(st);

        Thread t1 = new Thread(tr1);
        Thread t2 = new Thread(tr2);
        Thread t3 = new Thread(tr3);
        Thread t4 = new Thread(tr4);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t4.setName("窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }

}

class ThreadRun implements Runnable{
    private SaleTicket saleTicket  ;
    public ThreadRun(SaleTicket saleTicket) {
        this.saleTicket = saleTicket;
    }
    @Override
    public void run() {
        while (SaleTicket.totalTicketCount > 0) {
            saleTicket.sale();
        }
    }
}
