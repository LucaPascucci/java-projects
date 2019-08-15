package it.unibo.apice.oop.p17concurrency2;

public class UserA extends Thread {
    private A obj;
    public UserA(A obj){
        this.obj = obj;
    }
    public void run(){
        log("before invoking m");
        obj.m();
        log("after invoking m");
    }
    
    private void log(String msg){
        System.out.println("["+Thread.currentThread()+"] "+msg);
    }
}
