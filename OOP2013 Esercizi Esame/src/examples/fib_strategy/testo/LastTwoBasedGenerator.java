package examples.fib_strategy.testo;

import java.util.ArrayList;
import java.util.List;

public class LastTwoBasedGenerator implements Generator {

	private int index;
	private int primo;
	private int secondo;
	private FibStrategy<Integer> proprierty;

	public LastTwoBasedGenerator(int primo, int secondo,
			FibStrategy<Integer> strategy) {
		this.index = 0;
		this.primo = primo;
		this.secondo = secondo;
		this.proprierty = strategy;
	}

	@Override
	public int getNext() {
		if (this.index == 0) {
			this.index++;
			return this.primo;
		}
		if (this.index == 1) {
			this.index++;
			return this.secondo;
		}
		this.index++;
		int prox = this.proprierty.strat(this.primo, this.secondo);
		this.primo = secondo;
		this.secondo = prox;
		return this.secondo;
	}

	@Override
	public void skip(int n) {
		for (; n > 0; n--) {
			this.getNext();
		}

	}

	@Override
	public int[] getNextArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = this.getNext();
		}
		return array;
	}

	@Override
	public List<Integer> getNextList(int size) {
		List<Integer> list = new ArrayList<>(size);
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			list.add(this.getNext());
		}
		return list;
	}

}
