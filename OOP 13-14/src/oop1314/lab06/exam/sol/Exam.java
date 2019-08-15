package oop1314.lab06.exam.sol;


import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Danilo Pianini
 * 
 */
public class Exam implements IExam {

	private final Date date;
	private boolean isClosed = false;
	private final IAssociativeMemory<Student, Grade> map = new AssociativeMemory<>();
	private final Set<Student> students = new HashSet<>();

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
		} else {
			System.out.println("This exam is closed, you cannot add students.");
		}
	}

	@Override
	public void assignGrade(final Student student, final Grade grade) {
		if (students.contains(student)) {
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
		if (this.isClosed() && students.contains(stud)) {
			return map.get(stud);
		}
		System.out.println("This exam is not closed yet, or the student is not in list.");
		return null;
	}

	@Override
	public Collection<Student> getStudents() {
		/*
		 * It is often better to CLONE the internal representation of the
		 * object, if you want to prevent outer classes from messing up your
		 * internal representation.
		 */
		return new HashSet<>(students);
	}

	@Override
	public boolean isClosed() {
		return isClosed;
	}

	@Override
	public SortedSet<Student> sortBySurname() {
		return new TreeSet<>(students);
	}

}
