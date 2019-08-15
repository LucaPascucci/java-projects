package acme.exams.views.professor;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import acme.exams.model.IExam;

/**
 * View showing statistics about registered students 
 * @author Andrea Santi
 *
 */
public class RegisteredStudentsForExamGraph extends JPanel {

  private static final double BAR_WIDTH = 0.050000000000000003D;
  private static final long serialVersionUID=1;

  public RegisteredStudentsForExamGraph(List<IExam> exams){
    //Viene chiamato il costruttore della classe padre
    super();
    //Viene settato il nullLayout per il pannello
    this.setLayout(null);

    //Creazione del specifico dataset per il grafico.
    DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
    //Recupero dei dati necessari al grafico.
    Iterator<IExam> it = exams.iterator();

    IExam currentExam;
    while (it.hasNext()) {
      currentExam = it.next();
      //Aggiunta nel dataset dei dati relativi all'appello corrente
      defaultcategorydataset.addValue(currentExam.getMarks().size(), currentExam.getDescription(), "Appelli");
    }

    //Creazione del grafico con i dati presenti nel DataSet e con gli altri parametri queli titolo ecc.
    JFreeChart jfreechart = ChartFactory.createBarChart3D("Numero di studenti per appello", "", "Studenti", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
    //Crezione del categoryPlot nel nostro caso è presente una sola categoria.
    CategoryPlot categoryplot = jfreechart.getCategoryPlot();
    //Creazione dell'oggeto che rappresenta l'asse x del grafico e set della label dell'asse.
    CategoryAxis categoryaxis = categoryplot.getDomainAxis();
    categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.39269908169872414D));
    //Set del rendering dell'item dell'istogramma.
    CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
    categoryitemrenderer.setItemLabelsVisible(true);
    BarRenderer barrenderer = (BarRenderer)categoryitemrenderer;
    barrenderer.setMaxBarWidth(BAR_WIDTH);
    //Settaggio delle dimensioni del JPanel
    this.setSize(new Dimension(600,500));
    //Creazione del ChartPanel che conterrà il grafico
    ChartPanel ch = new ChartPanel(jfreechart);
    ch.setSize(600,400);
    //Aggiunta del ChartPanel al JPanel
    this.add(ch);
  }
}