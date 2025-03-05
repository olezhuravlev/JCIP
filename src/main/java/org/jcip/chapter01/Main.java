package org.jcip.chapter01;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.printf("Thread1: %d\n", UnsafeSequence.getNext());
                //System.out.printf("Thread1: %d\n", SafeSequence.getNext());
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.printf("\t\tThread2: %d\n", UnsafeSequence.getNext());
                //System.out.printf("\t\tThread2: %d\n", SafeSequence.getNext());
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        });

        thread1.start();
        thread2.start();
    }
}