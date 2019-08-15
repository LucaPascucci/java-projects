package acme.exams.controller.professor;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import acme.exams.controller.EditExamController;
import acme.exams.exceptions.ExamNotFoundException;
import acme.exams.model.IExam;
import acme.exams.model.IModel;
import acme.exams.views.EditExam;
import acme.exams.views.MainViewInterface;
import acme.exams.views.professor.AssignMarks;
import acme.exams.views.professor.ProfessorExamsListViewInterface;
import acme.exams.views.professor.ProfessorExamsList.ProfessorExamsListViewObserver;

/**
 * Controller handling the interaction with the view display the {@link acme.exams.model.Professor}'s exam list 
 * @author Andrea Santi
 *
 */
public class ProfessorExamListController implements ProfessorExamsListViewObserver {

  private MainViewInterface mainView;
  private IModel model;
  private ProfessorExamsListViewInterface view;
  private static final String ERROR_LOAD_DATA = "Error while loading data from disk";
private ObjectInputStream in;

  /**
   * Creates a new ProfessorExamListController
   * @param mainView The {@link acme.exams.views.MainViewInterface} to use for changing the
   * current panel displayed
   * @param model The data used by the controller
   */
  public ProfessorExamListController(MainViewInterface mainView, IModel model) {
    this.mainView = mainView;
    this.model = model;
  }

  /**
   * Sets the {@link acme.exams.views.professor.ProfessorExamsListViewInterface} view the controller 
   * has to observe
   * @param view The {@link acme.exams.views.professor.ProfessorExamsListViewInterface} to observe. 
   */
  public void setView(ProfessorExamsListViewInterface view){
    this.view = view;
    this.view.attachObserver(this);
  }
  
  @Override
  public void editExamCmd(IExam selectedExam) {
    EditExamController edtc = new EditExamController(this.mainView, this.model);
    EditExam edp = new EditExam(selectedExam);
    edtc.setView(edp);
    mainView.replaceCentralPanel(edp);
  }

  @Override
  public void deleteExamCmd(IExam selectedExam) {
    try{
      model.deleteExam(selectedExam.getId());
      view.refreshExamList(model.getExamsForProfessor(model.getCurrentUser().getUsername()));
      view.displayMsg("Eliminazione esame effettuato con successo.");
    }
    catch(ExamNotFoundException ex){
      view.displayMsg("Eliminazione non riuscita,l'appello selezionato non è presente");
    }
  }

  @Override
  public void showExamDetails(IExam selectedExam) {
    EditExamController edtc = new EditExamController(this.mainView, this.model);
    EditExam edp = new EditExam(selectedExam);
    edtc.setView(edp);
    edp.setReadOnly();
    mainView.replaceCentralPanel(edp);
  }

  @Override
  public void insertMarksCmd(IExam selectedExam) {
    if (selectedExam.getMarks().size()!=0){
      AssignMarks ap = new AssignMarks(selectedExam);
      AssignMarkController ac = new AssignMarkController();
      ac.setView(ap);
      mainView.replaceCentralPanel(ap);
    } else {
      view.displayMsg("Impossibile assegnare voti per l'esame: nessun iscritto");
    }
  }

  @Override
  public void saveExamCmd(String path, IExam selectedExam) {
    try{
    	
    	FileOutputStream saveFile = new FileOutputStream (path);
    	ObjectOutputStream save = new ObjectOutputStream (saveFile);
    	save.writeObject(selectedExam);
    	save.close();
    	saveFile.close();
    	
    }catch (Exception e){
    	this.view.displayMsg("File not found at path " + path);
    }
  }

  @Override
  public void loadExamCmd(String path) {
	  try{
          in = new ObjectInputStream(new FileInputStream(path));
          IExam exam = (IExam) in.readObject();
          this.model.addExam(exam);
          view.refreshExamList(model.getExamsForProfessor(model.getCurrentUser().getUsername()));
          /* Closing the stream */
	  } catch(EOFException ex) {
            /* First launch, empty data */
	  } catch(Exception ex) {
          view.displayMsg(ERROR_LOAD_DATA);
	  }
  }
}