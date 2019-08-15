package acme.exams.controller.student;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import acme.exams.controller.EditExamController;
import acme.exams.exceptions.ExamNotFoundException;
import acme.exams.exceptions.MaxStudentsReachedException;
import acme.exams.exceptions.UserNotFoundException;
import acme.exams.model.IExam;
import acme.exams.model.IModel;
import acme.exams.views.EditExam;
import acme.exams.views.MainViewInterface;
import acme.exams.views.student.StudentExamList.StudentExamListViewObserver;
import acme.exams.views.student.StudentExamListViewInterface;

/**
 * Controller handling the interaction with the view showing the {@link acme.exams.model.Student}'s exams 
 * @author Andrea Santi
 *
 */
public class StudentExamListController implements StudentExamListViewObserver {
  private MainViewInterface mainView;
  private IModel model;
  private StudentExamListViewInterface view;

  /**
   * Creates a new StudentExamListController
   * @param mainView The {@link acme.exams.views.MainViewInterface} to use for changing the
   * current panel displayed
   * @param model The data used by the controller
   */
  public StudentExamListController(MainViewInterface mainView, IModel model) {
    this.mainView = mainView;
    this.model = model;
  }

  /**
   * Sets the {@link acme.exams.views.student.StudentExamListViewInterface} view the controller 
   * has to observe
   * @param sep The {@link acme.exams.views.student.StudentExamListViewInterface} to observe. 
   */
  public void setView(StudentExamListViewInterface sep) {
    this.view = sep;
    this.view.attachObserver(this);
  }

  @Override
  public void searchExamsBetweenDatesCmd(Date startDate, Date endDate) {
    view.updateDisplayedExams(model.getExamsBetweenDates(startDate, endDate));
  }


  @Override
  public void showAllExamsCmd() {
    view.updateDisplayedExams(new ArrayList<IExam>(model.getExams().values()));
  }

  @Override
  public void changeRegistrationStatus(int studentEnrollmentId, String examId) {
    try{
      IExam exam = model.getExam(examId);
      Map<Integer, Integer> marks = exam.getMarks();
      Date now = new Date();
      if (exam.getCloseRegistrationDate().after(now)){
        if (marks.containsKey(studentEnrollmentId)){
          exam.removeStudent(studentEnrollmentId);
          this.view.refreshView();
          this.view.displayMsg("Cancellazione dall'appello effettuata con successo.");
        } else {
          exam.addStudent(studentEnrollmentId);
          this.view.refreshView();
          this.view.displayMsg("Iscrizione all'appello effettuata con successo.");
        }
      } else {
        this.view.displayMsg("Impossibile cambiare lo stato di registrazione, appello chiuso.");
      }
    } catch (ExamNotFoundException ex) {
      view.displayMsg("Esame non trovato");
    } catch (MaxStudentsReachedException ex){
      view.displayMsg("Impossibile registrarsi all'appello, numero massimo di studenti raggiunto");
    } catch (UserNotFoundException ex) {
      view.displayMsg("Impossibile registrarsi all'appello, studente non trovato");
    }
  }

  @Override
  public void displayExamDetails(String examId) {
    try {
      EditExam edp = new EditExam(model.getExam(examId));
      EditExamController edc = new EditExamController(this.mainView, this.model);
      edc.setView(edp);
      edp.setReadOnly();
      mainView.replaceCentralPanel(edp);
    } catch (ExamNotFoundException e) {
      view.displayMsg("Impossibile trovare l'esame da visualizzare");
    }
  }
}