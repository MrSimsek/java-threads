package com.denizsimsek;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is starting.");

        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();

            while (true) {
                sleep(1000);
                System.out.println(threadName + " is running.");
            }
        };

        Thread thread1 = new Thread(runnable, "Thread 2");
        thread1.setDaemon(true);
        thread1.start();

        sleep(3000);

        System.out.println(Thread.currentThread().getName() + " had ended.");
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
