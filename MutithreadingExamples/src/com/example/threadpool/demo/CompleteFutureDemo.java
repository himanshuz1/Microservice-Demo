package com.example.threadpool.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class CompleteFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Map<String, Integer> result = new HashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Map<String, Integer> finalResult = result;
        Future<Map<String, Integer>> future = executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread name : " + Thread.currentThread().getName());
                finalResult.put(Thread.currentThread().getName(), i);
                //Thread.sleep(2000);
            }
            return finalResult;
        });
        result = future.get();

        System.out.println(result);
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread name : " + Thread.currentThread().getName());
        }

    }
}
