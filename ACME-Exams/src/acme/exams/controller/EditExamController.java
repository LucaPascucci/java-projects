package acme.exams.controller;

import java.util.Date;

import acme.exams.controller.professor.MenuProfessorController;
import acme.exams.exceptions.DateAlreadyUsed;
import acme.exams.exceptions.ExamNotFoundException;
import acme.exams.exceptions.InvalidDateSequenceException;
import acme.exams.model.ExamType;
import acme.exams.model.IModel;
import acme.exams.model.Professor;
import acme.exams.views.EditExam.EditExamViewObserver;
import acme.exams.views.EditExamViewInterface;
import acme.exams.views.MainViewInterface;
import acme.exams.views.professor.MenuProfessor;

/**
 * Controller handling the interaction with the GUI showing an exam detail.
 * @author Andrea Santi
 *
 */
public class EditExamController implements EditExamViewObserver {

  private EditExamViewInterface view;
  private IModel model;
  private MainViewInterface mainView;

  /**
   * Creates a new EditExamController
   * @param mainView The {@link acme.exams.views.MainViewInterface} to use for changing the
   * current panel displayed
   * @param model The data used by the controller
   */
  public EditExamController(MainViewInterface mainView, IModel model) {
    this.mainView= mainView;
    this.model = model;
  }
  
  /**
   * Sets the {@link acme.exams.views.EditExamViewInterface} view the controller 
   * has to observe
   * @param view The {@link acme.exams.views.EditExamViewInterface} to observe. 
   */
    public void setView(EditExamViewInterface view){
    this.view = view;
    this.view.attachObserver(this);
  }

  @Override
  public void saveExamCmd(String description, Date examDate,
      Date endInscrictionDate, ExamType examType, String location,
      int nStudents) {
    try {
      model.addExam(description, examType, examDate, location, endInscrictionDate, nStudents, (Professor) model.getCurrentUser());
      showProfessorMenu();
    } catch (DateAlreadyUsed e) {
      view.displayMsg("Errore è già presente un appello in questa data");
    } catch (InvalidDateSequenceException e) {
      view.displayMsg("Errore la data di chiusura delle registrazioni non può precedere quella dell'esame");      
    }
  }

  @Override
  public void updateExamCmd(String description, ExamType examType,
      String location) {
    try {
      model.updateExam(view.getExamId(), description, examType, location);
      showProfessorMenu();
    } catch (ExamNotFoundException e) {
      view.displayMsg("Errore, impossibile trovare l'esame da aggiornare");      
    }
  }

  private void showProfessorMenu(){
    MenuProfessor mpp = new MenuProfessor();
    MenuProfessorController mpc = new MenuProfessorController(this.mainView, this.model);
    mpc.setView(mpp);
    mainView.replaceCentralPanel(mpp);
  }
}
