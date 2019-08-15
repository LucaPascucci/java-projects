package esami2013.appello02b.e1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class FibGUI extends JFrame{

	private final JButton btn = new JButton("Stop");
	private final JLabel lbl = new JLabel("                                                                 ");
	
	public FibGUI (String file) throws FileNotFoundException{
		
		this.setTitle("FibGUI");
		this.setSize(400,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		JPanel window = new JPanel();
		window.add(lbl);
		window.add(btn);
		this.getContentPane().add(window);
		
		final Worker agent = new Worker(file);
		
		this.btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				agent.setStop();
				btn.setEnabled(false);	
			}
		});
		agent.start();
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private class Worker extends Thread{
		
		private final BigFibonacci fib = new BigFibonacci();
		private PrintStream file;
		private volatile boolean stop = false;
		
		public Worker(String path) throws FileNotFoundException{
			this.file = new PrintStream(path);
		}
		
		public void run(){
			while (!stop){
				final BigInteger big = fib.next();
				SwingUtilities.invokeLater(new Runnable(){
					@Override
					public void run() {
						lbl.setText(""+big);
					}
				});
				file.println(""+big);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			file.close();
		}
		
		public void setStop(){
			this.stop = true;
		}
	}
}
