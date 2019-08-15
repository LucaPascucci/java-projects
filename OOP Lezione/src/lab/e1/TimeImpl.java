package lab.e1;

public class TimeImpl implements Time {

	private final int momentoGiornata;
	private static final int maxMomentoGiornata = 23*60 + 59;
	private static final int minMomentoGiornata = 0;
	
	
	TimeImpl (int ora, int minuti) throws IncorrectTimeException{
		if (ora<0 || ora>23 || minuti<0 || minuti>59){
			throw new IncorrectTimeException();
		}
		this.momentoGiornata = ora*60 + minuti;
	}
	@Override
	public int getHour() {
		return this.momentoGiornata/60;
	}

	@Override
	public int getMinute() {
		return this.momentoGiornata%60;
	}

	@Override
	public Time shiftMinutes(int nMinute) throws IncorrectTimeException {
		if (this.momentoGiornata + nMinute >maxMomentoGiornata || this.momentoGiornata + nMinute<minMomentoGiornata){
			throw new IncorrectTimeException();
		}
		final int newHour = (this.momentoGiornata + nMinute)/60;
		final int newMinute = (this.momentoGiornata + nMinute) - newHour*60;
		return new TimeImpl(newHour,newMinute);
	}

	@Override
	public int compareTo(Time o) {
		if (this.momentoGiornata - (o.getHour()*60+o.getMinute())<0){
			return -1;
		}else if (this.momentoGiornata - (o.getHour()*60+o.getMinute())>0){
			return 1;
		}else{
			return 0;
		}
	}

}
