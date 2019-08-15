package acme.exams.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import acme.exams.controller.professor.MenuProfessorController;
import acme.exams.controller.student.MenuStudentController;
import acme.exams.model.IModel;
import acme.exams.model.IUser;
import acme.exams.model.Student;
import acme.exams.views.CreditsView;
import acme.exams.views.LoginPanel;
import acme.exams.views.MainFrame;
import acme.exams.views.MainViewInterface;
import acme.exams.views.MenuBottom;
import acme.exams.views.MenuBottomInterface;
import acme.exams.views.professor.MenuProfessor;
import acme.exams.views.student.MenuStudent;

/**
 * Class implementing the main ACME-Exams controller. It handles the commands related to
 * saving/loading data from the file systems and create when needed the sub-controller
 * required for managing specific GUI of the application. 
 * @author Andrea Santi
 *
 */
public class Controller implements MainFrame.MainViewObserver, MenuBottom.MenuBottomViewObserver {

  private IModel model;
  private  MainViewInterface mainView;
  private static final String DEFAULT_SAVE_PATH = "data.dat";
  private static final String ERROR_SAVE_DATA = "Error while saving data to disk";
  private static final String ERROR_LOAD_DATA = "Error while loading data from disk";

  /**
   * Constructs a new Controller given the {@link acme.exams.model.IModel} provided in input
   * @param model The data used by the controller
   */
  public Controller(IModel model){
    this.model = model;
  }

  @Override
  public void exitCmd() {
    /* Closing the application */
    System.exit(0);
  }

  @Override
  public void showCreditsDialogCmd() {
    CreditsView fp = new CreditsView();
    this.mainView.replaceCentralPanel(fp);
  }

  @Override
  public void saveDataCmd() {
    this.doSaveData(DEFAULT_SAVE_PATH);
  }

  @Override
  public void saveDataCmd(String path) {
    this.doSaveData(path);
  }

  /** Utility method for serializing the model to the file system **/
  private void doSaveData(String path){
    try{
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
      /* Writing the model to disk */ 
      out.writeObject(model);
      out.close();
    } catch(IOException ex) {
      this.mainView.showErrorDialog(ERROR_SAVE_DATA);
    }
  }

  @Override
  public void loadDataCmd() {
    this.doLoadData(DEFAULT_SAVE_PATH);
  }

  @Override
  public void loadDataCmd(String path) {
    this.doLoadData(path);
  }

  /** Utility method for loading the model from the file system **/
  private void doLoadData(String path) {
    try{
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
      this.model = (IModel)in.readObject();
      /* Closing the stream */ 
      in.close();
    } catch(EOFException ex) {
      /* First launch, empty data */
    } catch(Exception ex) {
      this.mainView.showErrorDialog(ERROR_LOAD_DATA);
    }
  }

  @Override
  public void homeBtnClick() {
    IUser currUsr = this.model.getCurrentUser();
    if (currUsr!=null){
      if (currUsr instanceof Student){
        MenuStudent msp = new MenuStudent();
        MenuStudentController msc = new MenuStudentController(this.mainView, this.model);
        msc.setView(msp);
        this.mainView.replaceCentralPanel(msp);
      } else {
        MenuProfessor mpp = new MenuProfessor();
        MenuProfessorController mpc = new MenuProfessorController(this.mainView, this.model);
        mpc.setView(mpp);
        mainView.replaceCentralPanel(mpp);
      }
    }
  }

  @Override
  public void changeLoggingStatusClick(){
    if (this.model.getCurrentUser()!=null){
      this.model.setCurrentUser(null);
      createLoginPanel();
      mainView.getMenuBottom().setUserNotLogged();
    } else {
      createLoginPanel();
    }
  }
  
  public void printBtnClick(){
	  try{
	      ObjectInputStream in = new ObjectInputStream(new FileInputStream(DEFAULT_SAVE_PATH));
	      this.model = (IModel)in.readObject();
	      System.out.println("Nome Utente: " + this.model.getCurrentUser().getUsername().toString());
	      System.out.println("Password: " + this.model.getCurrentUser().getPassword().toString());
	      in.close();
	  } catch(EOFException ex) {
	      /* First launch, empty data */
	  } catch(Exception ex) {
	      this.mainView.showErrorDialog(ERROR_LOAD_DATA);
	    }
	  
  }

  /**
   * Sets the {@link acme.exams.views.MainViewInterface} view the controller 
   * has to observe
   * @param v The {@link acme.exams.views.MainViewInterface} to observe. 
   */
  public void setView(MainViewInterface v) {
    this.mainView = v;
    this.mainView.attachObserver(this);
    MenuBottomInterface menuBottom = this.mainView.getMenuBottom();
    menuBottom.attachViewObserver(this);
    createLoginPanel();
  }

  /** Utility method for creating the main login panel **/
  private void createLoginPanel(){
    LoginPanel lp = new LoginPanel();
    LoginPanelController lpc = new LoginPanelController(this.mainView, this.model);
    lpc.setView(lp);
    this.mainView.replaceCentralPanel(lp);
  }
}