package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class Lesson25CreateAndExecuteThreadsTest {

    @Test
    void lesson25CreateAndExecuteThreadsTest() {
        // 25.1 - Runnable and threads
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread" + Thread.currentThread().getName() + " i " + i);
            }
        };
        //runnable.run();

        Thread t1 = new Thread(runnable, "Thread test");
        t1.start();

        System.out.println("Exiting");

        // 25.2 -

    }

}
