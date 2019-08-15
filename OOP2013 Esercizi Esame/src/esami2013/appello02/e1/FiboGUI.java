package esami2013.appello02.e1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FiboGUI extends JFrame{
	
	private final String nameFile;
	private final JTextField txtInput = new JTextField(10);
	private final JButton btnStart = new JButton("Start");
	private final JButton btnNext = new JButton("Next");
	private Fibonacci fibio;
	private FileOutputStream fileOutput;
	
	public FiboGUI(String path){
		this.setTitle("Fibonacci");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(350, 100);
		
		nameFile = path;
		this.btnNext.setEnabled(false);
		
		final JPanel window = new JPanel();
		
		window.add(txtInput);
		window.add(btnStart);
		window.add(btnNext);
		
		this.getContentPane().add(window);
		
		btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int value = Integer.parseInt(txtInput.getText());
				fibio = new Fibonacci(value);
				try {
					fileOutput = new FileOutputStream(nameFile);
					DataOutputStream output = new DataOutputStream(fileOutput);
					while (fibio.hasNext()){
						output.writeLong(fibio.next());
					}
					output.writeLong(-1);
					output.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				txtInput.setEditable(false);
				btnStart.setEnabled(false);
				btnNext.setEnabled(true);
			}
			
		});
		
		btnNext.addActionListener(new ActionListener(){
			private DataInputStream input;
			private boolean first = true;
			private long value;
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (first){
						input = new DataInputStream(new FileInputStream(nameFile));
						value = input.readLong();
						first = false;
					}
					btnNext.setText("Next ("+ value +")");
					value = input.readLong();
					if (value==-1){
						btnNext.setEnabled(false);
						input.close();
					}
				}catch (IOException e1) {
					e1.printStackTrace();
					System.exit(0);
				}
				
			}
			
		});
		this.setVisible(true);
		this.setResizable(false);
	}
	
}
