package acme.exams.views.professor;

import acme.exams.views.professor.AssignMarks.AssignMarksViewObserver;

/**
 * Interface for the view used by professor for assigning marks to students
 * @author Andrea Santi
 *
 */
public interface AssignMarksViewInterface {
  void attachObserver(AssignMarksViewObserver observer);
  void displayMsg(String string);
  void clearInterface();
  void refreshMarksView();
}