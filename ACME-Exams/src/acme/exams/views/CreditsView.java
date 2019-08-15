
package acme.exams.views;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class showing the ACME-Exams credits 
 * @author Andrea Santi
 */

public class CreditsView extends JPanel {
	
	private static final long serialVersionUID=1;


	/**
	 * Creates a new CreditsView
	 */
	public CreditsView(){
		//Invocazione del costruttore della classe padre
		super();
		this.setLayout(null);
		this.setSize(650,575);
	
		JLabel lblTitolo = new JLabel();
		lblTitolo.setText("Ecco uno dei realizzatori di ACMEWex");
		lblTitolo.setBounds(15, 25, 621, 35);
		lblTitolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		JLabel lblImmagine = new JLabel(new ImageIcon(CreditsView.class.getResource("/foto.jpg")));
		
		lblImmagine.setBounds(15, 51, 621, 451);
		
		this.add(lblTitolo);
		this.add(lblImmagine);
		this.setVisible(true);
	}
}
