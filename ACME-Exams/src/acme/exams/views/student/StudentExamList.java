package acme.exams.views.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import acme.exams.exceptions.InvalidDateException;
import acme.exams.exceptions.MarkNotFoundException;
import acme.exams.model.IExam;
import acme.exams.model.Student;

/**
 * Vies showing the list of exams for a student 
 * @author Andrea Santi
 *
 */
public class StudentExamList extends JPanel implements StudentExamListViewInterface, ActionListener{

  private JRadioButton radiolimitato;
  private JRadioButton radiononlimitato;
  private JButton cmdvisualizza;
  private JButton buttonDettagliAppello;

  private JTextField txtAppelloDateDay;
  private JTextField txtAppelloDateMonth;
  private JTextField txtAppelloDateYear;

  private JTextField txtAppelloInscrEndDay;
  private JTextField txtAppelloInscrEndMonth;
  private JTextField txtAppelloInscrEndYear;
  private JLabel lblStatus;

  private JList<String> listaEsami;
  private JScrollPane scrollPane;
  private JButton cabiaStatoIscrizione;
  private Student student;

  private StudentExamListViewObserver observer;
  private List<IExam> exams;
  private static final long serialVersionUID=1;

  public StudentExamList(Student student, List<IExam> exams){
    //Invocazione del costruttore della classe padre
    super();
    this.setLayout(null);		
    this.student = student;
    this.exams = exams;

    //Creazione GUI
    lblStatus = new JLabel();
    lblStatus.setBounds(13, 410, 400, 30);
    JLabel lblDataFine = new JLabel();
    lblDataFine.setText("Data Fine:");
    lblDataFine.setLocation(50, 115);
    lblDataFine.setSize(73, 24);
    JLabel lblDataInizio = new JLabel();
    lblDataInizio.setBounds(50, 90, 73, 24);
    lblDataInizio.setText("Data Inizio: ");
    txtAppelloDateDay = new JTextField();
    txtAppelloDateDay.setBounds(120, 90, 34, 22);
    txtAppelloDateMonth = new JTextField();
    txtAppelloDateMonth.setLocation(164, 90);
    txtAppelloDateMonth.setSize(34, 22);
    txtAppelloDateYear = new JTextField();
    txtAppelloDateYear.setLocation(208, 90);
    txtAppelloDateYear.setSize(34, 22);
    txtAppelloInscrEndDay = new JTextField();
    txtAppelloInscrEndDay.setLocation(120, 115);
    txtAppelloInscrEndDay.setSize(34, 22);
    txtAppelloInscrEndMonth = new JTextField();
    txtAppelloInscrEndMonth.setLocation(164, 115);
    txtAppelloInscrEndMonth.setSize(34, 22);
    txtAppelloInscrEndYear = new JTextField();
    txtAppelloInscrEndYear.setSize(34, 22);
    txtAppelloInscrEndYear.setLocation(208, 115);

    this.add(txtAppelloInscrEndYear);
    this.add(txtAppelloInscrEndMonth);
    this.add(txtAppelloInscrEndDay);
    this.add(lblDataFine);
    this.add(txtAppelloDateYear);
    this.add(txtAppelloDateMonth);
    this.add(txtAppelloDateDay);
    this.add(lblDataInizio);
    this.add(lblStatus);

    JLabel lblvisualizza = new JLabel();
    lblvisualizza.setBounds(20, 0, 600, 38);
    lblvisualizza.setText("Visualizza Elenco Esami");
    lblvisualizza.setHorizontalTextPosition(javax.swing.SwingConstants.TRAILING);
    lblvisualizza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);


    radiolimitato = new JRadioButton("Seleziona Intervallo");
    radiolimitato.setBounds(20, 65, 150, 25);
    this.add(radiolimitato);
    radiononlimitato = new JRadioButton("Non Limitato");
    radiononlimitato.setBounds(20, 40, 110, 25);
    radiononlimitato.setSelected(true);
    this.add(radiononlimitato);
    this.add(radiolimitato);

    buttonDettagliAppello = new JButton("Visualizza dettagli appello");
    buttonDettagliAppello.setBounds(450,380,180,30);
    this.add(buttonDettagliAppello);

    cabiaStatoIscrizione = new JButton("Cambia stato iscrizione");
    cabiaStatoIscrizione.setPreferredSize(new java.awt.Dimension(70,30));
    cabiaStatoIscrizione.setBounds(13, 380, 180, 30);
    this.add(cabiaStatoIscrizione);

    listaEsami = new JList<>(this.getExamListModel(this.exams));			
    /* Aggiunta della JList ad uno scrollPane per permettere lo scroll
		   quando questo è richiesto*/

    scrollPane = new JScrollPane(listaEsami ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    scrollPane.setBounds(15, 165, 615, 200);
    this.add(scrollPane);

    cmdvisualizza = new JButton();
    cmdvisualizza.setBounds(350, 90, 130, 30);
    cmdvisualizza.setName("");
    cmdvisualizza.setText("Visualizza");

    this.add(cmdvisualizza);
    this.add(lblvisualizza);	


    //Registazione dell'ascoltatore ai bottoni
    cmdvisualizza.addActionListener(this);
    cabiaStatoIscrizione.addActionListener(this);
    ButtonGroup grp = new ButtonGroup();
    grp.add(radiolimitato);
    grp.add(radiononlimitato);
    radiolimitato.addActionListener(this);
    radiononlimitato.addActionListener(this);
    buttonDettagliAppello.addActionListener(this);
  }

  private ListModel<String> getExamListModel(List<IExam> exams) {

    DefaultListModel<String> listModel = new DefaultListModel<>();

    Iterator<IExam> it= exams.iterator();
    IExam currentExam;

    String data;
    Calendar cal = Calendar.getInstance();

    //Scansione degli appelli
    while(it.hasNext()){
      currentExam = it.next();
      cal.setTime(currentExam.getDate());
      int day = cal.get(Calendar.DAY_OF_MONTH);
      int month = cal.get(Calendar.MONTH)+1;
      int year = cal.get(Calendar.YEAR);

      data = currentExam.getDescription() +
          "                " + day+"/"+month+"/"+year + 
          "           " + currentExam.getMaxStudents() + "                ";
      try {
        int mark = currentExam.getMark(student.getEnrollmentId());
        data+="(iscritto" + (mark==IExam.NO_MARK ? ")" : " voto: " + mark + ")");
      } catch (MarkNotFoundException ex){
        data+="(non iscritto)";
      }
      data +="                "+currentExam.getMarks().size()+"/"+currentExam.getMaxStudents();
      //Aggiunta del valore al listmodel
      listModel.addElement(data);
    }
    return listModel;
  }

  private void validateDate(int day, int month) throws InvalidDateException{
    if (((month==11||month==4||month==6||month==9)&&(day<0||day>30)) ||	(month==2 && (day<0||day>28)) ||(day<0||day>31) ||(month<1 || month>12)) {
      throw new InvalidDateException();
    }
  }

  private Date calcAppelloDate()throws InvalidDateException{

    int appelloDay = Integer.parseInt(txtAppelloDateDay.getText());
    int appelloMonth = Integer.parseInt(txtAppelloDateMonth.getText());
    int appelloYear = Integer.parseInt(txtAppelloDateYear.getText());

    try{
      this.validateDate(appelloDay,appelloMonth);
    }
    catch(InvalidDateException ex){
      throw new InvalidDateException();
    }

    Calendar cal = Calendar.getInstance();
    cal.set(appelloYear,appelloMonth-1,appelloDay);
    return cal.getTime();
  }

  private Date calcAppelloEndRegistrationDate()throws InvalidDateException{	

    int appelloEndIscrDay = Integer.parseInt(txtAppelloInscrEndDay.getText());
    int appelloEndIscrMonth = Integer.parseInt(txtAppelloInscrEndMonth.getText());
    int appelloEndIscrYear = Integer.parseInt(txtAppelloInscrEndYear.getText());

    try{
      this.validateDate(appelloEndIscrDay,appelloEndIscrMonth);
    }
    catch(InvalidDateException ex){
      throw new InvalidDateException();
    }

    Calendar cal = Calendar.getInstance();
    cal.set(appelloEndIscrYear,appelloEndIscrMonth-1,appelloEndIscrDay);

    return cal.getTime();
  }

  public void actionPerformed(ActionEvent e){

    Object tastoPremuto = e.getSource();
    int idxExam = listaEsami.getSelectedIndex();

    if(tastoPremuto==cmdvisualizza){
      if(radiolimitato.isSelected()){
        /* Se è stato selezionato il radioButton per la ricerca limitata si effettua una ricerca
        nel range fornito dalle due date*/
        try{
          if((txtAppelloDateDay.getText().length()==0) || (txtAppelloDateMonth.getText().length()==0) || (txtAppelloDateYear.getText().length()==0) || (txtAppelloInscrEndDay.getText().length()==0) || (txtAppelloInscrEndMonth.getText().length()==0) || (txtAppelloInscrEndYear.getText().length()==0)){
            lblStatus.setText("Errore completare tutti i campi");
          } else {
            observer.searchExamsBetweenDatesCmd(this.calcAppelloDate(), this.calcAppelloEndRegistrationDate());
          }
        } catch(InvalidDateException ex){
          lblStatus.setText("Errore inserire delle date valide.");
        } catch(NumberFormatException ex){
          lblStatus.setText("Errore.Le date e il numero di iscritti devono essere valori numerici.");
        }
      } else if(radiononlimitato.isSelected()){
        //Se non è stato scelto di limitare la selezione si visualizzano tutti gli appelli
        observer.showAllExamsCmd();
      }
    } else if(tastoPremuto==cabiaStatoIscrizione) {
      if(idxExam!=-1){
        observer.changeRegistrationStatus(student.getEnrollmentId(), exams.get(idxExam).getId());
      } else {
        lblStatus.setText("Impossibire cambiare lo stato di iscrizione nessun appello selezionato");
      }
    } else if(tastoPremuto==buttonDettagliAppello){
      if(idxExam!=-1){
        observer.displayExamDetails(exams.get(idxExam).getId());
      }
    }
  }

  @Override
  public void attachObserver(StudentExamListViewObserver observer) {
    this.observer = observer;
  }

  @Override
  public void updateDisplayedExams(List<IExam> exams) {
    this.exams = exams;
    this.listaEsami.setModel(this.getExamListModel(this.exams ));
  }

  @Override
  public void displayMsg(String msg) {
    this.lblStatus.setText(msg);
  }

  @Override
  public void refreshView() {
    this.listaEsami.setModel(this.getExamListModel(this.exams));
  }
 
  /**
   * Interface for an observer of  StudentExamListViewInterface
   * @author Andrea Santi
   *
   */
  public interface StudentExamListViewObserver{
    void searchExamsBetweenDatesCmd(Date calcAppelloDate, Date calcAppelloEndRegistrationDate);
    void showAllExamsCmd();
    void changeRegistrationStatus(int studentEnrollmentId, String examId);
    void displayExamDetails(String examId);
  }
}