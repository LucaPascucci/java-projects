package examples.guithree.testo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private int cont = 0;

	final JButton first = new JButton("1");
	final JButton second = new JButton("2");
	final JButton third = new JButton("3");

	public GUI() {
		this.setSize(300, 100);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		JPanel window = new JPanel();
		window.add(this.first);
		window.add(this.second);
		window.add(this.third);
		this.first.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cont = (cont == 0) ? 1 : 0;
			}

		});

		this.second.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cont = (cont == 1) ? 2 : 0;
			}

		});
		this.third.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cont == 2) {
					System.exit(0);
				}
				cont = 0;
			}

		});
		this.getContentPane().add(window);
		this.setVisible(true);
	}
}
