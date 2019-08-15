/**
 * 
 */
package oop1314.lab05.exams.sol;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

import oop1314.lab05.exams.generics.sol.IPeopleManager;
import oop1314.lab05.exams.generics.sol.PeopleManager;
import oop1314.lab05.exams.model.sol.IPerson;
import oop1314.lab05.exams.model.sol.Professor;
import oop1314.lab05.exams.model.sol.Student;
/**
 * @author Danilo Pianini
 *
 */
public final class PeopleManagerTest {
	
	private static final Calendar CALENDAR = Calendar.getInstance();
	private static final int STUD_YEAR = 93;
	
	private PeopleManagerTest() {
	}

	/**
	 * @param args ignored
	 */
	public static void main(final String[] args) {
		/*
		 * 1. Initialize three students, put them within a Collection.
		 */
		final Collection<Student> students = new ArrayList<>();
		CALENDAR.set(STUD_YEAR, Calendar.AUGUST, 16);
		students.add(new Student("Marco", "Marchi", CALENDAR.getTime()));
		CALENDAR.set(STUD_YEAR, Calendar.JANUARY, 8);
		students.add(new Student("Pino", "Lalava", CALENDAR.getTime()));
		CALENDAR.set(STUD_YEAR, Calendar.DECEMBER, 10);
		students.add(new Student("Giovanni", "Galli", CALENDAR.getTime()));
		
		/*
		 * 2. Initialize two professors
		 */
		CALENDAR.set(44, Calendar.MARCH, 16);
		final Professor prof = new Professor("Andrea", "Tanbanni", CALENDAR.getTime());
		CALENDAR.set(69, Calendar.DECEMBER, 28);
		final Professor assistant = new Professor("Lino Benedetto", "Torvaldi", CALENDAR.getTime());
		
		IPeopleManager<IPerson> smanager = new PeopleManager<>();
		smanager.addAllFromCollection(students);
		System.out.println(smanager);
		
		IPeopleManager<IPerson> pmanager = new PeopleManager<>();
		pmanager.add(prof);
		pmanager.add(assistant);
		System.out.println(pmanager);
		
		Collection<Object> coll = new HashSet<>();
		smanager.addAllToCollection(coll);
		pmanager.addAllToCollection(coll);
		System.out.println(coll);
		
	}

}
