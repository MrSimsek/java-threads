package com.denizsimsek;

public class MemoryExample {
    public static class CustomRunnable implements Runnable {
        private int count = 20;

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            ExampleObject exampleObject = new ExampleObject();
            System.out.println(Thread.currentThread().getName() + ": " + exampleObject);

            for (int i = 0; i < 5; i++) {
                synchronized (this) {
                    // a = c + d
                    // c =
                    count--;
                    System.out.println(Thread.currentThread().getName() + "[count]: " + count);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                // System.out.println(Thread.currentThread().getName() + "[i]: " + i);
            }
        }
    }

    public static class CustomRunnable2 implements Runnable {
        private int count = 0;
        ExampleObject exampleObject = null;

        public CustomRunnable2(ExampleObject exampleObject) {
            this.exampleObject = exampleObject;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": " + exampleObject);

            for (int i = 0; i < 5; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + "[count]: " + count);
                System.out.println(Thread.currentThread().getName() + "[i]: " + i);
            }
        }
    }

    public static void main(String[] args) {
        CustomRunnable customRunnable = new CustomRunnable();

        ExampleObject exampleObject = new ExampleObject();
        CustomRunnable2 customRunnable2 = new CustomRunnable2(exampleObject);

        Thread thread1 = new Thread(customRunnable, "Thead 1");
        Thread thread2 = new Thread(customRunnable, "Thead 2");
        Thread thread3 = new Thread(customRunnable, "Thead 3");
        Thread thread4 = new Thread(customRunnable, "Thead 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.println("Final Count: " + customRunnable.getCount());
    }
}
