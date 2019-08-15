package it.unibo.apice.oop.p16concurrency1;

public class TestCounter {

	public static void main(String[] args) {
		Counter c = new Counter(0);
		new CounterGUI(c).setVisible(true);
		c.reset();
	}
}
