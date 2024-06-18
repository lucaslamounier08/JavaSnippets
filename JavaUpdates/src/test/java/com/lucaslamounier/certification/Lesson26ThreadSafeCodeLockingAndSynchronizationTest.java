package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

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

    @Test
    void continueTesting() {
        // 003. 26.2 Transactional integrity

    }

}
