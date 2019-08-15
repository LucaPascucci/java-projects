package esami2013.appello03b.e3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class OccurrencesImpl implements Occurrences {

	@Override
	public long readAndStoreOccurrences(String inputTextFile,
			String outputDataFile, String occurrence) throws IOException {
		int count = 0;
		BufferedReader br = new BufferedReader(new FileReader(inputTextFile));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputDataFile));
		String s = null;
		for (int riga = 1; (s = br.readLine()) != null; riga++) {
			int index = s.indexOf(occurrence);
			if (index != -1) {
				count++;
				dos.writeInt(riga);
				dos.writeInt(index);
			}
		}
		dos.writeInt(-1);
		br.close();
		dos.close();
		return count;
	}

	@Override
	public void printStoredOccurrences(String dataFile,String occurrence) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream (dataFile));
		int value = dis.readInt();
		while (value !=-1){
			System.out.println("Row: "+value + " Position (dove inizia la parola -> " + occurrence +" ): "+ dis.readInt());
			value = dis.readInt();
		}
		dis.close();
	}

}
