package oop1314.lab08.geek;

import java.awt.*;
import javax.swing.*;

/* Specializzazione di JFrame:
 * - Il costruttore accetta titolo e lay-man
 * - Si aggiunge il JPanel
 * - Un metodo getMainPanel() ci dà il pannello
 */
public class MyFrame extends JFrame{
	
  private static final long serialVersionUID = 1L;
  public MyFrame(String title, LayoutManager lm){
		super(title); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320,200);
		// Il lay-man può essere passato al costruttore di JPanel
		this.getContentPane().add(new JPanel(lm));
	}
	
	public JPanel getMainPanel(){
		return (JPanel)this.getContentPane().getComponent(0);
	}
}