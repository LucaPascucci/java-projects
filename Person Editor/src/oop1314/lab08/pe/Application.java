package oop1314.lab08.pe;

public class Application{
	
	public static void main(String[] args){
		Controller c = new Controller();
		Model m = new Model();
		View v = new View();
		c.setModel(m);
		c.setView(v);
		c.setFileName("archive.bin");
	}
}
