package acme.exams.views.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * View used for registering a new professor to the system
 * @author Andrea Santi
 *
 */
public class RegisterProfessor extends JPanel implements RegisterProfessorViewInterface, ActionListener {

  //Dichiarazione dei campi per la gestione dell'UI	
  private JTextField txtNome;
  private JTextField txtUsername;
  private JPasswordField txtPassword;
  private JTextField txtMateria;
  private JButton buttonRegistraDocente;
  private JButton buttonReset;
  private JTextField txtCognome;
  private JLabel lblStatus;
  private RegisterProfessorViewObserver observer;
  private static final long serialVersionUID=1;

  public RegisterProfessor(){
    //Invocazione del costruttore della classe padre
    super();
    //Copia dei riferimenti del gestoreAppelli e del MainFrame
    this.setLayout(null);
    JLabel lblTitle = new  JLabel();
    lblTitle.setBounds(0, 44, 650, 16);
    lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblTitle.setText("Effettua Iscrizione Docente");
    JLabel lblMateria = new JLabel();
    lblMateria.setBounds(136, 202, 69, 22);
    lblMateria.setText("Materia");
    JLabel lblPassword = new JLabel();
    lblPassword.setBounds(352, 155, 69, 22);
    lblPassword.setText("Password");
    JLabel lblUsername = new JLabel();
    lblUsername.setBounds(136, 155, 69, 22);
    lblUsername.setText("Username");
    JLabel lblCognome = new JLabel();
    lblCognome.setBounds(351, 109, 69, 22);
    lblCognome.setText("Cognome");
    JLabel lblNome = new JLabel();
    lblNome.setText("Nome");
    lblNome.setBounds(136, 107, 69, 22);
    lblStatus = new JLabel();
    lblStatus.setBounds(165,330,300,16);
    txtNome = new JTextField();
    txtNome.setBounds(207, 111, 98, 20);

    txtUsername = new JTextField();
    txtUsername.setBounds(208, 158, 98, 20);
    txtPassword = new JPasswordField();
    txtPassword.setBounds(427, 158, 98, 20);
    txtMateria = new JTextField("");
    txtMateria.setBounds(208, 205, 98, 20);
    buttonRegistraDocente = new JButton();
    buttonRegistraDocente.setBounds(165, 267, 139, 45);
    buttonRegistraDocente.setText("Salva");
    buttonReset = new JButton();
    buttonReset.setBounds(383, 267, 139, 45);
    buttonReset.setText("Reset");
    txtCognome = new JTextField();
    txtCognome.setBounds(424, 111, 98, 20);

    this.setSize(650, 575);
    this.add(txtCognome);
    this.add(lblTitle);
    this.add(buttonReset);
    this.add(buttonRegistraDocente);
    this.add(lblMateria);
    this.add(txtMateria);
    this.add(lblPassword);
    this.add(txtPassword);
    this.add(lblUsername);
    this.add(txtUsername);
    this.add(lblCognome);
    this.add(txtNome);
    this.add(lblNome);
    this.add(lblStatus);
    //Registrazione dell'ascoltatore ai bottoni
    buttonReset.addActionListener(this);
    buttonRegistraDocente.addActionListener(this);

  }
  public void actionPerformed(ActionEvent e){
    Object tastoPremuto = e.getSource();
    if(tastoPremuto == buttonRegistraDocente){
      this.observer.registerCmd(txtUsername.getText(), new String(txtPassword.getPassword()), txtCognome.getText(), txtNome.getText(), txtMateria.getText());
    } else if(tastoPremuto == buttonReset){
      this.cleanInterface();
    }
  }
  
  @Override
  public void attachObserver(RegisterProfessorViewObserver observer) {
    this.observer = observer;
  }

  @Override
  public void cleanInterface() {
    txtCognome.setText("");
    txtMateria.setText("");
    txtNome.setText("");
    txtPassword.setText("");
    txtUsername.setText("");
  }

  @Override
  public void displayMsg(String string) {
    lblStatus.setText(string);
  }

  /**
   * Observer for RegisterProfessorViewInterface
   */
  public interface RegisterProfessorViewObserver {
    void registerCmd(String username, String password, String name, String surname, String materia);
  }

}