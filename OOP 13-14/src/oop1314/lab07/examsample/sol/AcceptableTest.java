package oop1314.lab07.examsample.sol;

import static org.junit.Assert.*;
import java.util.*;

import java.util.Arrays;

public class AcceptableTest {

	/*
	 * Testo del problema: Le interfacce Acceptable and Acceptor sono il suale
	 * di Iterable e Iterator: gestiscono il caso di oggetti che ricevono
	 * (invece che producono) sequenze finite di elementi.
	 * 
	 * Realizzare la classe OneListAcceptable<T> con un costruttore che accetta
	 * una java.util.List<T> e implementa Acceptable<T>, in modo che accetti
	 * esattamente la sequenza di elementi contenuta nella lista.
	 * 
	 * Si utilizzino i 4 test qui sotto (da scommentare) per capire quale
	 * funzionamento dovrà avere.
	 */

	public static void test1() throws Exception {
		// test di una accettazione corretta
		try {
			List<Integer> list = Arrays.asList(10, 20, 30, 40);
			Acceptable<Integer> acc = new OneListAcceptable<>(list);
			Acceptor<Integer> acceptor = acc.acceptor();
			acceptor.accept(10);
			acceptor.accept(20);
			acceptor.accept(30);
			acceptor.accept(40);
			acceptor.end();
		} catch (Exception e) {
			throw new Exception("Test 1 failed");
		}
	}

	public static void test2() throws Exception {
		// eccezione per via di un elemento accetatto in più
		List<Integer> list = Arrays.asList(10, 20, 30, 40);
		Acceptable<Integer> acc = new OneListAcceptable<>(list);
		Acceptor<Integer> acceptor = acc.acceptor();
		acceptor.accept(10);
		acceptor.accept(20);
		acceptor.accept(30);
		acceptor.accept(40);
		try {
			acceptor.accept(50);
		} catch (Acceptor.ElementNotAcceptedException e) {
			return;
		}
		throw new Exception("Test 2 failed");
	}

	public static void test3() throws Exception {
		// eccezione per via di un elemento errato
		List<Integer> list = Arrays.asList(10, 20, 30, 40);
		Acceptable<Integer> acc = new OneListAcceptable<>(list);
		Acceptor<Integer> acceptor = acc.acceptor();
		acceptor.accept(10);
		acceptor.accept(20);
		try {
			acceptor.accept(31);
		} catch (Acceptor.ElementNotAcceptedException e) {
			return;
		}
		throw new Exception("Test 3 failed");
	}

	public static void test4() throws Exception {
		// eccezione per via di una fine anticipata
		List<Integer> list = Arrays.asList(10, 20, 30, 40);
		Acceptable<Integer> acc = new OneListAcceptable<>(list);
		Acceptor<Integer> acceptor = acc.acceptor();
		acceptor.accept(10);
		acceptor.accept(20);
		try {
			acceptor.end();
		} catch (Acceptor.EndNotAcceptedException e) {
			return;
		}
		throw new Exception("Test 4 failed");
	}

	public static void main(String[] args) throws Exception {
		test1();
		test2();
		test3();
		test4();
	}

}
