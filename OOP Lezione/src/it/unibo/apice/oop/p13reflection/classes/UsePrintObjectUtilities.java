package it.unibo.apice.oop.p13reflection.classes;

import static it.unibo.apice.oop.p13reflection.classes.PrintObjectsUtilities.*;

public class UsePrintObjectUtilities {
	
	public static void main(String[] args) {
		Person p = new Person("Mario",101);
		Teacher t = new Teacher("Gino",102,"LMC","OOP");
		System.out.println(objectToString(p));
		System.out.println(objectToString(p,"name"));
		System.out.println(objectToString(p,"name","id"));
		System.out.println(objectToString(t,"name","id","courses"));
	}

}
