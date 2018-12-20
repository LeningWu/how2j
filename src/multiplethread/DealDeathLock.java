package multiplethread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DealDeathLock {
    /*
    lock解决死锁
     */
    public static void main(String[] args) throws InterruptedException {



        Lock lock_ahri = new ReentrantLock();
        Lock lock_annie = new ReentrantLock();

        Thread t1 = new Thread() {
            public void run() {
                boolean ahriLocked = false;
                boolean annieLock = false;

                try {
                    ahriLocked = lock_ahri.tryLock(10, TimeUnit.SECONDS);

                    if (ahriLocked) {
                        System.out.println("t1 已占有九尾妖狐");
                        Thread.sleep(1000);
                        System.out.println("t1 试图在10秒内占有安妮");
                        try {
                            annieLock = lock_annie.tryLock(10, TimeUnit.SECONDS);
                            if (annieLock) {
                                System.out.println("t1 成功占有安妮");
                            } else {
                                System.out.println("t1 老是占用不了安妮，放弃");
                            }
                        } finally {
                            if (annieLock) {
                                System.out.println("t1 释放annie");
                                lock_annie.unlock();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (ahriLocked) {
                        System.out.println("t1释放九尾狐");
                        lock_ahri.unlock();
                    }
                }
            }
        };
        t1.start();

        Thread.sleep(100);

        Thread t2 = new Thread() {
            boolean annieLocked = false;
            boolean ahriLocked = false;

            public void run() {

                try {
                    annieLocked = lock_annie.tryLock(10, TimeUnit.SECONDS);
                    if (annieLocked) {
                        System.out.println("t2已占有安妮");
                        Thread.sleep(1000);
                        System.out.println("t2 试图在10秒内占有九尾妖狐");
                        try {
                            ahriLocked = lock_ahri.tryLock(10, TimeUnit.SECONDS);
                            if (ahriLocked) {
                                System.out.println("t2 成功占有九尾妖狐");
                            } else {
                                System.out.println("t2 老是占用不了九尾妖狐，放弃");
                            }
                        } finally {
                            if (ahriLocked) {
                                System.out.println("t2 释放九尾狐");
                                lock_ahri.unlock();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("t2 释放安妮");
                    lock_annie.unlock();
                }
            }
        };
        t2.start();
    }
}
