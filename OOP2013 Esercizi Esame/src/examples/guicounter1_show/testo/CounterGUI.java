package examples.guicounter1_show.testo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CounterGUI extends JFrame {

	final JButton print = new JButton("print");
	final JLabel lbl = new JLabel("Valore: ...");
	final Counter c = new Counter(0);

	public CounterGUI() {
		this.setSize(300, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panAdd = new JPanel();
		panAdd.add(this.print);
		panAdd.add(this.lbl);
		this.getContentPane().add(panAdd);
		this.print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setText("Valore: " + c.getCount());
			}

		});
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					c.inc();
					try {
						Thread.sleep(10);
					} catch (Exception e) {
					}
				}
			}

		}).start();
		this.setVisible(true);
	}
}
