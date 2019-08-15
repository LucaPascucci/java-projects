package oop1314.lab06.exam;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Danilo Pianini
 * 
 */
public class Course implements ICourse {

	private final Set<Professor> assistants = new HashSet<>();
	private final String name;
	private Professor teacher;
	private final int year;

	/**
	 * @param courseName
	 *            the name for this course
	 * @param courseYear
	 *            the year for this course
	 */
	public Course(final String courseName, final int courseYear) {
		this.name = courseName;
		this.year = courseYear;
	}

	@Override
	public void addAssistant(final Professor p) {
		assistants.add(p);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getYear() {
		return year;
	}

	@Override
	public boolean removeAssistant(final Professor p) {
		return assistants.remove(p);
	}

	@Override
	public void setProfessor(final Professor p) {
		teacher = p;
	}

	@Override
	public String toString() {
		return "Course " + getName() + " " + getYear() + "\nProfessor: " + teacher;
	}

}
