package oop1314.lab06.exam.sol;

import java.util.Date;

/**
 * @author Danilo Pianini
 * 
 */
public interface IPerson extends Comparable<IPerson> {

	/**
	 * @return the date of birth
	 */
	Date getBirthDate();

	/**
	 * @return the code associated to each person
	 */
	int getCode();

	/**
	 * @return the given name
	 */
	String getName();
	
	/**
	 * @return the surname
	 */
	String getSurname();

}
