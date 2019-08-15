package acme.exams.views.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import acme.exams.model.IExam;

/**
 * Vies showing the list of exams for a professor
 * @author Andrea Santi
 *
 */
public class ProfessorExamsList extends JPanel implements ProfessorExamsListViewInterface, ActionListener{

  private JLabel lblStatus;
  private JList<IExam> listaEsami;
  private JScrollPane scrollPane;
  private JButton buttonModifica;
  private JButton buttonCancella;
  private JButton buttonVisualizza;
  private JButton buttonInserisciVoti;
  private JButton buttonSaveAppello;
  private JButton buttonLoadAppello;

  private ProfessorExamsListViewObserver observer;
  private static final long serialVersionUID=1;

  public ProfessorExamsList(List<IExam> professorExamList){

    //Invocazione del costruttore della classe padre
    super();
    this.setLayout(null);
    //Creazione GUI
    JLabel titol = new JLabel("Elenco esami");
    lblStatus = new JLabel();
    lblStatus.setBounds(13,410,400,16);
    this.add(lblStatus);
    titol.setBounds(13,37,650,26);
    titol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(titol);

    buttonModifica = new JButton("Modifica");
    buttonModifica.setBounds(13,280,140,40);
    buttonCancella = new JButton("Cancella");
    buttonCancella.setBounds(174,280,140,40);
    buttonVisualizza = new JButton("Visualizza");
    buttonVisualizza.setBounds(335,280,140,40);
    buttonInserisciVoti = new JButton("Inserisci voti");
    buttonInserisciVoti.setBounds(495,280,140,40);
    buttonSaveAppello = new JButton("Salva appello");
    buttonSaveAppello.setBounds(13,360,140,40);
    buttonLoadAppello = new JButton("Carica appello");
    buttonLoadAppello.setBounds(495,360,140,40);

    buttonModifica.addActionListener(this);
    buttonCancella.addActionListener(this);
    buttonVisualizza.addActionListener(this);
    buttonInserisciVoti.addActionListener(this);
    buttonSaveAppello.addActionListener(this);
    buttonLoadAppello.addActionListener(this);

    this.add(buttonModifica);
    this.add(buttonCancella);
    this.add(buttonVisualizza);
    this.add(buttonInserisciVoti);
    this.add(buttonLoadAppello);
    this.add(buttonSaveAppello);
    //Creazione della JList con l'elenco degli appelli di questo docente
    listaEsami = new JList<IExam>(professorExamList.toArray(new IExam[0]));
    //Aggiunta della scrollpane per gestire lo scroll
    scrollPane = new JScrollPane(listaEsami, 
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    scrollPane.setBounds(13,81,622,187);
    this.add(scrollPane);
  }

  public void actionPerformed(ActionEvent e){
    Object buttonPressed = e.getSource();
    if(buttonPressed == buttonLoadAppello){
      JFileChooser fileDialog = new JFileChooser();
      if(fileDialog.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
          observer.loadExamCmd(fileDialog.getSelectedFile().getPath());
      }
    } else {
      if(listaEsami.getSelectedValue()!=null){
        IExam selectedExam = listaEsami.getSelectedValue();
        if(buttonPressed==buttonModifica){
          this.observer.editExamCmd(selectedExam);
        } else if(buttonPressed == buttonCancella){
          this.observer.deleteExamCmd(selectedExam);
        } else if(buttonPressed == buttonVisualizza){
          this.observer.showExamDetails(selectedExam);
        } else if(buttonPressed == buttonInserisciVoti){
          this.observer.insertMarksCmd(selectedExam);
        } else if(buttonPressed == buttonSaveAppello){
          JFileChooser fileDialog = new JFileChooser();
          if(fileDialog.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
            this.observer.saveExamCmd(fileDialog.getSelectedFile().getPath(), selectedExam);
          }
        }
      } else {
        lblStatus.setText("Nessun appello selezionato");
      }			
    }
  }
 
  @Override
  public void refreshExamList(List<IExam> exams) {
    this.listaEsami.setListData(exams.toArray(new IExam[0]));
  }

  @Override
  public void attachObserver(ProfessorExamsListViewObserver observer) {
    this.observer = observer;
  }

  @Override
  public void displayMsg(String msg) {
    this.lblStatus.setText(msg);
  }
 
  /**
   * Interface for an obsserver of ProfessorExamsListViewInterface
   * @author Andrea Santi
   */
  public interface ProfessorExamsListViewObserver {
    void loadExamCmd(String path);
    void saveExamCmd(String path, IExam selectedExam);
    void insertMarksCmd(IExam selectedExam);
    void showExamDetails(IExam selectedExam);
    void editExamCmd(IExam selectedExam);
    void deleteExamCmd(IExam selectedExam);
  }
}