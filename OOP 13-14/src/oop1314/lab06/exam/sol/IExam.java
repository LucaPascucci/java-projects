package oop1314.lab06.exam.sol;

import java.util.Collection;
import java.util.Date;
import java.util.SortedSet;

/**
 * @author Danilo Pianini
 * 
 */
public interface IExam {

	/**
	 * This method adds a new student to the exam.
	 * 
	 * @param student the student to add
	 */
	void addStudent(Student student);

	/**
	 * If the student is on the list of the exam, this method assigns her a grade.
	 * 
	 * @param student the student
	 * @param grade her grade
	 */
	void assignGrade(Student student, Grade grade);

	/**
	 * Closes the exam. Call this method when the exam is finished.
	 */
	void close();

	/**
	 * @return the date for this exam
	 */
	Date getDate();

	/**
	 * Given a student, returns her grade.
	 * 
	 * @param stud the student
	 * @return the grade
	 */
	Grade getGrade(Student stud);

	/**
	 * @return a collection of the students.
	 */
	Collection<Student> getStudents();

	/**
	 * @return true if the exam is closed.
	 */
	boolean isClosed();

	/**
	 * @return A list of the students, sort by surname
	 */
	SortedSet<Student> sortBySurname();
}
