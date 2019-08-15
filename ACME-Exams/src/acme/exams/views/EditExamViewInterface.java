package acme.exams.views;

import acme.exams.views.EditExam.EditExamViewObserver;

/**
 * Interface for a view allowing to edit and display exam information
 * @author Andrea Santi
 *
 */
public interface EditExamViewInterface {
  
  /**
   * Adds an observer of the view
   * @param observer
   */
  void attachObserver(EditExamViewObserver observer);
  
  /**
   * Clear the view
   */
  void clearInterface();
  
  /**
   * Display a notification message in the view 
   * @param string
   */
  void displayMsg(String string);
  
  /**
   * Retrieves the id of the edited exam
   * @return
   */
  String getExamId();
}