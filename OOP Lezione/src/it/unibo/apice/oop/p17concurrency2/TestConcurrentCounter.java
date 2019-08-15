package it.unibo.apice.oop.p17concurrency2;

public class TestConcurrentCounter {
    public static void main(String[] args) throws Exception  {
        Counter c = new Counter();
        long ntimes = Long.parseLong(args[0]);
        CounterUserA agentA = new CounterUserA(c,ntimes);
        CounterUserB agentB = new CounterUserB(c,ntimes);
        agentA.start();
        agentB.start();
        agentA.join();
        agentB.join();
        System.out.println("Count value: "+c.getValue());
    }
}
