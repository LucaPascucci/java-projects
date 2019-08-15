package aula.e1;

import java.util.HashMap;
import java.util.Map;

public class PersonArchiveImpl implements PersonArchive {

	Map<Integer, String> archivio = new HashMap<>();
	private Integer limit = null;

	@Override
	public void addPerson(int code, String name)
			throws IllegalArgumentException, UnsupportedOperationException {
		if (hasCode(code) || (name == null)) {
			throw new IllegalArgumentException();
		}
		if ((limit != null) && (this.limit == this.archivio.size())) {
			throw new UnsupportedOperationException();
		}
		this.archivio.put(code, name);
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasCode(int code) {
		return this.archivio.containsKey(code);
	}

	@Override
	public String getNameByCode(int code) {
		return this.archivio.get(code);
	}

	@Override
	public String[] getNames() {
		return this.archivio.values().toArray(new String[this.archivio.size()]);
	}

	@Override
	public void setLimit(int n) throws IllegalArgumentException {
		if (n < this.archivio.size()) {
			throw new IllegalArgumentException();
		}
		this.limit = n;
	}

}
