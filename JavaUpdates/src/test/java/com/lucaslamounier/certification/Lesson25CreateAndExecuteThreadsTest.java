package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

        // 003. 25.2 ExecutorService and Future

        // 004. 25.3 ExecutorService lifecycle - part 1
    }

    class MyTask implements Callable<String> {
        private static int nextId = 0;
        private int jobId = nextId++;

        @Override
        public String call() throws Exception {
            System.out.println("Job " + jobId + " starting");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                System.out.println("Job " + jobId + " received shutdown request");
                return "Job " + jobId + " early shutdown result";
            }

            if (jobId % 2 == 0) throw new Exception();

            return "Job " + jobId + " normal result";
        }
    }

    @Test
    void testMyTask() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> handles = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            handles.add(executorService.submit(new MyTask()));
        }

        // 005. 25.4 ExecutorService lifecycle - part 2


    }

}
