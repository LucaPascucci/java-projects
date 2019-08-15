package it.unibo.apice.oop.p13reflection.annotations;

public class Person {
	
	private String name;
	private int id;
	
	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@ToString( 
			showMethodName = true,
			associationSymbol = ":",
			separator = ","
	) public String getName() {
		return name;
	}

	@ToString( 
			showMethodName = false,
			customName = "id"
	) public int getId() {
		return id;
	}
	
	@ToString
	void m(){
		
	}
}
