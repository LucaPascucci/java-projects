package acme.exams.controller.professor;

import acme.exams.exceptions.DuplicatedUsernameException;
import acme.exams.model.IModel;
import acme.exams.model.Professor;
import acme.exams.views.professor.RegisterProfessorViewInterface;
import acme.exams.views.professor.RegisterProfessor.RegisterProfessorViewObserver;

/**
 * Controller handling the interaction with the view responsible of the registration of new professors. 
 * @author Andrea Santi
 *
 */
public class RegisterProfessorController implements RegisterProfessorViewObserver {

  private RegisterProfessorViewInterface view;
  private IModel model;
  
  /**
   * Creates a new RegisterProfessorController
   * @param model The data used by the controller
   */
  public RegisterProfessorController(IModel model) {
    this.model = model;
  }

  /**
   * Sets the {@link acme.exams.views.professor.RegisterProfessorViewInterface} view the controller 
   * has to observe
   * @param rpv The {@link acme.exams.views.professor.RegisterProfessorViewInterface} to observe. 
   */
  public void setView(RegisterProfessorViewInterface rpv) {
    this.view = rpv;
    this.view.attachObserver(this);
  }
  
  @Override
  public void registerCmd(String username, String password, String name, String surname, String subject){
    //Se non tutti i campi sono stati editati si visualizza il messaggio corrispondente
    if((surname.length()==0) || (name.length()==0) || (subject.length()==0) || (username.length()==0) || (password.length()==0)){
      view.displayMsg("Completare tutti i campi.");
    } else {
      try{
        model.addProfessor(new Professor(name, surname, username, password, subject));
        view.displayMsg("Iscrizione docente effettuata con successo.");
      } catch(DuplicatedUsernameException ex){
        view.displayMsg("Errore username già presente sceglierne un altro.");
      }
    }
  }
}