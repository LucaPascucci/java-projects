/**
 * 
 */
package oop1314.lab05.exams.model;


/**
 * @author Danilo Pianini
 * 
 */
public interface ICourse {

	/**
	 * @param p
	 *            adds an assistant for this course
	 */
	void addAssistant(Professor p);

	/**
	 * @return the name of the course
	 */
	String getName();

	/**
	 * @return the year for this course
	 */
	int getYear();

	/**
	 * @param p
	 *            the assistant to remove
	 * @return true if the assistant was found and removed
	 */
	boolean removeAssistant(Professor p);

	/**
	 * @param p
	 *            the professor for this course
	 */
	void setProfessor(Professor p);

}
