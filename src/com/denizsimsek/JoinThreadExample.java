package com.denizsimsek;

public class JoinThreadExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is starting.");

        Thread customThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println("Counting: " + i);
            }
        }, "Custom Thread");

        customThread.setDaemon(true);
        customThread.start();

        try {
            customThread.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

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
