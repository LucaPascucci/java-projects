package acme.exams.views;

import acme.exams.views.LoginPanel.LoginViewObserver;

/**
 * Interface for the login view of the application
 * @author Andrea Santi
 *
 */
public interface LoginViewInterface {
  /**
   * Adds an observer of the view
   * @param observer
   */
  void attachObserver(LoginViewObserver observer);
  /**
   * Clear the view 
   */
  void clearInterface();
}