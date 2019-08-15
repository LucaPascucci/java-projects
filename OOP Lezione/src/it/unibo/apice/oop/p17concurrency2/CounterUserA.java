package it.unibo.apice.oop.p17concurrency2;

public class CounterUserA extends Thread {
    private long ntimes;
    private Counter counter;
    public CounterUserA(Counter c, long n){
        ntimes=n;
        counter = c;
    }
    public void run(){
        log("starting - counter value is "+counter.getValue());
        for (long i = 0; i < ntimes; i++){
            counter.inc();
        }
        log("completed - counter value is "+counter.getValue());
    }
    private void log(String msg){
        System.out.println("[COUNTER USER A] "+msg);
    }
    
}
