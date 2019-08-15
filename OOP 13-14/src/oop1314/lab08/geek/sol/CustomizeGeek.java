package oop1314.lab08.geek.sol;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CustomizeGeek a demo showing how use check boxes
 */
public class CustomizeGeek extends JPanel implements ItemListener {

  private static final long serialVersionUID = 1L;
  private static final int CHIN_IDX = 0;
  private static final int GLASSES_IDX = 1;
  private static final int HAIR_IDX = 2;
  private static final int TEETH_IDX = 3;
  private static final char CHIN_CHAR = 'c';
  private static final char GLASSES_CHAR = 'g';
  private static final char HAIR_CHAR = 'h';
  private static final char TEETH_CHAR = 't';
  private static final char MISSING_ELEM_CHAR = '-';
  private static final String INITIAL_GEEK_STATUS = "c---";
  private static final String IMAGE_EXTENSION = ".gif";
  private static final String BASE_PATH = "/images/geek/geek-";
  private static final String CHECKBOX_HAS_BEEN_CLICKED_MSG = " checkbox has been clicked";
  private static final String CHIN_STR = "Chin";
  private static final String GLASSES_STR = "Glasses";
  private static final String HAIR_STR = "Hair";
  private static final String TEETH_STR = "Teeth";
  
  private JCheckBox chinCheckBox;
  private JCheckBox glassesCheckBox;
  private JCheckBox hairCheckBox;
  private JCheckBox teethCheckBox;
  private JLabel pictureLabel;

  /*
   * Four accessory choices provide for 16 different
   * combinations. The image for each combination is
   * contained in a separate image file whose name indicates
   * the accessories. The filenames are "geek-XXXX.gif"
   * where XXXX can be one of the following 16 choices.
   * The "choices" StringBuffer contains the string that
   * indicates the current selection and is used to generate
   * the file name of the image to display.

       ----             //zero accessories

       c---             //one accessory
       -g--
       --h-
       ---t

       cg--             //two accessories
       c-h-
       c--t
       -gh-
       -g-t
       --ht

       -ght             //three accessories
       c-ht
       cg-t
       cgh-

       cght             //all accessories
   */

  private StringBuffer choices;

  public CustomizeGeek() {
    super(new BorderLayout());

    //Create the check boxes.
    chinCheckBox = new JCheckBox("Chin");
    chinCheckBox.setSelected(true);

    glassesCheckBox = new JCheckBox("Glasses");
    glassesCheckBox.setSelected(false);

    hairCheckBox = new JCheckBox("Hair");
    hairCheckBox.setSelected(false);

    teethCheckBox = new JCheckBox("Teeth");
    teethCheckBox.setSelected(false);

    //Register a listener for the check boxes.
    chinCheckBox.addItemListener(this);
    glassesCheckBox.addItemListener(this);
    hairCheckBox.addItemListener(this);
    teethCheckBox.addItemListener(this);
    
    //Indicates what's on the geek.
    choices = new StringBuffer(INITIAL_GEEK_STATUS);

    //Set up the picture label
    pictureLabel = new JLabel();
    pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));
    updatePicture();

    //Put the check boxes in a column in a panel
    JPanel checkPanel = new JPanel(new GridLayout(0, 1));
    checkPanel.add(chinCheckBox);
    checkPanel.add(glassesCheckBox);
    checkPanel.add(hairCheckBox);
    checkPanel.add(teethCheckBox);
    
    add(checkPanel, BorderLayout.WEST);
    add(pictureLabel, BorderLayout.EAST);
    setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
  }

  /** Listens to the check boxes. */
  public void itemStateChanged(ItemEvent e) {
    int index = 0;
    char c = MISSING_ELEM_CHAR;
    Object source = e.getItemSelectable();

    if (source == chinCheckBox) {
      index = CHIN_IDX;
      c = CHIN_CHAR;
      System.out.println(CHIN_STR + CHECKBOX_HAS_BEEN_CLICKED_MSG);
    } else if (source == glassesCheckBox) {
      index = GLASSES_IDX;
      c = GLASSES_CHAR;
      System.out.println(GLASSES_STR + CHECKBOX_HAS_BEEN_CLICKED_MSG);
    } else if (source == hairCheckBox){
      index = HAIR_IDX;
      c = HAIR_CHAR;
      System.out.println(HAIR_STR + CHECKBOX_HAS_BEEN_CLICKED_MSG);
    } else {
      index = TEETH_IDX;
      c = TEETH_CHAR;
      System.out.println(TEETH_STR + CHECKBOX_HAS_BEEN_CLICKED_MSG);
    }

    
    //Now that we know which button was pushed, find out
    //whether it was selected or deselected.
    if (e.getStateChange() == ItemEvent.DESELECTED) {
      c = '-';
    }
    //Apply the change to the string.
    choices.setCharAt(index, c);
    updatePicture();
  }

  private void updatePicture() {
    //Get the icon corresponding to the image.
    ImageIcon icon = null;
    String imgPath = BASE_PATH + choices.toString() + IMAGE_EXTENSION;
    /* loading the image from the class */
    java.net.URL imgURL = CustomizeGeek.class.getResource(BASE_PATH+ choices.toString() + IMAGE_EXTENSION);
    if (imgURL != null) {
      icon = new ImageIcon(imgURL);
      pictureLabel.setIcon(icon);
      pictureLabel.setText(null);
    } else {
      System.err.println("Couldn't find file: " + imgPath);
      pictureLabel.setText("Missing Image");
    }
  }

  public static void main(String[] args) {
    //Create and set up the window.
    JFrame frame = new MyFrame("Customize your geek!", null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    JComponent newContentPane = new CustomizeGeek();
    frame.setContentPane(newContentPane);

    //Display the window.
    frame.setVisible(true);
  }
}