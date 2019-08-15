package acme.exams.views.student;

import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import acme.exams.exceptions.MarkNotFoundException;
import acme.exams.model.IExam;
import acme.exams.model.Student;

/**
 * View showing the list of exams passed by a student
 * @author Andrea Santi
 *
 */
public class RegistrableExamForStudent extends JPanel{

  private JLabel lblStatus;
  private JList<String> jExamList;
  private JScrollPane scrollPane;
  //Campo che contiene l'id dello studente
  private static final long serialVersionUID=1;

  public RegistrableExamForStudent(List<IExam> exams, Student student){
    //Invocazione del costruttore della classe padre
    super();
    this.setLayout(null);
    JLabel medias = new JLabel("");
    medias.setBounds(13,360,650,20);
    JLabel titol = new JLabel("Elenco esami");
    lblStatus = new JLabel();
    lblStatus.setBounds(13,390,400,16);
    this.add(lblStatus);
    titol.setBounds(13,47,650,26);
    titol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(titol);
    this.add(medias);

    DefaultListModel<String> listModel = new DefaultListModel<>();
    Iterator<IExam> it = exams.iterator();
    IExam currentExam;
    double tot= 0;
    int i=0;
    //Ciclo di scansione degli appelli
    while (it.hasNext()) {
      currentExam =  it.next();
      /* Se lo studente non ha passato l'esame questo viene solamente aggiunto a quelli da
			    visualizzare*/
      try{
        int mark = currentExam.getMark(student.getEnrollmentId());
        if (mark >= IExam.MIN_MARK){
          listModel.addElement(currentExam.getDescription()+" "+ mark);
          tot += mark;
          i++;
        } else if (mark == IExam.FAILED_EXAM_MARK){
          listModel.addElement(currentExam.getDescription() +" Bocciato");
        }
      } catch (MarkNotFoundException ex){ }
    }
    //Calcolo media		
    if(i==0){
      tot=0;
    } else {
      tot/=i;
    }
    //Visualizzazione risultati ottenuti
    medias.setText("La media degli esami sostenuti è:"+" "+tot);
    jExamList = new JList<>(listModel);
    //Utilizzo di una scrollpane nel caso sia necessario effettuare lo scroll
    scrollPane = new JScrollPane(jExamList ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(13,91,622,207);
    this.add(scrollPane);
  }
}
