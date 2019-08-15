package examples.guicounter2_quit.testo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class CounterGUI extends JFrame {

	final Counter c = new Counter(0);
	final JLabel text = new JLabel("Valore: ...");
	final JButton quit = new JButton("Quit");

	public CounterGUI() {
		this.setSize(300, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel window = new JPanel();
		window.add(this.text);
		window.add(this.quit);
		this.quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					c.inc();
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							text.setText("Valore: " + c.getCount());
						}
					});
					try {
						Thread.sleep(10);
					} catch (Exception ex) {
					}
				}

			}

		}).start();

		this.setVisible(true);
	}
}
