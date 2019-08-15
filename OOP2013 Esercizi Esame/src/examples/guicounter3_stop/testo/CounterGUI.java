package examples.guicounter3_stop.testo;

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
	final JButton btnStart = new JButton("Start");
	final JButton stop = new JButton("Stop");
	final JLabel text = new JLabel("Valore: ");
	final JButton reset = new JButton("Reset");
	private Worker work = new Worker();

	public CounterGUI() {
		this.setSize(300, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		JPanel window = new JPanel();
		window.add(this.btnStart);
		window.add(this.stop);
		window.add(this.reset);
		window.add(this.text);
		this.stop.setEnabled(false);
		this.text.setText("Valore: "+c.getValue());
		this.btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				btnStart.setEnabled(false);
				stop.setEnabled(true);
				new Thread(work).start();
				if (btnStart.getText() == "Riprendi"){
					work.notStop();
					btnStart.setText("Start");
				}
			}
			
		});
		this.stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				work.setStopper();
				stop.setEnabled(false);
				btnStart.setEnabled(true);
				btnStart.setText("Riprendi");
			}

		});
		this.reset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					c.reset();
					text.setText("Valore: " + c.getValue());
			}
			
		});
		this.getContentPane().add(window);
		this.setVisible(true);
	}

	private class Worker extends Thread {
		private volatile boolean stop = false;

		public void run() {
			while (!stop) {
				c.inc();
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						text.setText("Valore: " + c.getValue());
					}

				});
				try {
					Thread.sleep(10);
				} catch (Exception ex) {
				}
			}
		}

		public void notStop() {
			this.stop = false;
			
		}

		public void setStopper() {
			this.stop = true;
		}
	}
}
