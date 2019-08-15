/**
 * 
 */
package oop1314.lab05.exams.model.sol;

import java.util.Date;

/**
 * @author Danilo Pianini
 *
 */
public class Student extends AbstractPerson {
	
	private static int studentIdGenerator = 0;

	/**
	 * @param firstName
	 *            Given name
	 * @param secondName
	 *            Surname
	 * @param dateOfBirth
	 *            Date of Birth
	 */
	public Student(final String firstName, final String secondName, final Date dateOfBirth) {
		super(firstName, secondName, dateOfBirth, studentIdGenerator++);
	}


}
