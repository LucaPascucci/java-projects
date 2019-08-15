package it.unibo.apice.oop.p17concurrency2;

public class A {
    public synchronized void m(){
        System.out.println("Thread "+Thread.currentThread()+" entered.");
        try {
            Thread.sleep(5000);
        } catch (Exception ex){}
        System.out.println("Thread "+Thread.currentThread()+" exited.");
    }
}
