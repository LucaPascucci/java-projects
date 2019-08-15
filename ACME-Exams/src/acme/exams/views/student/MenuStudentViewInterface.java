package acme.exams.views.student;

import acme.exams.views.student.MenuStudent.MenuStudentViewObserver;

/**
 * Interface for the view displaying the student main menu
 * @author Andrea Santi
 *
 */
public interface MenuStudentViewInterface {
  void attachObserver(MenuStudentViewObserver observer);
}