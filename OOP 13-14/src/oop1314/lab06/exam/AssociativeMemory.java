/**
 * 
 */
package oop1314.lab06.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danilo Pianini
 * 
 * @param <K>
 * @param <V>
 */
public class AssociativeMemory<K, V> implements IAssociativeMemory<K, V> {

	private final List<K> keys = new ArrayList<>();
	private final List<V> values = new ArrayList<>();

	@Override
	public void put(final K key, final V value) {
		keys.add(key);
		values.add(value);
	}

	@Override
	public V get(final K key) {
		final int index = keys.indexOf(key);
		if (index == -1) {
			return null;
		}
		return values.get(index);
	}

	@Override
	public V remove(final K key) {
		final int index = values.indexOf(key);
		if (index == -1) {
			return null;
		}
		keys.remove(index);
		return values.remove(index);
	}

}
