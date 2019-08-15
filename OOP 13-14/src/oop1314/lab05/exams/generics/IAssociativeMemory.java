/**
 * 
 */
package oop1314.lab05.exams.generics;

/**
 * An interface for a very basic associative memory.
 * 
 * @author Danilo Pianini
 *
 * @param <K>
 * @param <V>
 */
public interface IAssociativeMemory<K, V> {
	
	/**
	 * Given a key, retrieves a value.
	 * 
	 * @param key the key
	 * @return the associated value
	 */
	V get(K key);
	
	/**
	 * Inserts a new pair of key and value.
	 * 
	 * @param key the key
	 * @param value the value associated with the key
	 */
	void put(K key, V value);
	
	/**
	 * Given a key, removes the key and the corresponding value.
	 * 
	 * @param key the 
	 * @return the value, if found and removed, null otherwise
	 */
	V remove(K key);

}
