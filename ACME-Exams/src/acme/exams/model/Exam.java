package acme.exams.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import acme.exams.exceptions.InvalidDateSequenceException;
import acme.exams.exceptions.MarkNotFoundException;
import acme.exams.exceptions.MaxStudentsReachedException;
import acme.exams.exceptions.UserNotFoundException;

/**
 * Models an exam
 * @author Andrea Santi
 *
 */
public class Exam implements Serializable, IExam{

  private String id;
  private String description;
  private ExamType examType;
  private Date date;
  private String location;
  private Date closeRegistrationDate;
  private int maxStudents;
  private Map<Integer, Integer> marks;
  private Professor professor;
  private static final long serialVersionUID=1;

  /**
   * Creates a new exam with the parameters provided in input
   * @param id
   * @param description
   * @param appelloType
   * @param date
   * @param location
   * @param closeRegistrationDate
   * @param maxStudents
   * @param professor
   * @throws InvalidDateSequenceException
   */
  public Exam(String id, String description, ExamType appelloType, Date date, String location, Date closeRegistrationDate, int maxStudents, Professor professor) throws InvalidDateSequenceException {
    if(!date.before(closeRegistrationDate)){
      this.id = id;
      this.description = description;
      this.examType = appelloType;
      this.date = date;
      this.location = location;
      this.closeRegistrationDate = closeRegistrationDate;
      this.maxStudents = maxStudents;
      this.marks = new HashMap<>();
      this.professor = professor;
    } else   {
      throw new InvalidDateSequenceException();
    }
  }

  @Override
  public void addStudent(Integer enrollmentId) throws MaxStudentsReachedException {
    /*Aggiunta nell'hashmap degli iscritti all'appello dello studente passato
    in ingresso con il voto iniziale uguale a zero.*/
    if(this.marks.size()>=this.maxStudents){
      throw new MaxStudentsReachedException();
    }
    this.marks.put(enrollmentId, NO_MARK);
  }
  
  @Override
  public boolean removeStudent(Integer enrollmentId) throws UserNotFoundException {
    if(this.marks.remove(enrollmentId)==null){
      throw new UserNotFoundException();
    } else {
      return true;
    }
  }
  
  @Override
  public void assignMark(Integer enrollmentId, int mark)throws UserNotFoundException {
    if(this.marks.get(enrollmentId)==null){
      throw new UserNotFoundException();
    }
    this.marks.put(enrollmentId, mark);
  }

  @Override
  public Integer getMark(Integer enrollmentId) throws MarkNotFoundException {
    Integer mark = this.marks.get(enrollmentId);
    if(mark==null){
      /* Se non è presente nessun voto per lo username specificato viene lanciata
      la specifica eccezione */
      throw new MarkNotFoundException();
    } else {
      /* Se invece si ha una corrispondenza per lo username in input
      si ritorna il voto individuato da tale id */
      return mark;
    }
  }
  
  @Override
  public Map<Integer, Integer> getMarks() {
    return marks;
  }
  
  @Override
  public Professor getProfessor() {
    return professor;
  }

  @Override
  public String getExamLocation() {
    return location;
  }

  @Override
  public void setExamLocation(String examLocation) {
    this.location = examLocation;
  }

  @Override
  public Date getDate() {
    return date;
  }
  
  @Override
  public Date getCloseRegistrationDate() {
    return closeRegistrationDate;
  }
  
  @Override
  public int getMaxStudents() {
    return maxStudents;
  }
  
  @Override
  public ExamType getExamType() {
    return this.examType;
  }
  
  @Override
  public String getId() {
    return id;
  }
  
  @Override
  public String getDescription(){
    return this.description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public void setExamType(ExamType examType) {
    this.examType = examType; 
  }

  @Override
  public String toString() {
    return description + " " + 
        SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT).format(date) 
        + " Iscritti " + marks.size() +"/" + maxStudents  + " " + location;
  } 
}