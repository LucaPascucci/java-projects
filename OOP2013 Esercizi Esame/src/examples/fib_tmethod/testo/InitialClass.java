package examples.fib_tmethod.testo;

import java.util.ArrayList;
import java.util.List;

public abstract class InitialClass implements Generator {

	private int index;
	private int primo;
	private int secondo;

	protected InitialClass(Integer n1, Integer n2) {
		this.index = 0;
		this.primo = n1;
		this.secondo = n2;

	}

	abstract protected int strategy(Integer n1, Integer n2);

	// produce il prossimo intero
	public int getNext() {
		if (this.index == 0) {
			this.index++;
			return primo;
		}
		if (this.index == 1) {
			this.index++;
			return secondo;
		}
		int next = this.strategy(this.primo, this.secondo);
		this.primo = this.secondo;
		this.secondo = next;
		return secondo;
	}

	public void skip(int n) {
		for (; n > 0; n--) {
			this.getNext();
		}

	}

	// produce il prossimo array di interi, riempiendo e ritornando quello in
	// input
	public int[] getNextArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = this.getNext();
		}
		return array;
	}

	// produce una lista con i prossimi 'size' interi
	public java.util.List<Integer> getNextList(int size) {
		List<Integer> list = new ArrayList<>(size);
		for (; size > 0; size--) {
			list.add(this.getNext());
		}
		return list;

	}
}
