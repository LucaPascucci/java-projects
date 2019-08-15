package oop1314.lab07.examsample.sol;

import java.util.*;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> list;

	public OneListAcceptable(List<T> list) {
		this.list = list;
	}

	@Override
	public Acceptor<T> acceptor() {
		final Iterator<T> iterator = list.iterator();
		return new Acceptor<T>() {
			@Override
			public void accept(T newElement)
					throws Acceptor.ElementNotAcceptedException {
				try {
					if (newElement.equals(iterator.next())) {
						return;
					}
				} catch (Exception e) {
				}
				throw new Acceptor.ElementNotAcceptedException(newElement);
			}

			@Override
			public void end() throws Acceptor.EndNotAcceptedException {
				try {
					if (!iterator.hasNext()) {
						return;
					}
				} catch (Exception e) {
				}
				//throw new Acceptor.EndNotAcceptedException();
			}
		};
	}
}
