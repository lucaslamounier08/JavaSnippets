package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
class Lesson26ThreadSafeCodeLockingAndSynchronizationTest {

    @Test
    void lesson26ThreadSafeCodeLockingAndSynchronizationTest() {
        // 002. 26.1 Race conditions, deadlock, and livelock
        final int[] data = {0};

        new Thread(() -> {
            while (data[0] < 4) {
                System.out.println("> " + data[0]);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 65; i++) {
                data[0] = i;
                System.out.println(data[0]);
            }
        }).start();
    }

    public static class Live {
        private static final Semaphore semaphore = new Semaphore(10);

        public static int obtainResources(int count) {
            if (semaphore.tryAcquire(count)) return count;
            else return 0;
        }

        public static void returnResources(int count) {
            semaphore.release(count);
        }

        public static void delay(int d) {
            try {
                Thread.sleep(d);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static volatile boolean stop = false;

    @Test
    void continueTesting() throws InterruptedException {
        // 003. 26.2 Transactional integrity

        // 004. 26.3 Visibility
        new Thread(() -> {
            System.out.println("Init of thread");
            while (!stop) {
                System.out.println("Thread working inside while");
            }
            System.out.println("Worker stopped!");
        }).start();
        System.out.println("Worker started.");
        Thread.sleep(1000);
        stop = true;
        System.out.println("Signal set, main exiting");
    }

    private static List<Boolean> stops;

    static {
        stops = new ArrayList<>();
        stops = Collections.synchronizedList(stops);
    }

    @Test
    void continueTesting26_3() throws InterruptedException {
        new Thread(() -> {
            System.out.println("Init of thread");
            while (stops.isEmpty() || !stops.removeFirst()) {
                System.out.println("Thread working inside while");
            }
            System.out.println("Worker stopped!");
        }).start();
        System.out.println("Worker started.");
        Thread.sleep(1000);
        stops.add(true);
        System.out.println("Signal set, main exiting");
    }

    @Test
    void continueTesting26_4() throws InterruptedException {
        // 005. 26.4 Concurrent queues and collections
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        new Thread(() -> {
            while (true) {
                try {
                    arrayBlockingQueue.put(new Random(10).nextDouble() + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(arrayBlockingQueue.take());
                } catch (InterruptedException e) {
                }
            }
        }).start();

        System.out.println(arrayBlockingQueue.take());
    }

    @Test
    void continue26_5() throws InterruptedException {
        // 006. 26.5 Synchronizers, locks, and atomic types - part 1
        Phaser phaser = new Phaser(1);
        System.out.println("registered is: " + phaser.getRegisteredParties());

        new Thread(() -> {
            phaser.register();
            for (int i = 0; i < 3; i++) {
                System.out.println("Arrive and await");
                phaser.arriveAndAwaitAdvance();
            }
            System.out.println("worker waiting for the last time");
            phaser.arriveAndDeregister();
            System.out.println("worker ends");
        }).start();

        while (phaser.getRegisteredParties() < 2) {
            Thread.sleep(1);
        }

        System.out.println("worker launched and registered, register: " + phaser.getRegisteredParties());

        while (phaser.getRegisteredParties() < 1) {
            Thread.sleep(1000);
            System.out.println("main tick");
            phaser.arriveAndAwaitAdvance();
        }

        phaser.arriveAndDeregister();
        System.out.println("all done, finishing");
    }

    private static int normalInt = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Test
    void test26_6() throws InterruptedException {
        // 007. 26.6 Synchronizers, locks, and atomic types - part 2
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1_000_000; j++) {
                    atomicInteger.incrementAndGet();
                    normalInt++;
                }
            });
            threadList.add(thread);
            thread.start();
        }

        for (Thread t : threadList) {
            t.join();
        }

        System.out.println("Total normal int: " + normalInt);
        System.out.println("Total atomic int: " + atomicInteger);
    }
}
