package esami2013.appello03b.e1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class CGUI extends JFrame{
	
	private static int UP = 1;
	private static int DOWN = -1;
	
	private final JButton btnUp = new JButton("Up");
	private final JButton btnDown = new JButton("Down");
	private final JButton btnStop = new JButton("Stop");
	private final JLabel lbl = new JLabel();
	private final Worker work = new Worker();
	
	public CGUI(){
		this.setSize(400,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.btnUp.setEnabled(false);
		
		this.btnUp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				work.change(UP);
				btnUp.setEnabled(false);
				btnDown.setEnabled(true);
			}
			
		});
		
		this.btnDown.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				work.change(DOWN);
				btnUp.setEnabled(true);
				btnDown.setEnabled(false);
			}
			
		});
		
		this.btnStop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				work.setStop();
				btnUp.setEnabled(false);
				btnDown.setEnabled(false);
				btnStop.setEnabled(false);
			}
			
		});
		
		JPanel window = new JPanel();
		window.add(this.lbl);
		window.add(this.btnUp);
		window.add(this.btnDown);
		window.add(this.btnStop);
		
		this.getContentPane().add(window);
		this.setVisible(true);
		this.setResizable(false);
		this.work.start();
		
	}
	
	private class Worker extends Thread{
		
		private volatile int incDec = UP;
		private volatile boolean stop = false;
		private int count;
		
		public void run(){
			while (!this.stop){
				SwingUtilities.invokeLater(new Runnable(){

					@Override
					public void run() {
						lbl.setText(""+count);
						if (incDec == UP){
							count++;
						}else{
							count--;
						}
					}
				});
				try {
					Worker.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void change(int value){
			this.incDec = value;
		}
		
		public void setStop(){
			this.stop = true;
		}
	}
}
