package acme.exams.model;

import java.io.Serializable;

/**
 * Models a generic professor
 * @author Andrea Santi
 *
 */
public class Professor extends AbstractPerson implements Serializable{

  private String subject;
	private static final long serialVersionUID = 1L;
	
	/**
   * Creats a new Professor with the parameters provided in input 
	 * @param name
	 * @param surname
	 * @param username
	 * @param password
	 * @param subject
	 */
	public Professor(String name, String surname, String username, String password, String subject) {
	  super(username, password, name, surname);
		this.subject = subject;
	}

	/**
	 * Returns the subjected teached by the professor
	 * @return
	 */
	public String getTeacherSubject() {
		return subject;
	}
}