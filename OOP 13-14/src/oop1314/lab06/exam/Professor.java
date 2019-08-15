package oop1314.lab06.exam;

import java.util.Date;

/**
 * @author Danilo Pianini
 *
 */
public class Professor extends AbstractPerson {
	
	private static int professorIdGenerator = 0;
	
	/**
	 * @param firstName
	 *            Given name
	 * @param secondName
	 *            Surname
	 * @param dateOfBirth
	 *            Date of Birth
	 */
	public Professor(final String firstName, final String secondName, final Date dateOfBirth) {
		super(firstName, secondName, dateOfBirth, professorIdGenerator++);
	}

}
