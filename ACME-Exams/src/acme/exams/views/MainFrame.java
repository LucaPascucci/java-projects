package acme.exams.views;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Main frame of the application
 * @author Andrea Santi
 *
 */
public class MainFrame extends JFrame implements ActionListener, WindowListener, MainViewInterface {

  private static final String ERROR_STR = "Error";
  private static final int MENU_IDX_EXIT = 2;
  private static final int MENU_IDX_LOAD_FROM_FILE = 1;
  private static final int MENU_IDX_SAVE_FROM_FILE = 0;
  //Dichiarazione campi del mainFrame
  //che contengono tutti i coponenti swing per l'interfaccia grafica
  private static final String APP_TITLE = "ACME-Exams:Il servizio elettronico di gestione degli appelli.";
  private MainViewObserver observer;
  private static final long serialVersionUID=1;	
  private JLabel lblTitle;
  private MenuBottom menuBottom;
  private JMenuItem[] fileMenuItems;
  private JMenuBar bar;
  private JMenu fileMenu;
  private JMenu helpMenu;
  private JMenuItem helpMenuItem;
  private JFileChooser fileDialog;
  
  public MainFrame(){

    super();
    //Si setta la finestra non ridimensionabile
    this.setResizable(false);
    //Set del layout della finestra del tipo borderLayout
    this.setLayout(new BorderLayout());
    //set delle dimensione della finestra
    this.setBounds(200, 90, 650, 575);

    fileDialog = new JFileChooser();
    //Creazione delal label che rappresenta il titolo e la si centra
    lblTitle = new JLabel(APP_TITLE);
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

    Container c = this.getContentPane();
    //Creazione del menuBottom
    this.menuBottom = new MenuBottom();
    //Add della label al north del borderLay
    c.add(lblTitle,BorderLayout.NORTH);
    //Add della menuBottom al south del borderLayout
    c.add(menuBottom,BorderLayout.SOUTH);

    //Creazione del menu
    bar = new JMenuBar();
    //Creazione del file menu
    fileMenu = new JMenu("File");
    //Creazione dell'help menu
    helpMenu = new JMenu("Help");

    //Creazione dei menuITems
    fileMenuItems = new JMenuItem[3];
    fileMenuItems[0] = new JMenuItem("Load data");
    fileMenuItems[1] = new JMenuItem("Save data");
    fileMenuItems[2] = new JMenuItem("Exit");

    helpMenuItem = new JMenuItem("About");

    //Registrazione dell'ascoltatore ad ogni item del menu file
    for (int i = 0; i<3; i++){
      fileMenuItems[i].addActionListener(this);
    }
    //Add dei menuItem al filemenu
    for (int i = 0; i<3; i++){
      fileMenu.add(fileMenuItems[i]);
    }
    //Registrazione dell'ascoltatore anche per l'helpMenuItem
    helpMenuItem.addActionListener(this);
    //Add del helpMenuItem al helpMEnu
    helpMenu.add(helpMenuItem);
    //Add dei menu alla JMenuBar
    bar.add(fileMenu);
    bar.add(helpMenu);
    //Aggiunta della JMenuBar al MainFrame
    this.setJMenuBar(bar);
    //Si fa il set della DefaultCloseOperation in modo che
    //quando viene chiusa la finestra il programma termina la 
    //sua esecuzione
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.addWindowListener(this);
  }

  @Override
  public void replaceCentralPanel(JPanel panel){
    this.resetFrame();
    Container c = this.getContentPane();
    c.add(panel, BorderLayout.CENTER);
    this.repaint();
    panel.updateUI();
  }

  @Override
  public void showErrorDialog(String message){
    JOptionPane.showMessageDialog(this, message, ERROR_STR, JOptionPane.ERROR_MESSAGE);
  }
  
  private void resetFrame(){
    Container c = this.getContentPane();
    c.removeAll();
    c.add(lblTitle,BorderLayout.NORTH);
    c.add(menuBottom,BorderLayout.SOUTH);
  }

  @Override
  public void windowClosing(WindowEvent e){
    this.observer.saveDataCmd();
  }
  @Override
  public void windowOpened(WindowEvent e){
    this.observer.loadDataCmd();	
  }
  
  @Override
  public void windowClosed(WindowEvent e){ }
  @Override
  public void windowIconified(WindowEvent e){ }
  @Override
  public void windowDeiconified(WindowEvent e){ }
  @Override
  public void windowActivated(WindowEvent e){ }
  @Override
  public void windowDeactivated(WindowEvent e){ }

  @Override
  public void actionPerformed(ActionEvent e){
    Object menuSource = e.getSource();
    //Salvataggio su file
    if(menuSource==fileMenuItems[MENU_IDX_SAVE_FROM_FILE]){
      //Si visualizza a video il JFileChooser e si legge la path del file selezionata
      if(this.fileDialog.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
        this.observer.loadDataCmd(this.fileDialog.getSelectedFile().getPath());
      }
    } else if(menuSource==fileMenuItems[MENU_IDX_LOAD_FROM_FILE]){
      /* Caricamento da file, si visualizza a video il 
       * JFileChooser e si legge la path del file selezionata*/
      if(this.fileDialog.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
        this.observer.saveDataCmd(this.fileDialog.getSelectedFile().getPath());
      }			
    } else if(menuSource==fileMenuItems[MENU_IDX_EXIT]){
      /* Uscita dall'applicazione */
      this.observer.exitCmd();
    } else if(menuSource==helpMenuItem){
      this.observer.showCreditsDialogCmd();
    }
  }

  @Override
  public void attachObserver(MainViewObserver observer) {
    this.observer = observer;
  }

  public MenuBottom getMenuBottom() {
    return menuBottom;
  }
 
  /**
   * Interface for an observer of the MainViewInterface view
  * @author Andrea Santi
   *
   */
  public static interface MainViewObserver {

    /**
     * Method invoked when a load command has been triggered by the view 
     * @param path The path from which load the model
     */
    void loadDataCmd(String path);
    
    /**
     * Method invoked when a save command has been triggered by the view 
     * @param path The path to which save the model
     */
    void saveDataCmd(String path);
    
    /**
     * Method invoked when the view triggered an exit command
     */
    void exitCmd();
    
    /**
     * Method invoked when the view triggered a show credits command
     */
    void showCreditsDialogCmd();
    
    /**
     * Method invoked when the view triggered the commad for saving the data
     * in the default path
     */
    void saveDataCmd();
    
    /**
      * Method invoked when the view triggered the commad for loading the data
     * from the default path
    */
    void loadDataCmd();
  }
}