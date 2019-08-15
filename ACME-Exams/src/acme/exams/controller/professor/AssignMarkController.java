package acme.exams.controller.professor;

import acme.exams.exceptions.UserNotFoundException;
import acme.exams.model.IExam;
import acme.exams.views.professor.AssignMarks.AssignMarksViewObserver;
import acme.exams.views.professor.AssignMarksViewInterface;

/**
 * Controller handling the interaction with the view used by a {@link acme.exams.model.Professor} for 
 * assigning marks to students
 * @author Andrea Santi
 *
 */
public class AssignMarkController implements AssignMarksViewObserver {

  private AssignMarksViewInterface view;
  
  /**
   * Creates a new AssignMarkController
   */
  public AssignMarkController() { }

  @Override
  public void assignMark(int enrollmentId, int mark, IExam exam) {
    try {
      exam.assignMark(enrollmentId, mark);
      view.refreshMarksView();
    } catch (UserNotFoundException e) {
      this.view.displayMsg("Utente non trovato");
    }
    this.view.displayMsg("Inserimento voto effettuato con successo");
  }

  /**
   * Sets the {@link acme.exams.views.professor.AssignMarksViewInterface} view the controller 
   * has to observe
   * @param v The {@link acme.exams.views.professor.AssignMarksViewInterface} to observe. 
   */
  public void setView(AssignMarksViewInterface ap) {
    this.view = ap;
    this.view.attachObserver(this);
  }
}
