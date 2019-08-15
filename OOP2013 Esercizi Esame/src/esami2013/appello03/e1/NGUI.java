package esami2013.appello03.e1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NGUI extends JFrame{

	private JButton[] list;
	private Listener listener = new Listener();
	
	public NGUI(int n){
		if (n<1){
			throw new IllegalArgumentException();
		}
		this.list = new JButton[n];
		this.setSize(700,100);
		
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		JPanel window = new JPanel();
		for (int i = 0; i<n; i++){
			this.list[i] = new JButton(""+i);
			this.list[i].addActionListener(listener);
			this.list[i].setActionCommand(""+i);
			window.add(this.list[i]);
		}
		this.getContentPane().add(window);
		this.setVisible(true);
	}
	
	private class Listener implements ActionListener{

		private int count = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			int click = Integer.parseInt(e.getActionCommand());
			if (count == click){
				count++;
			}else{
				count = 0;
			}
			System.out.println(click +" : "+count);
			if (count == list.length){
				System.exit(0);
			}
		}
		
	}
}
