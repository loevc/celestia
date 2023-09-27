package com.loevc.celestia.admin.test;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/9/8 16:48
 * @Description TODO
 * @Version 1.0
 */

public class Example {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 5;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            Thread workerThread = new Thread(new Worker(latch));
            workerThread.start();
        }

        // 等待所有线程完成
        latch.await();

        System.out.println("All worker threads have finished.");
    }

    static class Worker implements Runnable {
        private final CountDownLatch latch;

        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                // 模拟一些工作
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " has finished.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 计数器减一
                latch.countDown();
            }
        }
    }
}

