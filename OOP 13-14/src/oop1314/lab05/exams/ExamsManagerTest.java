/**
 * 
 */
package oop1314.lab05.exams;

import java.util.Calendar;

import oop1314.lab05.exams.generics.ExamsManager;
import oop1314.lab05.exams.generics.IExamsManager;
import oop1314.lab05.exams.model.Course;
import oop1314.lab05.exams.model.ICourse;
import oop1314.lab05.exams.model.IExam;

/**
 * @author Danilo Pianini
 *
 */
public final class ExamsManagerTest {
	
	private static final Calendar CALENDAR = Calendar.getInstance();
	
	private ExamsManagerTest() {
	}

	/**
	 * @param args ignored
	 */
	public static void main(final String[] args) {
		/*
		 * TODO 1. Initialize three students, put them within a Collection.
		 */
		
		/*
		 * TODO 2. Initialize two professors
		 */
		
		/*
		 * TODO 3. Create a new course, set one professor as teacher, and add the other as assistant.
		 */
		final ICourse oop = new Course("Object Oriented Programming", 2013);
		oop.setProfessor(null);
		oop.addAssistant(null);
		
		/*
		 * TODO 4. Create a new exam manager, add a two exams in different dates for
		 * the course. Look at how calendar is used.
		 */
		final IExamsManager mgr = new ExamsManager();
		mgr.addCourse(oop);
		CALENDAR.set(114, Calendar.JANUARY, 16);
		mgr.addExam(oop, CALENDAR.getTime());
		
		/*
		 * TODO 5. Subscribe the students to the next exam
		 */
		
		mgr.printStudentsForNextExam(oop);
		
		/*
		 * TODO 6. Assign grades to the students and close the exam.
		 */
		final IExam exam = mgr.getNextExamForCourse(oop);
		// Assign grades
		
		mgr.closeExam(exam);
		
		System.out.println(exam.sortBySurname());
		
		mgr.printLastExamResults(oop);
		
	}

}
