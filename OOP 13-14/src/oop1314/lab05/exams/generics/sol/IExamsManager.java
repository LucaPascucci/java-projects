/**
 * 
 */
package oop1314.lab05.exams.generics.sol;

import java.util.Collection;
import java.util.Date;

import oop1314.lab05.exams.model.sol.ICourse;
import oop1314.lab05.exams.model.sol.IExam;
import oop1314.lab05.exams.model.sol.Student;

/**
 * @author Danilo Pianini
 *
 */
public interface IExamsManager {
	
	/**
	 * Adds a new course.
	 * 
	 * @param course the course to add
	 */
	void addCourse(ICourse course);
	
	/**
	 * Adds a new exam to an existing course.
	 * 
	 * @param course the course to add
	 * @param date the exam's date
	 */
	void addExam(ICourse course, Date date);
	
	/**
	 * Subscribes a collection of students to the next exam of a course.
	 * 
	 * @param s the students to subscribe
	 * @param c the course
	 */
	void subscribeToNextExam(Collection<? extends Student> s, ICourse c);
	
	/**
	 * Subscribes a single student to the next exam of a course.
	 * 
	 * @param s the student to subscribe
	 * @param c the course
	 */
	void subscribeToNextExam(Student s, ICourse c);
	
	/**
	 * @param course the course
	 * @return the next exam for the course
	 */
	IExam getNextExamForCourse(ICourse course);
	
	/**
	 * Prints on screen a list of the students which will participate the next exam of a course.
	 * 
	 * @param course the course
	 */
	void printStudentsForNextExam(ICourse course);
	
	/**
	 * Prints on screen a list of the students which will participate the next exam of a course.
	 * 
	 * @param course the course
	 */
	void printLastExamResults(ICourse course);
	
	/**
	 * Closes an exam. See {@link IExam}.
	 * 
	 * @param exam the exam to close.
	 */
	void closeExam(IExam exam);
	
}
