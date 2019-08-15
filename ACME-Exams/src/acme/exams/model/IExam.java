package acme.exams.model;

import java.util.Date;
import java.util.Map;

import acme.exams.exceptions.MarkNotFoundException;
import acme.exams.exceptions.MaxStudentsReachedException;
import acme.exams.exceptions.UserNotFoundException;

/**
 * Defines an exam
 * @author Andrea Santi
 *
 */
public interface IExam {

  /**
   * Constant indicating no mark for a student for this exam
   */
  static final int NO_MARK = 0;
  
  /**
   * Constant indicating the mark for a studet which has not passed the exam 
   */
  static final int FAILED_EXAM_MARK = -1;

  /**
   * The sufficient mark for the exam 
   */
  static final int MIN_MARK = 18;
  
  /**
   * Assign a mark to the student identified by enrollmentId
   * @param enrollmentId The student id
   * @param mark 
   * @throws UserNotFoundException If the enrollmentId provided is not associated to any student
   */
  void assignMark(Integer enrollmentId, int mark)throws UserNotFoundException;
  
  /**
   * Returns the exam mark for the student identified by enrollmentId
   * @param enrollmentId
   * @return
   * @throws MarkNotFoundException If no mark is associated to the enrollmentId provided
   */
  Integer getMark(Integer enrollmentId) throws MarkNotFoundException;
  
  /**
   * Register a student to the exam
   * @param enrollmentId The student's id 
   * @throws MaxStudentsReachedException If the maximum number of student has been already reached 
   */
  void addStudent(Integer enrollmentId) throws MaxStudentsReachedException;
  
  /**
   * De-register a student from the exam
   * @param enrollmentId The student's id
   * @return A boolean indicating if the removal was successfull or not
   * @throws UserNotFoundException If the enrollmentId provided is not associated to any student
   */
  boolean removeStudent(Integer enrollmentId) throws UserNotFoundException;
  
  /**
   * Returns the marks for all the registerd students
   * @return
   */
  Map<Integer, Integer> getMarks();
  
  /**
   * Returns the professor associated to the exam
   * @return
   */
  Professor getProfessor();
  
  /**
   * Returns the exam location
   * @return
   */
  String getExamLocation();
  
  /**
   * Returns the exam date
   * @return
   */
  Date getDate();
  
  /**
   * Returns the deadline for registering to the exam 
   * @return
   */
  Date getCloseRegistrationDate();
  
  /**
   * Returns the maximum number of student for the exam
   * @return
   */
  int getMaxStudents();
  
  /**
   * Returns the type of the exam
   * @return
   */
  ExamType getExamType();
  
  /**
   * Returns the exam's id
   * @return
   */
  String getId();
  
  /**
   * Return the exam's description
   * @return
   */
  String getDescription();
  
  /**
   * Sets the exam location
   * @param location
   */
  void setExamLocation(String location);
  
  /**
   * Sets the exam's description
   * @param description
   */
  void setDescription(String description);
  
  /**
   * Sets the exam's type
   * @param examType
   */
  void setExamType(ExamType examType);
}