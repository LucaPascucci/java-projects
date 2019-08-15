package acme.exams.views.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import acme.exams.model.IExam;

/**
 * View used by professor for assigning mark to students
 * @author Andrea Santi
 *
 */
public class AssignMarks extends JPanel implements AssignMarksViewInterface, ActionListener{

  private JLabel lblStatus;
  private JList<String> listaIscritti;
  private JScrollPane scrollPane;
  private JButton inserisciVoto;
  private JComboBox<String> comboVoto;

  private AssignMarksViewObserver observer;
  private IExam exam;
  private static final long serialVersionUID=1;

  public AssignMarks(IExam exam){

    //Invocazione del costruttore della classe padre
    super();
    this.setLayout(null);		
    this.exam = exam;

    //Preparazione del combo dei voti
    comboVoto = new JComboBox<>();
    comboVoto.setBounds(260,327,100,20);
    comboVoto.addItem("Bocciato");
    for(int i=18;i<31;i++){
      comboVoto.addItem(""+i);
    }
    JLabel lblVoto = new JLabel("Inserisci il voto per questo studente");
    lblVoto.setBounds(13,330,220,16);
    JLabel titol = new JLabel("Elenco iscritti");
    lblStatus = new JLabel();
    lblStatus.setBounds(13,390,400,16);
    this.add(lblStatus);
    titol.setBounds(13,47,650,26);
    titol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    this.add(titol);
    this.add(lblVoto);

    inserisciVoto = new JButton("Inserisci voto");
    inserisciVoto.setBounds(450,320,180,40);
    inserisciVoto.addActionListener(this);

    this.add(inserisciVoto);
    this.add(comboVoto);

    listaIscritti = new JList<>(this.getStudentMarksListModel(exam.getMarks()));
    /* Aggiunta della JList ad uno scrollPane per permettere lo scroll
       quando questo  è richiesto */
    scrollPane = new JScrollPane(listaIscritti ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(13,91,622,207);
    this.add(scrollPane);
  }

  private ListModel<String> getStudentMarksListModel(Map<Integer,Integer> map){
    DefaultListModel<String> listModel = new DefaultListModel<String>();
    for (Entry<Integer, Integer> entry :  exam.getMarks().entrySet()){
      if (entry.getValue() == IExam.FAILED_EXAM_MARK){
        listModel.addElement(entry.getKey() + "           " + "Bocciato");
      }
      else if(entry.getValue() != IExam.NO_MARK){
        listModel.addElement(entry.getKey() + "           " + entry.getValue());
      } else {
        listModel.addElement(""+entry.getKey());
      }
    }
    return listModel;
  }

  public void actionPerformed(ActionEvent e){
    Object buttonPressed = e.getSource();
    String sel = listaIscritti.getSelectedValue();
    if(buttonPressed == inserisciVoto){
      if (sel!=null){
        observer.assignMark(Integer.parseInt(sel.split(" ")[0]), parseMark(), this.exam);
      } else {
        lblStatus.setText("Nessuno studente selezionato");
      }
    }
  }

  private int parseMark() {
    String mark = (String) comboVoto.getSelectedItem();
    int returnValue = IExam.FAILED_EXAM_MARK;
    try{
      returnValue = Integer.parseInt(mark);
    } catch (NumberFormatException ex){}
    return returnValue;
  }

  @Override
  public void attachObserver(AssignMarksViewObserver observer) {
    this.observer = observer;
  }

  @Override
  public void clearInterface() { }
  
  @Override
  public void displayMsg(String msg) {
    this.lblStatus.setText(msg);
  }

  @Override
  public void refreshMarksView() {
    this.listaIscritti.setModel(getStudentMarksListModel(exam.getMarks()));
  }

  /**
   * Interface for an observer of the AssignMarksViewInterface
   * @author Andrea Santi
   *
   */
  public interface AssignMarksViewObserver {
    void assignMark(int enrollmentId, int mark, IExam exam);
  }
}