package lab.e3;

public class ConcatenatingStream implements Stream<String> {

	private String a;
	private String b;
	
	public ConcatenatingStream (String inital1, String initial2){
		super();
		this.a = inital1;
		this.b = initial2;
	}
	
	@Override
	public String next() {
		String val = this.a;
		this.a += this.b;
		return val;
	}

}
