package acme.exams.views.professor;

import acme.exams.views.professor.RegisterProfessor.RegisterProfessorViewObserver;

/**
 *  Interface for the view used for registering a new professor to the system
 * @author Andrea Santi
 *
 */
public interface RegisterProfessorViewInterface {
  void cleanInterface();
  void attachObserver(RegisterProfessorViewObserver observer);
  void displayMsg(String string);
}