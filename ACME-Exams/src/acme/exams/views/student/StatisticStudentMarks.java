package acme.exams.views.student;

import java.util.Iterator;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import acme.exams.exceptions.MarkNotFoundException;
import acme.exams.model.IExam;
import acme.exams.model.Student;

/**
 * View showing statistics about a student marks 
 * @author Andrea Santi
 *
 */
public class StatisticStudentMarks extends JPanel{

  private static final long serialVersionUID=1;
  public StatisticStudentMarks(Map<String, IExam> exams, Student student){
    //Viene chiamato il costruttore della classe padre
    super();
    //Crezione del dataset specifico per questo grafico
    XYSeriesCollection xyseriescollection = new XYSeriesCollection();
    //Creazione dell'oggettto xyseries che conterrà i dati da aggiungere all'oggetto dataset XYSeriesCollection
    XYSeries xyseries = new XYSeries("Numero esami sostenuti");

    Iterator<IExam> it = exams.values().iterator();
    IExam currentExam;
    //Set del primo valore per far partire il grafico da 0,0(0 esami sostenuti e quindi anche 0 come valore della media).
    xyseries.add(0,0);

    int i=1;
    double tot=0;
    //Ciclo di scansione degli appelli presenti alal ricerca di quelli in cui lo studente ha ottenuto un voto almeno sufficiente
    while(it.hasNext()){
      currentExam = it.next();
      try {
        //Nel caso in cui lo studente sia iscritto a questo appello e il voto presente sia almeno 18 quest'ultimo viene aggiunto al dataset
        int mark = currentExam.getMark(student.getEnrollmentId());
        if (mark >= IExam.MIN_MARK){
          tot += mark;
          xyseries.add(i, tot/i);
          i++;
        }
      } catch (MarkNotFoundException e) {
      }
    }
    //Add del xyseries al xyseriescollection 
    xyseriescollection.addSeries(xyseries);

    //Creazione del grafico con il relativo dataset
    JFreeChart jfreechart = ChartFactory.createXYLineChart("Media in funzione degli esami sostenuti", "X", "Y", xyseriescollection, PlotOrientation.VERTICAL, true, true, false);
    //Set del rendering dell'oggetto xyplot 
    XYPlot xyplot = (XYPlot)jfreechart.getPlot();
    XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
    xylineandshaperenderer.setShapesVisible(true);
    xylineandshaperenderer.setDefaultShapesFilled(true);
    xylineandshaperenderer.setDrawOutlines(true);
    //Set del range degli intervalli dell'asse x
    NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
    numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    //Aggiunta del charpanel al pannello
    this.add(new ChartPanel(jfreechart));
  }
}