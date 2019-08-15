package oop1314.lab09.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import oop1314.lab08.geek.MyFrame;

public class SimpleReactiveGUI extends JPanel implements ActionListener{

  private static final long serialVersionUID = 1L;
  private static final String DEF_FILE_PATH = "data.dat";
  private JButton saveBtn;
  private JButton checksumBtn;
  private JLabel resultLbl;
  private static final Random gen = new Random(10000);
  
  public SimpleReactiveGUI() {
    super(new BorderLayout());
    saveBtn = new JButton("Save");
    saveBtn.setPreferredSize(new Dimension(120, 25));
    checksumBtn = new JButton("Checksum");
    checksumBtn.setPreferredSize(new Dimension(120, 25));
    JPanel btnPanel = new JPanel(new GridBagLayout());
    btnPanel.setBorder(new TitledBorder("Commands"));
    GridBagConstraints cnst = new GridBagConstraints();
    cnst.gridy = 0;
    cnst.insets = new Insets(5, 5, 5, 5);
    cnst.fill = GridBagConstraints.VERTICAL;
    btnPanel.add(saveBtn, cnst);
    cnst.gridy++;
    btnPanel.add(checksumBtn, cnst);

    JPanel lblPanel = new JPanel(new FlowLayout());
    lblPanel.setBorder(new TitledBorder("Output"));
    //lblPanel.setPreferredSize(new Dimension);
    resultLbl = new JLabel("Output");
    lblPanel.add(resultLbl);
    add(btnPanel, BorderLayout.EAST);
    add(resultLbl, BorderLayout.WEST);
    setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

    saveBtn.addActionListener(this);
    checksumBtn.addActionListener(this);
  }

  public static void main(String[] args) {
    //Create and set up the window.
    JFrame frame = new MyFrame("SimpleReactiveGUI", null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Create and set up the content pane.
    JComponent newContentPane = new SimpleReactiveGUI();
    frame.setContentPane(newContentPane);
    //Display the window.
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
  }

  private void saveToFile(long[] data) throws IOException{
    BufferedOutputStream buffOutStream = null;
    DataOutputStream outStream = null;
    try{
      buffOutStream = new BufferedOutputStream(new FileOutputStream(DEF_FILE_PATH));
      outStream = new DataOutputStream(buffOutStream);
      for (long el : data){
        outStream.writeLong(el);
      }
    } finally {
      outStream.close();
    }
  }

  private static long[] createArray(int n){
    long returnValue[] = new long[n];
    for (int i = 0; i < n; i++){
      returnValue[i] = gen.nextLong();
    }
    return returnValue;
  } 
}