package lab.e1;

public class TimeImpl implements Time {

	private final int momentoGiornata;
	private final static int MIN_IN_HOUR = 60;
	private final static int MAX_GIORNATA = 24 * MIN_IN_HOUR;

	public TimeImpl(int ora, int minuti) throws IncorrectTimeException {
		if ((ora > 23) || (minuti > 59) || (ora < 0) || (minuti < 0)) {
			throw new IncorrectTimeException();
		}
		this.momentoGiornata = ora * MIN_IN_HOUR + minuti;
	}

	@Override
	public int getHour() {
		return (this.momentoGiornata / MIN_IN_HOUR);
	}

	@Override
	public int getMinute() {
		return (this.momentoGiornata % MIN_IN_HOUR);
	}

	@Override
	public Time shiftMinutes(int nMinute) throws IncorrectTimeException {
		if ((this.momentoGiornata + nMinute > MAX_GIORNATA)
				|| (this.momentoGiornata + nMinute < 0)) {
			throw new IncorrectTimeException();
		}
		final int newHour = (this.momentoGiornata + nMinute) / 60;
		final int newMinute = (this.momentoGiornata + nMinute) - newHour * 60;
		return new TimeImpl(newHour, newMinute);
	}

	@Override
	public int compareTo(Time o) {
		return (this.momentoGiornata - o.getMinute() - o.getHour()
				* MIN_IN_HOUR);
	}

}
