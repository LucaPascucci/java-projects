package acme.exams.views.student;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * View used for registering a new student to the system
 * @author Andrea Santi
 *
 */
public class RegisterStudent extends JPanel implements RegisterStudentViewInterface, ActionListener {

  //Dichiarazione dei campi per la gestione dell'UI
  private JTextField txtNome;
  private JTextField txtCognome;
  private JTextField txtUsername;
  private JPasswordField txtPassword;

  private JLabel lblStatus;
  private JTextField txtMatricola;
  private JButton buttonRegistraStudente;
  private JButton buttonReset;

  private RegisterStudentViewObserver observer;
  private static final long serialVersionUID=1;

  public RegisterStudent(){

    //Invocazione del costruttore della classe padre
    super();
    this.setLayout(null);

    //Creazione GUI
    JLabel lblTitle = new JLabel();
    lblTitle.setBounds(0, 52, 650, 25);
    lblTitle.setText("Effettua Iscrizione Studente");
    lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    JLabel lblMatricola = new JLabel();
    lblMatricola.setBounds(157,223,62,16);
    lblMatricola.setText("Matricola");
    JLabel lblPassword = new JLabel();
    lblPassword.setBounds(371,189,62,16);
    lblPassword.setText("Password");
    JLabel lblUsername = new JLabel();
    lblUsername.setBounds(157,189,62,16);
    lblUsername.setText("Username");
    JLabel lblCognome = new JLabel();
    lblCognome.setBounds(371,153,62,16);
    lblCognome.setText("Cognome");
    JLabel lblNome = new JLabel();
    lblNome.setText("Nome");
    lblNome.setBounds(157,153,62,16);
    lblStatus = new JLabel();
    lblStatus.setBounds(156,388,300,16);

    txtNome = new JTextField();
    txtNome.setBounds(222,151,86,20);
    txtCognome = new JTextField();
    txtCognome.setBounds(438,151,86,20);
    txtUsername = new JTextField();
    txtUsername.setBounds(222,188,86,20);
    txtPassword = new JPasswordField();
    txtPassword.setBounds(438,188,86,20);
    txtMatricola = new JTextField();
    txtMatricola.setBounds(222, 222, 86, 20);
    buttonRegistraStudente = new JButton();
    buttonRegistraStudente.setBounds(156, 324, 150, 53);
    buttonRegistraStudente.setText("Salva");
    buttonReset = new JButton();
    buttonReset.setBounds(368, 326, 150, 53);
    buttonReset.setText("Reset");

    this.setSize(650, 575);
    this.add(buttonReset);
    this.add(buttonRegistraStudente);
    this.add(txtMatricola);
    this.add(lblMatricola);
    this.add(txtPassword);
    this.add(lblPassword);
    this.add(txtUsername);
    this.add(lblUsername);
    this.add(txtCognome);
    this.add(lblCognome);
    this.add(txtNome);
    this.add(lblNome);
    this.add(lblStatus);
    //Aggiunta dell'ascoltatore ai bottoni
    buttonRegistraStudente.addActionListener(this);
    buttonReset.addActionListener(this);

  }

  public void actionPerformed(ActionEvent e){
    Object buttonSelected = e.getSource();
    if(buttonSelected==buttonRegistraStudente){
      try{
        this.observer.registerCmd(txtUsername.getText(), 
            new String(txtPassword.getPassword()), 
            txtCognome.getText(), txtNome.getText(), 
            Integer.parseInt(txtMatricola.getText()));
      } catch(NumberFormatException exc){
        lblStatus.setText("Errore.La matricola deve essere un valore numerico");
      }
    } else if(buttonSelected == buttonReset){
      this.cleanInterface();
    }
  }

  @Override
  public void cleanInterface() {
    txtCognome.setText("");
    txtMatricola.setText("");
    txtNome.setText("");
    txtPassword.setText("");
    txtUsername.setText("");
  }
  
   @Override
  public void attachObserver(RegisterStudentViewObserver observer) {
    this.observer = observer;
  }

  @Override
  public void displayMsg(String string) {
    lblStatus.setText(string);
  }

  /**
   * Observer for RegisterStudentViewInterface
   * @author Andrea Santi
   *
   */
  public interface RegisterStudentViewObserver {
    void registerCmd(String username, String password, String name, String surname, int enrollmentId);
  }
}