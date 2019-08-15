package acme.exams.controller.professor;

import acme.exams.controller.EditExamController;
import acme.exams.model.IModel;
import acme.exams.views.EditExam;
import acme.exams.views.MainViewInterface;
import acme.exams.views.professor.ExamTypesGraph;
import acme.exams.views.professor.MenuProfessor.MenuProfessorViewObserver;
import acme.exams.views.professor.MenuProfessorViewInterface;
import acme.exams.views.professor.ProfessorExamsList;
import acme.exams.views.professor.RegisteredStudentsForExamGraph;

/**
 * Controller handling the interaction with the {@link acme.exams.model.Professor} main menu view 
 * @author Andrea Santi
 *
 */
public class MenuProfessorController implements MenuProfessorViewObserver {

  private MenuProfessorViewInterface view;
  private MainViewInterface mainView;
  private IModel model;
  
  /**
   * Creates a new MenuProfessorController
   * @param mainView The {@link acme.exams.views.MainViewInterface} to use for changing the
   * current panel displayed
   * @param model The data used by the controller
   */
  public MenuProfessorController(MainViewInterface mainView, IModel model) {
    this.mainView = mainView;
    this.model = model;
  }

  @Override
  public void newExamCmd() {
    EditExam ev = new EditExam(null);
    EditExamController ec = new EditExamController(this.mainView, this.model);
    ec.setView(ev);
    mainView.replaceCentralPanel(ev);
  }

  @Override
  public void manageExamsCmd() {
    ProfessorExamsList examsPanel = new ProfessorExamsList(
        model.getExamsForProfessor(model.getCurrentUser().getUsername()));
    ProfessorExamListController examsPanelController = new ProfessorExamListController(this.mainView, this.model);
    examsPanelController.setView(examsPanel);
    mainView.replaceCentralPanel(examsPanel);
  }

  @Override
  public void showExamsTypeStatisticsCmd() {
    ExamTypesGraph p = new ExamTypesGraph(model.getExamsForProfessor(model.getCurrentUser().getUsername()));
    mainView.replaceCentralPanel(p);
  }

  @Override
  public void showRegisteredStudentsStatisticsCmd() {
    RegisteredStudentsForExamGraph p = new RegisteredStudentsForExamGraph(model.getExamsForProfessor(model.getCurrentUser().getUsername()));
    mainView.replaceCentralPanel(p);
  }

  /**
   * Sets the {@link acme.exams.views.professor.MenuProfessorViewInterface} view the controller 
   * has to observe
   * @param v The {@link acme.exams.views.professor.MenuProfessorViewInterface} to observe. 
   */
  public void setView(MenuProfessorViewInterface mpp) {
    this.view = mpp;
    this.view.attachObserver(this);
  }
}
