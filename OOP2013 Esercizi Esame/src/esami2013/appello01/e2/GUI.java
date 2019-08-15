package esami2013.appello01.e2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import esami2013.appello01.sol2.PrimeListImpl;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private PrimeListImpl primes = new PrimeListImpl();
	private JButton bnext = new JButton("Next");
	private JLabel lblprime = new JLabel("Prime: 2");
	private JButton bsq = new JButton("Show & Quit");

	public GUI() {

		this.setSize(400, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(bnext);
		this.getContentPane().add(lblprime);
		this.getContentPane().add(bsq);

		this.bnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblprime.setText("Prime: " + primes.next());
			}
		});

		this.bsq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ct = 1;
				for (Integer i : primes) {
					System.out.println("Numero primo in posizione " + (ct)
							+ ": " + i);
					ct++;
				}
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
}
