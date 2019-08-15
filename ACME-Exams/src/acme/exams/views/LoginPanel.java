package acme.exams.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Models a login view
 * @author Andrea Santi
 *
 */
public class LoginPanel extends JPanel implements LoginViewInterface, ActionListener{

  private JButton buttonLogin;
  private JButton buttonReset;
  private JButton buttonRegDocente;
  private JButton buttonRegStudente;
  private JTextField username;
  private JPasswordField password;
  private JRadioButton studente;
  private JRadioButton docente;
  private JLabel lblStatus;
  private LoginViewObserver observer;
  private static final long serialVersionUID=1;

  /**
   * Creates a new LoginPanel
   */
  public LoginPanel(){

    //Invocazione del costruttore della classe padre
    super();
    //Copia dei riferimenti del gestoreAppelli e del MainFrame
    this.setLayout(null);
    //Creazione GUI
    JLabel lblTitle = new JLabel();
    lblTitle.setBounds(0, 60, 650, 20);
    lblTitle.setText("Effettua il Login per accedere ad ACMEWex.");
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(lblTitle);

    JLabel lblIscr = new JLabel("Se non sei registrato registrati ora.");
    lblIscr.setBounds(163,348,327,22);
    this.add(lblIscr);

    this.lblStatus = new JLabel();
    lblStatus .setBounds(163,300,380,22);
    this.add(lblStatus);

    JLabel lblUsr = new JLabel();
    lblUsr.setBounds(164, 133, 65, 25);
    lblUsr.setText("Username");
    docente = new JRadioButton("Studente");
    docente.setBounds(169, 242, 109, 20);
    docente.setText("Docente");
    buttonReset = new JButton();
    buttonReset.setBounds(368, 223, 121, 43);
    buttonReset.setText("Reset");

    buttonLogin = new JButton();
    buttonLogin.setBounds(368, 143, 121, 43);
    buttonLogin.setText("Login");

    buttonRegDocente = new JButton("Docente");
    buttonRegDocente.setBounds(333,389,157,28);
    buttonRegDocente.setText("Registra Docente");

    buttonRegStudente = new JButton();
    buttonRegStudente.setBounds(161,389,157,28);
    buttonRegStudente.setText("Registra Studente");

    username = new JTextField();
    username.setBounds(237, 143, 100, 25);
    password = new JPasswordField();
    password.setBounds(237, 180, 100, 25);
    studente = new JRadioButton("Studente");
    studente.setBounds(169, 222, 109, 20);
    studente.setText("Studente");

    this.add(docente);
    this.add(studente);

    JLabel lblPwd = new JLabel();
    lblPwd.setBounds(164, 180, 65, 25);
    lblPwd.setText("Password");
    this.add(lblPwd);

    this.add(lblUsr);
    this.add(password);
    this.add(username);
    this.add(buttonReset);
    this.add(buttonLogin);
    this.add(buttonRegDocente);
    this.add(buttonRegStudente);

    buttonLogin .addActionListener(this);
    buttonReset.addActionListener(this);
    ButtonGroup grp = new ButtonGroup();
    grp.add(studente);
    grp.add(docente);
    studente.addActionListener(this);
    docente.addActionListener(this);
    buttonRegDocente.addActionListener(this);
    buttonRegStudente.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e){
    Object buttonPressed = e.getSource();
    if(buttonPressed==buttonLogin){
      if(studente.isSelected()){
        this.observer.doLoginStudentCmd(username.getText(), new String(password.getPassword()));
      } else if(docente.isSelected()){
        this.observer.doLoginProfessorCmd(username.getText(), new String(password.getPassword()));
      }
    } else if(buttonPressed==buttonReset){
      this.clearInterface();
    } else if(buttonPressed==buttonRegDocente){
      this.observer.registerProfessor();
    } else if(buttonPressed==buttonRegStudente){
      this.observer.registerStudent();
    }
  }

  @Override
  public void attachObserver(LoginViewObserver observer) {
    this.observer = observer;
  }

  @Override
  public void clearInterface() {
    username.setText("");
    password.setText("");
  }
  
  /**
  * Interface for an observer of the LoginViewInterface view
   * @author Andrea Santi
   */
  public static interface LoginViewObserver {
    /**
     * Method invoked when a student login operation is triggered from the view 
     * @param username
     * @param password
     */
    void doLoginStudentCmd(String username, String password);
    
    /**
     * Method invoked when a professor login operation is triggered from the view 
     * @param username
     * @param password
     */
    void doLoginProfessorCmd(String username, String password);
    
    /**
     * Method invoked when a register student operation is triggered from the view 
     */
    void registerStudent();
    
    /**
     * Method invoked when a register professor operation is triggered from the view 
     */
    void registerProfessor();
  }
}