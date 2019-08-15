package it.unibo.apice.oop.p13reflection.classes;

import java.io.*;
import java.lang.reflect.*;

public class DynamicExecution {

	public final static String Q_CLASS = "Insert fully-qualified class name: ";
	public final static String Q_METH = "Insert name of method to call: ";
	public final static String L_OK = "Everything was ok! The result is..";
	public final static String E_RET = "Wrong return type";

	public final static String exceptionString(Exception e) {
		return "Exception: "+e;
	}
	
	public static void main(String[] s) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println(Q_CLASS);
				String className = reader.readLine();
				System.out.println(Q_METH);
				String methName = reader.readLine();

				Class<?> cl = Class.forName(className);
				Constructor<?> cns = cl.getConstructor();
				Method met = cl.getDeclaredMethod(methName);
				if (!met.getReturnType().isAssignableFrom(String.class)) {
					throw new NoSuchMethodException(E_RET);
				}
				Object o = cns.newInstance();
				String result = (String) met.invoke(o);
				System.out.println(L_OK);
				System.out.println(result);
			} catch (Exception e) {
				System.out.println(exceptionString(e));
			}
		}
	}

}
