package acme.exams.views;

import javax.swing.JPanel;

import acme.exams.views.MainFrame.MainViewObserver;

/**
 * Interface for the main view of the application
 * @author Andrea Santi
 *
 */
public interface MainViewInterface {
  
  /**
   * Replace the central panel of the view with the one provided in input
   * @param panel
   */
  void replaceCentralPanel(JPanel panel);
  
  /**
   * Display an error dialog with the message provided in input
   * @param message
   */
  void showErrorDialog(String message);
  
  /**
   * Returns the bottom menu of the view
   * @return
   */
  MenuBottomInterface getMenuBottom();
  
  /**
   * Attach an observer of the view
   * @param observer
   */
  void attachObserver(MainViewObserver observer);
}