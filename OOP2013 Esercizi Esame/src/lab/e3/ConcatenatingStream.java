package lab.e3;

public class ConcatenatingStream implements Stream<String> {

	private String riga;
	private final String repeat;

	public ConcatenatingStream(String inizio, String valore) {
		super();
		this.riga = inizio;
		this.repeat = valore;
	}

	@Override
	public String next() {
		String val = this.riga;
		this.riga += this.repeat;
		return val;
	}

}
