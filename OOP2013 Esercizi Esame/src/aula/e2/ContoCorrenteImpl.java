package aula.e2;

public class ContoCorrenteImpl implements ContoCorrente {

	private double saldo = 0;
	private CondizioniInterface cond;

	public ContoCorrenteImpl(CondizioniInterface arg) {
		this.cond = arg;
	}

	@Override
	public double saldoAttuale() {
		return this.saldo;
	}

	@Override
	public boolean prelievo(double d) {
		if (this.saldo < d) {
			return false;
		}
		this.saldo = this.cond.condizioniPrelievo(this.saldo, d);
		return true;
	}

	@Override
	public void versamento(double d) {
		this.saldo += d;

	}

	@Override
	public void cambioAnno() {
		this.saldo = this.cond.cambioAnno(this.saldo);
	}

}
