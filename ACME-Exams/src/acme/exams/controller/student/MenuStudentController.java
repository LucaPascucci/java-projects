package acme.exams.controller.student;

import java.util.ArrayList;

import acme.exams.model.IExam;
import acme.exams.model.IModel;
import acme.exams.model.Student;
import acme.exams.views.MainViewInterface;
import acme.exams.views.student.MenuStudentViewInterface;
import acme.exams.views.student.RegistrableExamForStudent;
import acme.exams.views.student.StatisticStudentMarks;
import acme.exams.views.student.StudentExamList;
import acme.exams.views.student.MenuStudent.MenuStudentViewObserver;

/**
 * Controller handling the interaction with the {@link acme.exams.model.Student} main menu view 
 * @author Andrea Santi
 *
 */
public class MenuStudentController implements MenuStudentViewObserver {

  private MainViewInterface mainView;
  private IModel model;
  private MenuStudentViewInterface view;

  /**
   * Creates a new MenuStudentController
   * @param mainView The {@link acme.exams.views.MainViewInterface} to use for changing the
   * current panel displayed
   * @param model The data used by the controller
   */
  public MenuStudentController(MainViewInterface mainView, IModel model) {
    this.mainView = mainView;
    this.model = model;
  }

  /**
   * Sets the {@link acme.exams.views.student.MenuStudentViewInterface} view the controller 
   * has to observe
   * @param msp The {@link acme.exams.views.student.MenuStudentViewInterface} to observe. 
   */
  public void setView(MenuStudentViewInterface msp) {
    this.view = msp;
    this.view.attachObserver(this);
  }
  
  @Override
  public void showExamListCmd() {
    StudentExamList sep = new StudentExamList((Student) model.getCurrentUser(), new ArrayList<IExam>(model.getExams().values()));
    StudentExamListController sec = new StudentExamListController(this.mainView, this.model);
    sec.setView(sep);
    mainView.replaceCentralPanel(sep);
  }

  @Override
  public void showExamDoneListCmd() {
    RegistrableExamForStudent rep = new RegistrableExamForStudent(
        new ArrayList<IExam>(model.getExams().values()), 
        (Student) model.getCurrentUser());
    mainView.replaceCentralPanel(rep);
  }

  @Override
  public void showStudentStatisticsCmd() {
    StatisticStudentMarks smp = new StatisticStudentMarks(model.getExams(), 
        (Student) model.getCurrentUser());
    mainView.replaceCentralPanel(smp);
  }
}