package acme.exams.views.student;

import java.util.List;

import acme.exams.model.IExam;
import acme.exams.views.student.StudentExamList.StudentExamListViewObserver;

/**
 * Interface for the view used to display the list of exams for a student 
 * @author Andrea Santi
 *
 */
public interface StudentExamListViewInterface {
  void attachObserver(StudentExamListViewObserver observer);
  void updateDisplayedExams(List<IExam> exams);
  void displayMsg(String string);
  void refreshView();
}