package acme.exams.controller.student;

import acme.exams.exceptions.DuplicatedEnrollmentIdException;
import acme.exams.exceptions.DuplicatedUsernameException;
import acme.exams.model.IModel;
import acme.exams.model.Student;
import acme.exams.views.student.RegisterStudentViewInterface;
import acme.exams.views.student.RegisterStudent.RegisterStudentViewObserver;

/**
 * Controller handling the interaction with the view for registering a new student 
 * @author Andrea Santi
 *
 */
public class RegisterStudentController implements RegisterStudentViewObserver {

  private RegisterStudentViewInterface view;
  private IModel model;

  /**
   * Creates a new RegisterStudentController
   * @param model The data used by the controller
   */
  public RegisterStudentController(IModel model) {
    this.model = model;
  }

  /**
   * Sets the {@link acme.exams.views.student.RegisterStudentViewInterface} view the controller 
   * has to observe
   * @param v The {@link acme.exams.views.student.RegisterStudentViewInterface} to observe. 
   */
  public void setView(RegisterStudentViewInterface v) {
    this.view = v;
    this.view.attachObserver(this);
  }

  @Override
  public void registerCmd(String username, String password, String name,
      String surname, int enrollmentId) {
    //Se non tutti i campi sono stati editati si visualizza il messaggio corrispondente
    if((surname.length()==0) || (name.length()==0) || (username.length()==0) || (password.length()==0)){
      view.displayMsg("Completare tutti i campi.");
    } else {
      try{
        model.addStudent(new Student(name, surname, username, password, enrollmentId));
        view.displayMsg("Iscrizione studente effettuata con successo.");
      } catch(DuplicatedEnrollmentIdException ex){
        view.displayMsg("Numero di matricola duplicato.");
      } catch(DuplicatedUsernameException ex){
        view.displayMsg("Errore username già presente sceglierne un altro.");
      }
    }
  }
}
