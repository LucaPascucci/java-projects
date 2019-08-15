package aula.e1;

import java.util.HashMap;
import java.util.Map;

public class PersonArchiveImpl implements PersonArchive {

	private Map<Integer,String> map;
	private int limit = -1;
	
	public PersonArchiveImpl(){
		super();//???
		this.map = new HashMap<>();
	}
	
	@Override
	public void addPerson(int code, String name) throws IllegalArgumentException, UnsupportedOperationException {
		if (this.hasCode(code) || name == null){
			throw new IllegalArgumentException();
		}
		if (this.map.size() == limit && limit !=-1){
			throw new UnsupportedOperationException();
		}
		this.map.put(code, name);

	}

	@Override
	public boolean hasCode(int code) {
		return this.map.containsKey(code);
	}

	@Override
	public String getNameByCode(int code) {
		return this.map.get(code);
	}

	@Override
	public String[] getNames() {
		String[] str = new String[this.map.size()];
		return this.map.values().toArray(str);
	}

	@Override
	public void setLimit(int n) throws IllegalArgumentException {
		if (n<this.map.size()){
			throw new IllegalArgumentException();
		}
		this.limit = n;

	}

}
