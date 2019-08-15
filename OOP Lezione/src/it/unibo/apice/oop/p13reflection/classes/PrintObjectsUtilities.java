package it.unibo.apice.oop.p13reflection.classes;

import java.lang.reflect.Method;
import java.util.Arrays;

public class PrintObjectsUtilities {

	public static String objectToString(Object o, String... setters) {
		try {
			String out = o.getClass().getSimpleName()+": ";
			for (String setter : setters) {
				// Sistemo la maiuscola iniziale
				setter = setter.substring(0,1).toUpperCase() + setter.substring(1);
				// Trovo il getter e lo invoco
				Method m = o.getClass().getMethod("get" + setter);
				Object res = m.invoke(o);
				// Aggiungo la stringa
				out += " " + setter + " -> ";
				out += res.getClass().isArray() ? 
							Arrays.deepToString((Object[])res) : res.toString();
				out += " |";
			}
			return out.substring(0,out.length()-2);
		} catch (Exception e) {
			return null;
		}
	}
}
