package examples.fibio.testo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FibIOonFile implements FibIO {

	private String file;
	private List<Integer> list = new ArrayList<>();

	public FibIOonFile(String string) {
		this.file = string;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadFib() throws IOException {
		FileInputStream input = new FileInputStream(this.file);
		ObjectInputStream ois = new ObjectInputStream(input);
		try {
			this.list = (List<Integer>) ois.readObject();
		} catch (ClassNotFoundException e) {
		}
		ois.close();
	}

	@Override
	public List<Integer> getFib() {
		return this.list;
	}

	@Override
	public void computeNewNumbers(int howMany) {
		for (;howMany>0;howMany--){
			this.computeOne();
		}
	}
	
	private void computeOne (){
		int size = this.list.size();
		if (size<2){
			this.list.add(1);
		}else{
			this.list.add(this.list.get(size-1)+this.list.get(size-2));
		}
	}

	@Override
	public void saveFib() throws IOException {
		FileOutputStream output = new FileOutputStream(this.file);
		ObjectOutputStream oos = new ObjectOutputStream(output);
		try {
			oos.writeObject(this.list);
		} catch (IOException e) {
		}
		oos.close();
	}

}
