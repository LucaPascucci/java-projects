package acme.exams.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import acme.exams.exceptions.DateAlreadyUsed;
import acme.exams.exceptions.DuplicatedEnrollmentIdException;
import acme.exams.exceptions.DuplicatedUsernameException;
import acme.exams.exceptions.ExamNotFoundException;
import acme.exams.exceptions.InvalidDateSequenceException;
import acme.exams.exceptions.UserNotFoundException;

/**
 * Defines the model (w.r.t. the MVC pattern) of the ACME-Exams application
 * @author Andrea Santi
 *
 */
public interface IModel {

  /**
   * Add an exam to the model
   * @param description
   * @param appelloType
   * @param date
   * @param location
   * @param closeRegistrationDate
   * @param maxStudents
   * @param professor
   * @throws DateAlreadyUsed
   * @throws InvalidDateSequenceException
   */
  void addExam(String description, ExamType appelloType, Date date, String location, Date closeRegistrationDate, int maxStudents, Professor professor) throws DateAlreadyUsed, InvalidDateSequenceException;
  
  /**
   * Updates an existing exam
   * @param examId
   * @param description
   * @param examType
   * @param location
   * @throws ExamNotFoundException
   */
  void updateExam(String examId, String description, ExamType examType, String location) throws ExamNotFoundException;
  
  /**
   * Returns the exam with id=examId 
   * @param examId
   * @return
   * @throws ExamNotFoundException
   */
  IExam getExam(String examId) throws ExamNotFoundException;
  
  /**
   * Deletes the exam with id=examId
   * @param examId
   * @throws ExamNotFoundException
   */
  void deleteExam(String examId) throws ExamNotFoundException;
  
  /**
   * Registers a new Student
   * @param student
   * @throws DuplicatedEnrollmentIdException
   * @throws DuplicatedUsernameException
   */
  void addStudent(Student student) throws DuplicatedEnrollmentIdException, DuplicatedUsernameException;
  
  /**
   * Returns the student with the username provided in input
   * @param username
   * @return
   * @throws UserNotFoundException
   */
  Student getStudent(String username) throws UserNotFoundException;
  
  /**
   * Registers a new professor
   * @param teacher
   * @throws DuplicatedUsernameException
   */
  void addProfessor(Professor teacher) throws DuplicatedUsernameException;
  
  /**
   * Returns the professor with the username provided in input
   * @param username
   * @return
   * @throws UserNotFoundException
   * @return
   * @throws UserNotFoundException
   */
  Professor getProfessor(String username) throws UserNotFoundException;
  
  /**
   * Returns the list of stored exams
   * @return
   */
  Map<String, IExam> getExams();
  
  /**
   * Returns the list of the registered professors
   * @return
   */
  Set<Professor> getProfessors();
  
  /**
   * Returns the list of the registered students
   * @return
   */
  Set<Student> getStudents();

  /**
   * Returns the list of exams between the two dates provided in input  
   * @param startDate
   * @param endDate
   * @return
   */
  List<IExam> getExamsBetweenDates(Date startDate,Date endDate);
  
  /**
   * Returns the list of exams for a professor 
   * @param username
   * @return
   */
  List<IExam> getExamsForProfessor(String username);
  
  /**
   * Set the current user working with the application
   * @param user
   */
  void setCurrentUser(IUser user);
  
  /**
   * Returns the current user working with the application
   * @return
   */
  IUser getCurrentUser();
  
  /**
   * Adds a new exam to the model
   * @param examLoaded
   */
  void addExam(IExam examLoaded);
}