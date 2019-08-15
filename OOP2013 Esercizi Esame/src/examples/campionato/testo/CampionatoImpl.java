package examples.campionato.testo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampionatoImpl implements Campionato {

	private static final String[] risultati = new String[] { "1", "X", "2" };
	Map<String, Pair<String, Integer>> classifica = new HashMap<>();
	private boolean start = false;

	public CampionatoImpl() {
		super();
	}

	@Override
	public void addSquadra(String shortName, String longName) throws IllegalArgumentException, UnsupportedOperationException {
		if (this.start == true) {
			throw new UnsupportedOperationException();
		}
		if (shortName.length() != 3
				|| this.classifica.put(shortName, new Pair<>(longName, 0)) != null) {
			throw new IllegalArgumentException();
		}

	}

	@Override
	public void iniziaCampionato() {
		this.start = true;
	}

	@Override
	public void addRisultato(String squadra1, String squadra2, String risultato) throws IllegalArgumentException, UnsupportedOperationException {
		if (this.start == false) {
			throw new UnsupportedOperationException();
		}
		if (!this.classifica.containsKey(squadra1)
				|| !this.classifica.containsKey(squadra2)) {
			throw new IllegalArgumentException();
		}
		Pair<String, Integer> sq1 = this.classifica.get(squadra1);
		Pair<String, Integer> sq2 = this.classifica.get(squadra2);
		if (risultato.equals(risultati[0])) {
			sq1.setSecond(sq1.getSecond() + 3);
		} else if (risultato.equals(risultati[1])) {
			sq1.setSecond(sq1.getSecond() + 1);
			sq2.setSecond(sq1.getSecond() + 1);
		} else if (risultato.equals(risultati[2])) {
			sq2.setSecond(sq1.getSecond() + 3);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public List<Pair<String, Integer>> getClassifica() {
		List<Pair<String, Integer>> list = new ArrayList<>(this.classifica.values());
		Collections.sort(list, new Comparator<Pair<String, Integer>>() {

			@Override
			public int compare(Pair<String, Integer> o1,
					Pair<String, Integer> o2) {
				return o1.getSecond() - o2.getSecond();
			}

		});
		return list;
	}

}
