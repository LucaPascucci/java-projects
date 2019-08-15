package acme.exams.views.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Models the main menu view for a professor
 * @author Andrea Santi
 *
 */
public class MenuProfessor extends JPanel implements MenuProfessorViewInterface, ActionListener{

	//Bottoni della classe
	private JButton inserisciAppello;
	private JButton buttonStatisticheNumIscritti;
	private JButton buttonStatistiche;
	private JButton buttonGestioneAppello;
	private MenuProfessorViewObserver observer;
	private static final long serialVersionUID=1;

	/**
	 * Creates a new MenuProfessor
	 */
	public MenuProfessor(){
		//Invocazione del costruttore della classe padre
		super();
		//Copia dei riferimenti del gestoreAppelli e del MainFrame
		this.setLayout(null);
		//Creazione della GUI
		buttonStatistiche = new JButton("Statistiche tipo");
		buttonStatistiche.setBounds(369,234,150,30);
		this.add(buttonStatistiche);
		JLabel lblgestAppello = new JLabel("Visualizza modifica appelli");
		lblgestAppello.setBounds(112,120,231,20);
		JLabel lbltitolo = new JLabel("Menu Docente");
		lbltitolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbltitolo.setBounds(1,40,649,20);
		JLabel lblInsAppello = new JLabel();
		lblInsAppello.setText("Inserisci un nuovo appello");
		lblInsAppello.setBounds(112,180,231,20);
		JLabel lblStatistiche = new JLabel();
		lblStatistiche.setText("Statische sul tipo degli appelli");
		lblStatistiche.setBounds(112,240,230,20);
		JLabel lblStatistiche2 = new JLabel();
		lblStatistiche2.setText("Statistiche iscritti agli appelli");
		lblStatistiche2.setBounds(112,294,230,20);
		
		inserisciAppello = new JButton();
		inserisciAppello.setBounds(369,174,150,30);
		inserisciAppello.setText("Inserisci appello");
		buttonGestioneAppello = new JButton();
		buttonGestioneAppello.setText("Gestione Appelli");
		buttonGestioneAppello.setBounds(369,114,150,30);
		
		this.add(inserisciAppello);
		this.add(lblgestAppello);
		this.add(buttonGestioneAppello);
		this.add(lblInsAppello);
		this.add(lblStatistiche);
		this.add(lblStatistiche2);
		this.add(lbltitolo);
		buttonStatisticheNumIscritti = new JButton("Statistiche iscritti");
		buttonStatisticheNumIscritti.setBounds(369,294,150,30);
		this.add(buttonStatisticheNumIscritti);
		
		//Aggiunta dell'ascoltatore ai vari bottoni
		buttonGestioneAppello.addActionListener(this);
		inserisciAppello.addActionListener(this);
		buttonStatistiche.addActionListener(this);
		buttonStatisticheNumIscritti.addActionListener(this);
	}
	
	public void actionPerformed (ActionEvent e){
		Object buttonPressed = e.getSource();
		/* A seconda del bottone premuto viene caricata nella
		 * parte centrale del mainframe la classe derivata da JPanel che
		 * gestisce l'operazione richiesta dall'utente */
		if(buttonPressed==inserisciAppello){
			this.observer.newExamCmd();
		} else if(buttonPressed==buttonGestioneAppello){
			this.observer.manageExamsCmd();
		} else if(buttonPressed==buttonStatistiche){
			this.observer.showExamsTypeStatisticsCmd();
		} else if(buttonPressed==buttonStatisticheNumIscritti){
			this.observer.showRegisteredStudentsStatisticsCmd();
		}
	}
	
	@Override
  public void attachObserver(MenuProfessorViewObserver observer) {
    this.observer = observer;
  }
	
	/**
	 * Interface for an observer of MenuProfessorViewInterface
	 * @author Andrea Santi
	 *
	 */
	public static interface MenuProfessorViewObserver {
    void newExamCmd();
    void manageExamsCmd();
    void showExamsTypeStatisticsCmd();
    void showRegisteredStudentsStatisticsCmd();
  }
}