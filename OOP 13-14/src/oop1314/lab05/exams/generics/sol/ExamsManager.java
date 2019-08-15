/**
 * 
 */
package oop1314.lab05.exams.generics.sol;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import oop1314.lab05.exams.model.sol.Exam;
import oop1314.lab05.exams.model.sol.ICourse;
import oop1314.lab05.exams.model.sol.IExam;
import oop1314.lab05.exams.model.sol.Student;

/**
 * @author Danilo Pianini
 * 
 */
public class ExamsManager implements IExamsManager {

	private final IAssociativeMemory<ICourse, List<IExam>> map = new AssociativeMemory<>();

	@Override
	public void addCourse(final ICourse course) {
		map.put(course, new LinkedList<IExam>());
	}

	@Override
	public void addExam(final ICourse course, final Date date) {
		map.get(course).add(new Exam(date));
	}

	@Override
	public void closeExam(final IExam exam) {
		exam.close();
	}

	private IExam findLastClosedExam(final ICourse c) {
		IExam lastOpen = null;
		for (IExam exam : map.get(c)) {
			if (exam.isClosed()) {
				lastOpen = exam;
			} else {
				break;
			}
		}
		return lastOpen;
	}

	private IExam findNextOpenExam(final ICourse c) {
		for (IExam exam : map.get(c)) {
			if (!exam.isClosed()) {
				return exam;
			}
		}
		return null;
	}

	@Override
	public IExam getNextExamForCourse(final ICourse course) {
		return findNextOpenExam(course);
	}

	@Override
	public void printLastExamResults(final ICourse course) {
		final IExam exam = findLastClosedExam(course);
		for (final Student stud : exam.getStudents()) {
			System.out.println(stud + " got " + exam.getGrade(stud));
		}
	}

	@Override
	public void printStudentsForNextExam(final ICourse course) {
		for (final Student stud : getNextExamForCourse(course).getStudents()) {
			System.out.println(stud);
		}
	}

	@Override
	public void subscribeToNextExam(final Collection<? extends Student> s, final ICourse c) {
		for (final Student student : s) {
			this.subscribeToNextExam(student, c);
		}
	}

	@Override
	public void subscribeToNextExam(final Student s, final ICourse c) {
		final IExam exam = findNextOpenExam(c);
		if (exam == null) {
			System.out.println("No open exam available for " + c);
		} else {
			exam.addStudent(s);
		}
	}

}
