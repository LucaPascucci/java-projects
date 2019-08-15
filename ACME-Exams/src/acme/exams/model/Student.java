package acme.exams.model;

import java.io.Serializable;

/**
 * Models a generic student
 * @author Andrea Santi
 *
 */
public class Student extends AbstractPerson implements Serializable{
	
	private Integer enrollmentId;
	private static final long serialVersionUID = 1L;
	
	/**
   * Creats a new Student with the parameters provided in input 
	 * @param name
	 * @param surname
	 * @param username
	 * @param password
	 * @param enrollmentId
	 */
	public Student(String name, String surname, String username, String password, Integer enrollmentId) {
    super(username, password, name, surname);
    this.enrollmentId = enrollmentId;
	}
	
	/**
	 * Return the student's enrollment id
	 * @return
	 */
	public int getEnrollmentId() {
		return this.enrollmentId;
	}
}