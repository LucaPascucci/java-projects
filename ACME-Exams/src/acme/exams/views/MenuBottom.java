package acme.exams.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Model the bottom menu of the application
 * @author Andrea Santi
 *
 */
public class MenuBottom extends JPanel implements MenuBottomInterface, ActionListener{

	private static final String LOGIN = "Login";
	private static final String LOGOUT = "Logout";
	//Bottoni della classe
	private JButton buttonHome;
	private JButton buttonLogOperation;
	private JButton buttonPrintReg;

	private MenuBottomViewObserver observer;
	private static final long serialVersionUID=1;

	public MenuBottom(){
		//Invocazione del costruttore della classe padre
		super();
		this.setLayout(null);
		//Creazione GUI
		buttonLogOperation = new JButton(LOGIN);
		buttonLogOperation.setBounds(450, 6, 180, 28);
		buttonHome = new JButton("Home");
		buttonHome.setBounds(13, 6, 180, 28);
		buttonHome.setEnabled(false);
		buttonPrintReg = new JButton();
	    buttonPrintReg.setBounds(233, 6, 180, 28);
	    buttonPrintReg.setText("Stampa Utenti Registrati");
		this.add(buttonHome);
		this.add(buttonLogOperation);
		this.add(buttonPrintReg);
		buttonHome.addActionListener(this);
		buttonLogOperation.addActionListener(this);
		buttonPrintReg.addActionListener(this);
		this.setPreferredSize(new Dimension(650,60));
		
	}

	@Override
	public void setUserLogged(){
		this.buttonLogOperation.setText(LOGOUT);
    updateButtonHome(true);
	}

	@Override
	public void setUserNotLogged(){
		this.buttonLogOperation.setText(LOGIN);
		updateButtonHome(false);
	}

	private void updateButtonHome(boolean isEnabled){
    this.buttonHome.setEnabled(isEnabled);
    this.updateUI();
	}
	
	public void actionPerformed(ActionEvent e){
		Object buttonSelected = e.getSource();
		//Si entra nell'if se viene premuto il bottone di login
		if(buttonSelected == buttonLogOperation){
				this.observer.changeLoggingStatusClick();
		} else if(buttonSelected == buttonHome){
		  this.observer.homeBtnClick();
		} else if(buttonSelected == buttonPrintReg){
			this.observer.printBtnClick();
		}
	}
	
  @Override
  public void attachViewObserver(MenuBottomViewObserver observer) {
    this.observer = observer;
  }
  
  /**
   * Interface for an observer of the MenuBottomInterface
   * @author Andrea Santi
   *
   */
  public static interface MenuBottomViewObserver {
    void changeLoggingStatusClick();
    void homeBtnClick();
    void printBtnClick();
  }
}