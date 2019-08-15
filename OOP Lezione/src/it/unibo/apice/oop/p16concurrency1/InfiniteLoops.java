package it.unibo.apice.oop.p16concurrency1;

class MyThread extends Thread {
	public void run(){
		while (true){}
	}
}

public class InfiniteLoops {
	public static void main(String[] args){
		for (int i = 0; i < Integer.parseInt(args[0]); i++){
			System.out.println("Spawning #"+i+"...");
			new MyThread().start();
		}
	}
}
