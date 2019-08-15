package acme.exams.views.professor;

import java.util.List;

import acme.exams.model.IExam;
import acme.exams.views.professor.ProfessorExamsList.ProfessorExamsListViewObserver;

/**
 * Interface for the view used to display the list of exams for a professor
 * @author Andrea Santi
 *
 */
public interface ProfessorExamsListViewInterface {
  void refreshExamList(List<IExam> exams);
  void attachObserver(ProfessorExamsListViewObserver observer);
  void displayMsg(String string);
}