package acme.exams.views.professor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import acme.exams.model.IExam;

/**
 * Class used to shows statistics related to exam types
 * @author Andrea Santi
 *
 */
public class ExamTypesGraph extends JPanel{
	private static final long serialVersionUID=1;

	public ExamTypesGraph(List<IExam> exams){
		//Viene chiamato il costruttore della classe padre
		super();
		//Creazione del Dataset per il grafico a torta.
		DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
		//Creazione dell'hasmap che conterrà i dati da passare al DefaultPieDataset. 
		Map<String, Integer> examsInfo = new HashMap<>();
		//Recupero della lista degli appelli presenti
		//Creazione dell'iteratore per la scansione della lista degli appelli
		Iterator<IExam> it = exams.iterator();
		IExam currentExam;
		//Creazione dell'array di stringhe che conterrà le varie tipologie di appello
		String typeDescr[] = new String[exams.size()];
		int i=0;
		//Scansione della lista di appelli
		while(it.hasNext()){
			currentExam = it.next();
			if(examsInfo.containsKey(currentExam.getExamType().toString())){
	      /* Se è gia stato individuato un tipo di appello uguale al tipo dell'appello presente viene incrementato
	         il valore presente nell'hashmap relativa a quella tipologia di appello.*/ 
			  int currNExams = examsInfo.get(currentExam.getExamType().toString());
				examsInfo.put(currentExam.getExamType().toString(), currNExams + 1);
			} else {
			  /* Se il tipo di appello non è presente viene aggiunto nell'hashmap
	        e viene salvato il tipo di appello */
				examsInfo.put(currentExam.getExamType().toString(), 1);
				typeDescr[i] = currentExam.getExamType().toString();
				i++;
			}
		}
		
		for (Entry<String, Integer> entry: examsInfo.entrySet()){
		  defaultpiedataset.setValue(entry.getKey(), entry.getValue());
		}
		//Creazione del grafico con i dati contenuti nel dataset defaultpiedataset
		JFreeChart jfreechart = ChartFactory.createPieChart3D("Numero di appelli per tipologia", defaultpiedataset, true, false, false);
		//Creazione dell'oggetto PiePlot3D dal jfreechart
		PiePlot3D pieplot3d = (PiePlot3D)jfreechart.getPlot();
		//Set di alcuni parametri tra i quali l'angolo con cui iniziare a visualizzare il grafico
		pieplot3d.setStartAngle(270D);
		//Set del verso di rotazione
		pieplot3d.setDirection(Rotation.ANTICLOCKWISE);
		pieplot3d.setForegroundAlpha(0.6F);
		pieplot3d.setInteriorGap(0.33000000000000002D);
		//Creazione dell'oggetto rotator che si occupa di far ruotare il grafico
		Rotator rotator = new Rotator((PiePlot3D)jfreechart.getPlot());
		//Viene invocato il metodo start che indica al timer di effettuare lo start 
		rotator.start();
		//Aggiunta del ChartPanel al pannello e visualizzazione di quest'ultimo
		this.add(new ChartPanel(jfreechart));
		this.setVisible(true);
	}
}