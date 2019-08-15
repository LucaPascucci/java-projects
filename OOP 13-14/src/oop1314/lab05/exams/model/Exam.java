/**
 * 
 */
package oop1314.lab05.exams.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import oop1314.lab05.exams.generics.AssociativeMemory;
import oop1314.lab05.exams.generics.IAssociativeMemory;

/**
 * @author Danilo Pianini
 * 
 */
public class Exam implements IExam {

	private final Date date;
	private boolean isClosed = false;
	private final IAssociativeMemory<Student, Grade> map = new AssociativeMemory<>();
	private Set<Student> students;
	/*
	 * TODO 1. Create a new field, a Set that will contain the students
	 */

	/**
	 * @param examDate
	 *            the date for this exam
	 */
	public Exam(final Date examDate) {
		this.date = examDate;
	}

	@Override
	public void addStudent(final Student student) {
		if (!isClosed()) {
			students.add(student);
			/*
			 * TODO 2. Add the student to the set;
			 */
		} else {
			System.out.println("This exam is closed, you cannot add students.");
		}
	}

	@Override
	public void assignGrade(final Student student, final Grade grade) {
		if (true == students.contains(student)
		/*
		* TODO 3. If the student is included in the set
		*/
		) {
			map.put(student, grade);
		} else {
			System.out.println(student + " is not in this exam's list ");
		}
	}

	@Override
	public void close() {
		isClosed = true;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public Grade getGrade(final Student stud) {
		if (this.isClosed() && (true == students.contains(stud))
				/*
				 * TODO 4. and if the student is in the exam's list
				 */
				) {
			return map.get(stud);
		}
		System.out.println("This exam is not closed yet, or the student is not in list.");
		return null;
	}

	@Override
	public Collection<Student> getStudents() {
		
		/*
		 * TODO 5. Return a COPY of the internal Set.
		 * 
		 * It is often better to CLONE the internal representation of the
		 * object, if you want to prevent outer classes from messing up your
		 * internal representation.
		 */
		return new HashSet<>(this.students);
	}

	@Override
	public boolean isClosed() {
		return isClosed;
	}

	@Override
	public SortedSet<Student> sortBySurname() {
		/*
		 * TODO 6. Use a TreeSet to sort the students.
		 * 
		 * You do not need to manually write a sort method: according to the
		 * Javadoc for ThreeSet (check it out!), this data structure
		 * automatically sorts elements when they're added. In order to do so,
		 * the elements must implement Comparable<T>, which specifies a int
		 * compareTo(T) method, which is used to determine an ordering between
		 * the current object and the one passed. In fact, you will implement
		 * Comparable in the next exercise, and everything will work smoothly.
		 */
		return new TreeSet<>(this.students);
	}

}
