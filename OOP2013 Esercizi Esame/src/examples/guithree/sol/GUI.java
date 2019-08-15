package examples.guithree.sol;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	private int state = 0;
	
	public GUI(){
		this.setSize(400,100);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setTitle("Esame");
		this.initPanel();
		this.setVisible(true);
	}
	
	private void initPanel(){
		JPanel panel = new JPanel(new FlowLayout());
		this.getContentPane().add(panel);
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				state = (state == 0) ? 1 : 0;				
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				state = (state == 1) ? 2 : 0;				
			}
		});
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (state == 2){
					System.exit(0);
				}
				state = 0;				
			}
		});
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
	}

}
