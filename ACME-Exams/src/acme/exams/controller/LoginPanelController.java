package acme.exams.controller;

import acme.exams.controller.professor.MenuProfessorController;
import acme.exams.controller.professor.RegisterProfessorController;
import acme.exams.controller.student.MenuStudentController;
import acme.exams.controller.student.RegisterStudentController;
import acme.exams.exceptions.UserNotFoundException;
import acme.exams.model.IModel;
import acme.exams.model.Professor;
import acme.exams.model.Student;
import acme.exams.views.LoginViewInterface;
import acme.exams.views.MainViewInterface;
import acme.exams.views.LoginPanel.LoginViewObserver;
import acme.exams.views.professor.MenuProfessor;
import acme.exams.views.professor.RegisterProfessor;
import acme.exams.views.student.MenuStudent;
import acme.exams.views.student.RegisterStudent;

/**
 * Controller handling the interaction with the login view.
 * @author Andrea Santi
 *
 */
public class LoginPanelController implements LoginViewObserver {

  private MainViewInterface mainView;
  private IModel model;
  private LoginViewInterface view; 
  private static final String ERROR_LOGIN = "No user found with the provided credentials";

  /**
   * Creates a new LoginPanelController
   * @param mainView The {@link acme.exams.views.MainViewInterface} to use for changing the
   * current panel displayed
   * @param model The data used by the controller
   */
  public LoginPanelController(MainViewInterface mainView, IModel model) {
    this.mainView = mainView;
    this.model = model;
  }

  /**
   * Sets the {@link acme.exams.views.LoginViewInterface} view the controller 
   * has to observe
   * @param v The {@link acme.exams.views.LoginViewInterface} to observe. 
   */
  public void setView(LoginViewInterface v) {
    this.view = v;
    this.view.attachObserver(this);
  }

  @Override
  public void doLoginStudentCmd(String username, String password) {
    try{
      Student student = model.getStudent(username);
      if (student.getPassword().equals(password)){
        model.setCurrentUser(student);
        MenuStudent msp = new MenuStudent();
        MenuStudentController msc = new MenuStudentController(this.mainView, this.model);
        msc.setView(msp);
        mainView.replaceCentralPanel(msp);
        mainView.getMenuBottom().setUserLogged();
      } else {
        mainView.showErrorDialog(ERROR_LOGIN);
      }
    } catch (UserNotFoundException ex){
      mainView.showErrorDialog(ERROR_LOGIN);
    }
  }

  @Override
  public void doLoginProfessorCmd(String username, String password) {
    try{
      Professor student = model.getProfessor(username);
      if (student.getPassword().equals(password)){
        model.setCurrentUser(student);
        MenuProfessor mpp = new MenuProfessor();
        MenuProfessorController mpc = new MenuProfessorController(this.mainView, this.model);
        mpc.setView(mpp);
        mainView.replaceCentralPanel(mpp);
        mainView.getMenuBottom().setUserLogged();
      } else {
        mainView.showErrorDialog(ERROR_LOGIN);
      }
    } catch (UserNotFoundException ex){
      mainView.showErrorDialog(ERROR_LOGIN);
    }
  }

  @Override
  public void registerStudent() {
    RegisterStudentController rsc = new RegisterStudentController(this.model);
    RegisterStudent rsv = new RegisterStudent();
    rsc.setView(rsv);
    mainView.replaceCentralPanel(rsv);
  }

  @Override
  public void registerProfessor() {
    RegisterProfessorController rpc = new RegisterProfessorController(this.model);
    RegisterProfessor rpv = new RegisterProfessor();
    rpc.setView(rpv);
    mainView.replaceCentralPanel(rpv);
  }
}
