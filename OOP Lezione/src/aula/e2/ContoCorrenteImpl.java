package aula.e2;

public class ContoCorrenteImpl implements ContoCorrente {

	private double saldo = 0;
	private CondizioniInterface condition;
	
	ContoCorrenteImpl(CondizioniInterface specifiche){
		this.condition = specifiche;
	}
	
	@Override
	public double saldoAttuale() {
		return this.saldo;
	}

	@Override
	public boolean prelievo(double d) {
		if (this.saldo < d){ 
			return false;
		}else{
			this.saldo = condition.condizioniPrelievo(this.saldo, d);
			return true;
		}
	}

	@Override
	public void versamento(double d) {
		this.saldo += d;
	}

	@Override
	public void cambioAnno() {
		this.saldo = condition.cambioAnno(this.saldo);
	}

}
