package acme.exams.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import acme.exams.exceptions.DateAlreadyUsed;
import acme.exams.exceptions.DuplicatedEnrollmentIdException;
import acme.exams.exceptions.DuplicatedUsernameException;
import acme.exams.exceptions.ExamNotFoundException;
import acme.exams.exceptions.InvalidDateSequenceException;
import acme.exams.exceptions.UserNotFoundException;

/**
 * Class representing the whole data managed by the ACME-Exams application
 * @author Andrea Santi
 *
 */
public class Model implements IModel, Serializable {

  private Map<String, IExam> examMap;
  private Set<Professor> teachers;
  private Set<Student> students;
  private static final long serialVersionUID=1L;
  private IUser currentUsr;

  /**
   * Creates a new Model object 
   */
  public Model(){
    this.examMap = new HashMap<>();
    this.teachers = new TreeSet<>(new PersonComparator());
    this.students = new TreeSet<>(new PersonComparator());
  }

  @Override
  public void addExam(String description, ExamType appelloType, Date date, String location, Date closeRegistrationDate, int maxStudents, Professor professor) throws DateAlreadyUsed, InvalidDateSequenceException {
    IExam examToAdd = new Exam(getNextExamId(), description, appelloType, date, location, closeRegistrationDate, maxStudents, professor); 
    Iterator<IExam> it = this.examMap.values().iterator();
    IExam workingExam;
    Calendar cal = Calendar.getInstance();

    int workingExamDay;
    int workingExamMonth;
    int workingExamYear;

    //Si memorizzano il giorno il mese e l'anno dell'appello
    //da inserire per confrontarli poi con quelli gi' presenti
    cal.setTime(examToAdd.getDate());

    int examToAddDay = cal.get(Calendar.DAY_OF_MONTH);;
    int examToAddMonth = cal.get(Calendar.MONTH);;
    int examToAddYear = cal.get(Calendar.YEAR);;

    while(it.hasNext()){
      workingExam = it.next();
      cal.setTime(workingExam.getDate());
      //Si memorizzano il giorno il mese e l'anno dell'appello corrente
      workingExamDay = cal.get(Calendar.DAY_OF_MONTH);
      workingExamMonth = cal.get(Calendar.MONTH);
      workingExamYear = cal.get(Calendar.YEAR);
      //Controllo tra la data dell'appelo inserito e l'appello corrente
      //se sono uguali viene lanciata l'eccezione.
      if ((examToAddDay==workingExamDay) && (workingExamMonth==examToAddMonth) && (workingExamYear == examToAddYear)) {
        throw new DateAlreadyUsed();
      }
    }
    this.examMap.put(examToAdd.getId(), examToAdd);
  }

  @Override
  public void deleteExam(String examId) throws ExamNotFoundException{
    if(this.examMap.remove(examId)==null){
      throw new ExamNotFoundException();
    }
  }

  
  @Override
  public IExam getExam(String examId) throws ExamNotFoundException{
    IExam exam = this.examMap.get(examId);
    if(exam==null){
      throw new ExamNotFoundException();
    } else{
      return exam;
    }
  }

  @Override
  public void addStudent(Student student) throws DuplicatedEnrollmentIdException, DuplicatedUsernameException{
    Iterator<Student> it = this.students.iterator();
    Student currentStudent;
    while (it.hasNext()) {
      currentStudent = it.next();
      if(currentStudent.getEnrollmentId()==student.getEnrollmentId()){
        //Nel caso la matricola sia già presente si lancia l'eccezione specifica      
        throw new DuplicatedEnrollmentIdException();
      }
      if(currentStudent.getUsername().equals(student.getUsername())){
        //Nel caso l'username sia già presente si lancia l'eccezione specifica
        throw new DuplicatedUsernameException();
      }
    }
    this.students.add(student);
  }

  @Override
  public Student getStudent(String username) throws UserNotFoundException {
    Iterator<Student> it = this.students.iterator();
    Student currentStudent;
    //Ciclo per la ricerca di uno studente con user=username e pass=password
    while(it.hasNext()){
      currentStudent = it.next();
      //Se si entra nell'if abbiamo trovato lo studente cercato e si torna currentStudent
      if(currentStudent.getUsername().equals(username)){
        return currentStudent;
      }
    }
    //Nel caso in cui non sia presente uno studente con i paramentri forniti in ingresso si lancia
    //la specifica eccezione
    throw new UserNotFoundException();
  }

  @Override
  public void addProfessor(Professor teacher)throws DuplicatedUsernameException{
    Iterator<Professor> it = this.teachers.iterator();
    Professor currentTeacher;
    //Ciclo di controllo per verificare che non esista un docente con lo stesso username di
    //teacher
    while (it.hasNext()) {
      currentTeacher = it.next();
      //Se è già presente un docente con lo stesso username si lancia l'eccezione specifica
      if(currentTeacher.getUsername().equals(teacher.getUsername())){
        throw new DuplicatedUsernameException();
      }
    }
    this.teachers.add(teacher);
  }

  @Override
  public Professor getProfessor(String username) throws UserNotFoundException {
    Iterator<Professor> it = this.teachers.iterator();
    Professor currentTeacher;
    //Ciclo per la ricerca di un docente con user=username e pass=password    
    while(it.hasNext()){
      currentTeacher = it.next();
      //Se si entra nell'if si è trovato il docente cercato e perciò si torna currentTeacher
      if(currentTeacher.getUsername().equals(username)){
        return currentTeacher;
      }
    }
    //Nel caso in cui non sia presente un docente con i paramentri forniti in ingresso si lancia
    //la specifica eccezione
    throw new UserNotFoundException();
  }

  @Override
  public Map<String, IExam> getExams() {
    return examMap;
  }

  @Override
  public Set<Professor> getProfessors() {
    return teachers;
  }

  @Override
  public Set<Student> getStudents() {
    return students;
  }

  @Override
  public void updateExam(String examId, String description, ExamType examType, String location) throws ExamNotFoundException{
    if(!this.examMap.containsKey(examId)){
      throw new ExamNotFoundException();
    } else {
      IExam exam = this.examMap.get(examId);
      exam.setExamLocation(location);
      exam.setDescription(description);
      exam.setExamType(examType);
    }
  }

  @Override
  public List<IExam> getExamsForProfessor(String username) {
    List<IExam> returnValue = new ArrayList<>();
    for (IExam exam : examMap.values()){
      if (exam.getProfessor().getUsername().equals(username)){
        returnValue.add(exam);
      }
    }
    return returnValue;
  }

  @Override
  public List<IExam> getExamsBetweenDates(Date startDate,Date endDate) {
    IExam workExam;
    List<IExam> returnValue = new ArrayList<>();
    Iterator<IExam> it = this.examMap.values().iterator();
    //Ciclo di scansione di tutti gli appelli
    while(it.hasNext()){
      workExam  = it.next();
      //Se la data dell'appello è compresa nel range specificato da startDate e endDate
      //la si aggiunge all'hashmap di ritorno
      if(workExam.getDate().after(startDate) && workExam.getDate().before(endDate)){
        returnValue.add(workExam);
      }
    }
    return returnValue;
  }

  /** Utility method for generating exams id **/
  private static String getNextExamId(){
    return UUID.randomUUID().toString();
  }

  private static class PersonComparator implements Comparator<AbstractPerson>, Serializable {
    private static final long serialVersionUID = 1L;
    @Override
    public int compare(AbstractPerson o1, AbstractPerson o2) {
      if (o1.getSurname().compareTo(o2.getSurname())<0) {
        return -1;
      } else if (o1.getSurname().compareTo(o2.getSurname())>0){
        return 1;
      } else {
        return o1.getName().compareTo(o2.getName());
      }
    }
  }

  @Override
  public void setCurrentUser(IUser user) {
    this.currentUsr = user;
  }

  @Override
  public IUser getCurrentUser() {
    return this.currentUsr;
  }

  @Override
  public void addExam(IExam examLoaded) {
    this.examMap.put(examLoaded.getId(), examLoaded);
  }
}