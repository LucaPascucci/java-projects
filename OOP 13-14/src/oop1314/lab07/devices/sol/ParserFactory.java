package oop1314.lab07.devices.sol;

import java.util.*;

public class ParserFactory {
	
	public static <T> T parseAndBuild(String toParse, Class<T> theClass, String prefix){
		try{
			List<String> list = Arrays.asList(toParse.split(" "));
			if (!list.get(0).equals(prefix)){
				return null;
			}
			Class<?>[] argTypes = new Class[list.size()-1];
			/* Set int as the type for all the args */
			Arrays.fill(argTypes, Integer.TYPE);
			List<Integer> args = new ArrayList<>();
			Iterator<String> iterator = list.iterator();
			iterator.next();
			while (iterator.hasNext()){
				args.add(Integer.parseInt(iterator.next()));
			}
			/* Invoking the constructor */
			return theClass.getConstructor(argTypes).newInstance(args.toArray());
		} catch (Exception e){
			System.err.println(e);
			return null;
		}
	} 
	
	/* Qui sotto parte di prova */
	
	public static class E {
		int x,y;
		public E(int x,int y){
			this.x=x; this.y=y;
		}
		public String toString() {
			return "E [x=" + x + ", y=" + y + "]";
		}	
	}

	public static void main(String[] args) {
		System.out.println(parseAndBuild("obj", Object.class, "obj"));
		System.out.println(parseAndBuild("int 10", Integer.class, "int"));
		System.out.println(parseAndBuild("e 10 20", E.class, "e"));
	}
}