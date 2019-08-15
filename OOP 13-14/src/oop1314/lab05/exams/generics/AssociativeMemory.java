/**
 * 
 */
package oop1314.lab05.exams.generics;

import java.util.List;


/**
 * @author Danilo Pianini
 * 
 * @param <K>
 * @param <V>
 */
public class AssociativeMemory<K, V> implements IAssociativeMemory<K, V> {
	
	private List<K> lista1;
	private List<V> lista2;
	/*
	 * TODO 1. Create two Lists. One will must contain elements of type "K", the
	 * other elements of type "V". Use generics properly.
	 */

	@Override
	public void put(final K key, final V value) {
		lista1.add(key);
		lista2.add(value);
		/*
		 * TODO 2. Add the key and value to the respective lists, in the same
		 * position.
		 */
	}

	@Override
	public V get(final K key) {
		int index = lista1.indexOf(key);
		if (index == -1){
			return null;
		}
		/*
		 * TODO 3. Find the index of key. If key is not in the list, return
		 * null. Otherwise, return the element in the list containing the "V"s
		 * which is at the same index of key.
		 */
		return lista2.get(index);
	}

	@Override
	public V remove(final K key) {
		int index = lista1.indexOf(key);
		if (index == -1){
			return null;
		}
		/*
		 * TODO 4. Find the index of key. If key is not in the list, return
		 * null. Otherwise, remove and return the element in the list containing
		 * the "V"s which is at the same index of key.
		 */
		return lista2.remove(index);
	}

}
