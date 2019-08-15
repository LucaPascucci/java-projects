package examples.magazzino.testo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StockImpl implements Stock {

	Map<Product, Integer> stock = new HashMap<>();
	private int balance = 0;

	@Override
	public void buy(Product p, int quantity) throws IllegalArgumentException,
			NullPointerException {
		if (quantity < 1) {
			throw new IllegalArgumentException();
		}
		if (p == null) {
			throw new NullPointerException();
		}
		int old = (this.stock.get(p) == null) ? 0 : this.stock.get(p);
		this.stock.put(p, old + quantity);
		this.balance -= p.price(quantity);
	}

	@Override
	public void sell(Product p, int quantity, int amount)
			throws IllegalArgumentException, IllegalStateException,
			NullPointerException {
		if (quantity < 0 || amount < 0) {
			throw new IllegalArgumentException();
		}
		if (p == null) {
			throw new NullPointerException();
		}
		int remain = this.stock.get(p);
		if (remain < quantity) {
			throw new IllegalStateException();
		}
		this.stock.put(p, remain - quantity);
		this.balance += amount;
	}

	@Override
	public int getBalance() {
		return this.balance;
	}

	@Override
	public int getProductAmount(Class<? extends Product> c) {
		int amount = 0;
		Set<Product> setProd = this.stock.keySet();
		for (Product elem : setProd) {
			if (c.isAssignableFrom(elem.getClass())) {
				amount += this.stock.get(elem);
			}
		}
		return amount;
	}

	@Override
	public Set<String> getAvailableProducts(Class<? extends Product> c) {
		Set<String> prodA = new HashSet<>();
		for (Product elem : this.stock.keySet()) {
			if (c.isAssignableFrom(elem.getClass()) && this.stock.get(elem) > 0) {
				prodA.add(elem.getDescription());
			}
		}
		return prodA;
	}

}
