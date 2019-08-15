package acme.exams.views.professor;

import acme.exams.views.professor.MenuProfessor.MenuProfessorViewObserver;

/**
 * Interface for the view that represents the main menu of a professor
 * @author Andrea Santi
 *
 */
public interface MenuProfessorViewInterface {
  void attachObserver(MenuProfessorViewObserver observer);
}