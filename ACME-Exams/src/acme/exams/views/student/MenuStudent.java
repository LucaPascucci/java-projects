package acme.exams.views.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Models the main menu view for a student
 * @author Andrea Santi
 *
 */
public class MenuStudent extends JPanel implements MenuStudentViewInterface, ActionListener{
 	
	//Bottoni della classe
	private JButton buttonVisualizzaAppelli;
	private JButton buttonStatistiche;
	private JButton buttonInserisciVoti;
  private MenuStudentViewObserver observer;
  private static final long serialVersionUID=1;

	public MenuStudent(){
			//Invocazione del costruttore della classe padre
			super();
			this.setLayout(null);
			//Creazione della GUI
			JLabel lblInsVoti = new JLabel("Visualizza voti esami");
			lblInsVoti.setBounds(112,140, 231,20);
			buttonInserisciVoti = new JButton();
			buttonInserisciVoti.setText("Voti");
			buttonInserisciVoti.setBounds(369,134,150,30);
			JLabel lblStatistiche = new JLabel("Visualizza il Grafico delle statistiche");
			lblStatistiche.setBounds(112,260,231,20);
			JLabel lbltitolo = new JLabel("Menu Studente");
			lbltitolo.setBounds(0,75,651,20);
			lbltitolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			JLabel lblVisAppello = new JLabel();
			lblVisAppello.setText("Visualizza gli appelli disponobili");
			lblVisAppello.setBounds(112,200,231,20);
			buttonVisualizzaAppelli = new JButton();
			buttonVisualizzaAppelli.setBounds(369,194,150,30);
			buttonVisualizzaAppelli.setText("Visualizza Appelli");
			buttonStatistiche = new JButton();
			buttonStatistiche.setText("Grafico");
			buttonStatistiche.setBounds(369,254,150,30);
			this.add(buttonVisualizzaAppelli);
			this.add(lblStatistiche);
			this.add(buttonStatistiche);
			this.add(lblVisAppello);
			this.add(lbltitolo);
			this.add(lblInsVoti);
			this.add(buttonInserisciVoti);
			//Aggiunta degli ascoltatori ai vari bottoni
			buttonStatistiche.addActionListener(this);
			buttonVisualizzaAppelli.addActionListener(this);
			buttonInserisciVoti.addActionListener(this);

	}
	 
	public void actionPerformed (ActionEvent e){
		//A seconda del bottone premuto viene caricata nella
		//parte centrale del mainframe la classe derivata da JPanel che
		//gestisce l'operazione richiesta dall'utente
		Object buttonPressed = e.getSource();
		if (buttonPressed==buttonVisualizzaAppelli){
			this.observer.showExamListCmd();
		} else if (buttonPressed==buttonInserisciVoti){
		  this.observer.showExamDoneListCmd();
		} else if (buttonPressed == buttonStatistiche){
		  this.observer.showStudentStatisticsCmd();
		}
	}

  @Override
  public void attachObserver(MenuStudentViewObserver observer) {
    this.observer = observer;
  }

  /**
   * Interface for an observer of MenuStudentViewInterface
   * @author Andrea Santi
   *
   */
	public static interface MenuStudentViewObserver {
    void showExamListCmd();
    void showExamDoneListCmd();
    void showStudentStatisticsCmd();
  }
}
