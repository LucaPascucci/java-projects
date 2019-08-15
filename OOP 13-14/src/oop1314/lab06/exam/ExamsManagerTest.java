package oop1314.lab06.exam;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

/**
 * @author Danilo Pianini
 *
 */
public final class ExamsManagerTest {
	
	private static final Calendar calendar = Calendar.getInstance();
	private static final int STUD_YEAR = 93;
	
	private ExamsManagerTest() {
	}

	/**
	 * @param args ignored
	 */
	public static void main(final String[] args) {
		/*
		 * 1. Initialize three students, put them within a Collection.
		 */
		final Collection<Student> students = new ArrayList<>();
		calendar.set(STUD_YEAR, Calendar.AUGUST, 16);
		students.add(new Student("Marco", "Marchi", calendar.getTime()));
		calendar.set(STUD_YEAR, Calendar.JANUARY, 8);
		students.add(new Student("Pino", "Lalava", calendar.getTime()));
		calendar.set(STUD_YEAR, Calendar.DECEMBER, 10);
		students.add(new Student("Giovanni", "Galli", calendar.getTime()));
		
		/*
		 * 2. Initialize two professors
		 */
		calendar.set(44, Calendar.MARCH, 16);
		final Professor prof = new Professor("Andrea", "Tanbanni", calendar.getTime());
		calendar.set(69, Calendar.DECEMBER, 28);
		final Professor assistant = new Professor("Lino Benedetto", "Torvaldi", calendar.getTime());
		
		/*
		 * 3. Create a new course, set one professor as teacher, and add the other as assistant.
		 */
		final ICourse oop = new Course("Object Oriented Programming", 2013);
		oop.setProfessor(prof);
		oop.addAssistant(assistant);
		
		/*
		 * 4. Create a new exam manager, add a two exams in different dates for the course
		 */
		final IExamsManager mgr = new ExamsManager();
		mgr.addCourse(oop);
		calendar.set(114, Calendar.JANUARY, 16);
		mgr.addExam(oop, calendar.getTime());
		
		/*
		 * 5. Subscribe the students to the next exam
		 */
		mgr.subscribeToNextExam(students, oop);
		mgr.printStudentsForNextExam(oop);
		
		/*
		 * 6. Assign grades to the students and close the exam.
		 */
		final IExam exam = mgr.getNextExamForCourse(oop);
		for (final Student s : students) {
			exam.assignGrade(s, new Grade((byte) (Math.random() * (Grade.MAX_GRADE + 1))));
		}
		mgr.closeExam(exam);
		
		System.out.println(exam.sortBySurname());
		
		mgr.printLastExamResults(oop);
		
	}

}
