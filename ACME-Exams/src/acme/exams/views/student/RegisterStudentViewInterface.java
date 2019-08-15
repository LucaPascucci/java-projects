package acme.exams.views.student;

import acme.exams.views.student.RegisterStudent.RegisterStudentViewObserver;

/**
 *  Interface for the view used for registering a new student to the system
 * @author Andrea Santi
 *
 */
public interface RegisterStudentViewInterface {
  void cleanInterface();
  void attachObserver(RegisterStudentViewObserver observer);
  void displayMsg(String string);
}