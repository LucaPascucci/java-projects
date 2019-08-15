package acme.exams.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import acme.exams.exceptions.InvalidDateException;
import acme.exams.model.ExamType;
import acme.exams.model.IExam;

/**
 * View for editing an exam
 * @author Andrea Santi
 *
 */
public class EditExam extends JPanel implements EditExamViewInterface, ActionListener{

  //Dichiarazione dei campi per la gestione dell'UI
  private JTextField txtNomeAppello;
  private JTextField txtLuogo;
  private JComboBox<ExamType> comboAppelloType;
  private JTextField txtNEsame;
  private JButton buttonDoOperation;
  private JButton buttonReset;
  private JLabel lblTitle;
  private JLabel lblStatus;
  private JTextField txtAppelloDateDay;
  private JTextField txtAppelloDateMonth;
  private JTextField txtAppelloDateYear;
  private JTextField txtAppelloInscrEndDay;
  private JTextField txtAppelloInscrEndMonth;
  private JTextField txtAppelloInscrEndYear;
  private JComboBox<Integer> comboOraAppello;
  private JComboBox<Integer> comboMinuteAppello;
  private JComboBox<Integer> comboOraChiusura;
  private JComboBox<Integer> comboMinuteChiusura;

  private EditExamViewObserver observer;
  private IExam exam;
  private static final long serialVersionUID=1;

  /**
   * Creates a new EditExam
   * @param exam
   */
  public EditExam(IExam exam){

    //Invocazione del costruttore della classe padre
    super();
    this.setLayout(null);
    this.exam = exam;
    lblTitle = new JLabel();
    buttonDoOperation = new JButton();

    //Creazione GUI
    lblTitle.setBounds(0,60,650,16);
    lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(lblTitle);

    JLabel lblAppelloName  = new JLabel("Nome Appello");
    lblAppelloName.setBounds(63,113,100,25);
    JLabel lblDataAppello = new JLabel("Data Appello");
    lblDataAppello.setBounds(63,163,100,25);
    JLabel lblChiusuraLista = new JLabel("Chiusura lista");
    lblChiusuraLista.setBounds(331,163,100,25);

    JLabel lblOraAppello = new JLabel("Ora Appello");
    lblOraAppello.setBounds(63,268,100,25);

    JLabel lblOraChiusura = new JLabel("Ora chiusura");
    lblOraChiusura.setBounds(331,268,100,25);

    JLabel lblLuogo = new JLabel("Luogo");
    lblLuogo.setBounds(331,213,100,25);
    JLabel lblAppelloType = new JLabel("Tipo appello");
    lblAppelloType.setBounds(63,213,100,25);
    JLabel lblMaxIscritti = new JLabel("N° max iscritti");
    lblMaxIscritti.setBounds(331,113,100,25);

    this.add(lblOraAppello);
    this.add(lblOraChiusura);
    this.add(lblAppelloName);
    this.add(lblDataAppello);
    this.add(lblChiusuraLista);
    this.add(lblLuogo);
    this.add(lblAppelloType);
    this.add(lblMaxIscritti);

    txtAppelloDateDay = new JTextField();
    txtAppelloDateDay.setBounds(171, 168,34,22);

    txtAppelloDateMonth = new JTextField();
    txtAppelloDateMonth.setBounds(215, 168,34,22);

    txtAppelloDateYear = new JTextField();
    txtAppelloDateYear.setBounds(259, 168, 34, 22);

    this.add(txtAppelloDateDay);
    this.add(txtAppelloDateMonth);
    this.add(txtAppelloDateYear);

    txtAppelloInscrEndDay = new JTextField();
    txtAppelloInscrEndDay.setBounds(440, 168,34,22);

    txtAppelloInscrEndMonth = new JTextField();
    txtAppelloInscrEndMonth.setBounds(484, 168,34,22);

    txtAppelloInscrEndYear = new JTextField();
    txtAppelloInscrEndYear.setBounds(528, 168, 34, 22);

    this.add(txtAppelloInscrEndDay);
    this.add(txtAppelloInscrEndMonth);
    this.add(txtAppelloInscrEndYear);

    txtNomeAppello = new JTextField();
    txtNomeAppello.setBounds(171,118,141,20);
    txtLuogo = new JTextField();
    txtLuogo.setBounds(440,218,141,20);
    comboAppelloType = new JComboBox<>();
    comboAppelloType.setBounds(171,218,141,20);
    comboAppelloType.addItem(ExamType.ORAL);
    comboAppelloType.addItem(ExamType.WRITTEN);
    comboAppelloType.addItem(ExamType.PRACTICAL);
    txtNEsame = new JTextField();
    txtNEsame.setBounds(440,118,141,20);

    comboOraAppello = new JComboBox<>();
    comboMinuteAppello = new JComboBox<>();
    comboOraChiusura = new JComboBox<>();
    comboMinuteChiusura = new JComboBox<>();

    for(int i=1;i<=24;i++){
      comboOraAppello.addItem(i);
      comboOraChiusura.addItem(i);
    }
    for(int i=0;i<60;i++){
      comboMinuteAppello.addItem(i);
      comboMinuteChiusura.addItem(i);
    }
    comboOraAppello.setBounds(171,268,40,25);
    comboMinuteAppello.setBounds(231,268,40,25);
    comboOraChiusura.setBounds(440,268,40,25);
    comboMinuteChiusura.setBounds(500,268,40,25);
    //lblOraChiusura.setBounds(331,268,100,25);
    this.add(comboOraAppello);
    this.add(comboMinuteAppello);
    this.add(comboOraChiusura);
    this.add(comboMinuteChiusura);		
    this.add(txtNomeAppello);
    this.add(txtLuogo);
    this.add(comboAppelloType);
    this.add(txtNEsame);

    buttonDoOperation.setBounds(167,330,150,35);
    buttonReset = new JButton("Resetta");
    buttonReset.setBounds(340,330,150,35);
    this.add(buttonDoOperation);
    this.add(buttonReset);
    lblStatus = new JLabel();
    lblStatus.setBounds(167,360,400,20);
    this.add(lblStatus);
    //Registrazione dell'ascoltatore ai bottoni
    buttonDoOperation.addActionListener(this);
    buttonReset.addActionListener(this);
    if(this.exam==null){
      lblTitle.setText("Effettua l'inserimento dell'appello.");
      buttonDoOperation.setText("Aggiungi Appello");
    } else {
      populateViewWithExamInfo();
    }
    this.setSize(400,230);
  }

  private void validateDate(int day, int month) throws InvalidDateException{
    if (((month==11||month==4||month==6||month==9)&&(day<0||day>30)) ||	(month==2 && (day<0||day>28)) ||(day<0||day>31) ||(month<1 || month>12)) {
      throw new InvalidDateException();
    }
  }

  private void populateViewWithExamInfo(){

    lblTitle.setText("Effettua la modifica dell'appello.");
    buttonDoOperation.setText("Modifica Appello");
    //Non viene permesso di cambiare un insieme di informaizoni non modificabili
    this.txtNEsame.setEditable(false);
    this.txtAppelloDateDay.setEditable(false);
    this.txtAppelloDateMonth.setEditable(false);
    this.txtAppelloDateYear.setEditable(false);
    this.txtAppelloInscrEndDay.setEditable(false);
    this.txtAppelloInscrEndMonth.setEditable(false);
    this.txtAppelloInscrEndYear.setEditable(false);
    this.comboOraAppello.setEnabled(false);
    this.comboMinuteAppello.setEnabled(false);
    this.comboOraChiusura.setEnabled(false);
    this.comboMinuteChiusura.setEnabled(false);

    Calendar cal = Calendar.getInstance();
    cal.setTime(exam.getDate());

    this.txtAppelloDateDay.setText(""+cal.get(Calendar.DAY_OF_MONTH));
    this.txtAppelloDateMonth.setText(""+(cal.get(Calendar.MONTH)+1));
    this.txtAppelloDateYear.setText(""+cal.get(Calendar.YEAR));
    this.comboOraAppello.setSelectedItem(cal.get(Calendar.HOUR_OF_DAY));
    this.comboMinuteAppello.setSelectedItem(cal.get(Calendar.MINUTE));

    cal.setTime(exam.getCloseRegistrationDate());

    this.txtAppelloInscrEndDay.setText(""+cal.get(Calendar.DAY_OF_MONTH));
    this.txtAppelloInscrEndMonth.setText(""+(cal.get(Calendar.MONTH)+1));
    this.txtAppelloInscrEndYear.setText(""+cal.get(Calendar.YEAR));
    this.comboOraChiusura.setSelectedItem(cal.get(Calendar.HOUR_OF_DAY));
    this.comboMinuteChiusura.setSelectedItem(cal.get(Calendar.MINUTE));
    this.comboAppelloType.setSelectedItem(exam.getExamType());
    this.txtLuogo.setText(exam.getExamLocation());
    this.txtNEsame.setText(""+exam.getMaxStudents());
    this.txtNomeAppello.setText(exam.getDescription());
  }

  public void setReadOnly(){
    this.lblTitle.setText("Visualizzazione dati appello");
    this.txtAppelloDateDay.setEditable(false);
    this.txtAppelloDateMonth.setEditable(false);
    this.txtAppelloDateYear.setEditable(false);
    this.txtAppelloInscrEndDay.setEditable(false);
    this.txtAppelloInscrEndMonth.setEditable(false);
    this.txtAppelloInscrEndYear.setEditable(false);
    this.comboAppelloType.setEnabled(false);
    this.txtLuogo.setEditable(false);
    this.txtNEsame.setEditable(false);
    this.txtNomeAppello.setEditable(false);
    this.txtNomeAppello.setEditable(false);
    this.comboOraAppello.setEnabled(false);
    this.comboMinuteAppello.setEnabled(false);
    this.comboOraChiusura.setEnabled(false);
    this.comboMinuteChiusura.setEnabled(false);
    this.remove(buttonReset);
    this.remove(buttonDoOperation);
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

    cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(comboOraAppello.getSelectedItem().toString()));
    cal.set(Calendar.MINUTE,Integer.parseInt(comboMinuteAppello.getSelectedItem().toString()));

    return cal.getTime();
  }

  private Date calcAppelloEndDate()throws InvalidDateException{	
    int appelloEndIscrDay = Integer.parseInt(txtAppelloInscrEndDay.getText());
    int appelloEndIscrMonth = Integer.parseInt(txtAppelloInscrEndMonth.getText());
    int appelloEndIscrYear = Integer.parseInt(txtAppelloInscrEndYear.getText());
    this.validateDate(appelloEndIscrDay,appelloEndIscrMonth);

    Calendar cal = Calendar.getInstance();
    cal.set(appelloEndIscrYear,appelloEndIscrMonth-1,appelloEndIscrDay);
    cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(comboOraChiusura.getSelectedItem().toString()));
    cal.set(Calendar.MINUTE,Integer.parseInt(comboMinuteChiusura.getSelectedItem().toString()));
    return cal.getTime();
  }


  public void actionPerformed(ActionEvent e){

    Object buttonPressed = e.getSource();
    if(buttonPressed==buttonDoOperation){
      try{

        /* Se appelloId è null e si e premuto buttonDoOperation si vuole
        registare un nuovo appello */
        if(this.exam==null){
          Date appelloDate = this.calcAppelloDate();
          Date endInscrictionDate = this.calcAppelloEndDate();        
          observer.saveExamCmd(txtNomeAppello.getText(), appelloDate, endInscrictionDate, (ExamType) comboAppelloType.getSelectedItem(), txtLuogo.getText(), Integer.parseInt(txtNEsame.getText()));
        } else {
          observer.updateExamCmd(txtNomeAppello.getText(), (ExamType) comboAppelloType.getSelectedItem(), txtLuogo.getText());
        }
      } catch(NumberFormatException ex){
        lblStatus.setText("Errore.Le date e il numero di iscritti devono essere valori numerici.");
      } catch(InvalidDateException ex){
        lblStatus.setText("Errore.Inserire una data valida.");
      }
    } else if(buttonPressed==buttonReset){
      this.clearInterface();
    }
  }

  @Override
  public void attachObserver(EditExamViewObserver observer) {
    this.observer = observer;
  }

  @Override
  public void clearInterface() {
    txtNomeAppello.setText("");
    txtLuogo.setText("");
    if(this.exam==null){
      txtNEsame.setText("");
      txtAppelloDateDay.setText("");
      txtAppelloDateMonth.setText("");
      txtAppelloDateYear.setText("");
      txtAppelloInscrEndDay.setText("");
      txtAppelloInscrEndMonth.setText("");
      txtAppelloInscrEndYear.setText("");
      this.lblStatus.setText("");
    }
  }

  @Override
  public void displayMsg(String msg) {
    this.lblStatus.setText(msg);
  }

  @Override
  public String getExamId() {
    return exam.getId();
  }
  
  /**
   * Interface for an observer of the EditExamViewInterface view
   * @author Andrea Santi
   *
   */
  public interface EditExamViewObserver {
    /**
     * Method invoked when an update exam event is triggered by the view 
     * @param description
     * @param examType
     * @param location
     */
    void updateExamCmd(String description, ExamType examType, String location);

    /**
     * Method invoked when a save new exam event is triggered by the view 
     * @param description
     * @param examDate
     * @param endInscrictionDate
     * @param examType
     * @param location
     * @param nStudents
     */
    void saveExamCmd(String description, Date examDate,
        Date endInscrictionDate, ExamType examType, String location,
        int nStudents);
  }
}