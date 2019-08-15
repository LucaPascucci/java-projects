package esami2013.appello01bis.e2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private final JButton add = new JButton("Add");
	private final JButton printQuit = new JButton("Print & Quit");
	private final JTextField txt = new JTextField(10);
	final private MyJList<String> list = new MyJList<>();

	public GUI() {
		this.setSize(500, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(this.list, BorderLayout.CENTER);
		JPanel pan = new JPanel(new FlowLayout());
		this.getContentPane().add(pan, BorderLayout.SOUTH);
		pan.add(add);
		pan.add(txt);
		pan.add(printQuit);
		printQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (String s : list.getAll()) {
					System.out.println(s);
				}
				System.exit(0);
			}
		});
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				list.addElement(txt.getText());
			}
		});
		this.setVisible(true);
	}
}
