package it.unibo.apice.oop.p16concurrency1;

import javax.swing.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener {

  public MyFrame(){
    super("Test Swing thread");
    setSize(100,50);
    JButton button = new JButton("test");
    button.addActionListener(this);
    getContentPane().add(button);
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent ev){
        System.exit(-1);
      }
    });
  }

  public void actionPerformed(ActionEvent ev){
	  while(true){}
  }
}

public class TestSwingThread {
  static public void main(String[] args){
    new MyFrame().setVisible(true);
    new MyFrame().setVisible(true);
  }
  
}
