/**
 * 
 */
package oop1314.lab05.exams.model.sol;

import java.util.Date;

/**
 * @author Danilo Pianini
 * 
 */
public abstract class AbstractPerson implements IPerson {

	private static final byte SHIFT_SIZE = 8;
	private static final int UPPER_MASK = 0xff00ff00, LOWER_MASK = 0x00ff00ff;
	private final Date birthDate;
	private final String name;
	private final String surname;
	private final int uid;

	/**
	 * @param firstName
	 *            Given name
	 * @param secondName
	 *            Surname
	 * @param dateOfBirth
	 *            Date of Birth
	 * @param id
	 *            unique identifier. The subclass is responsible of properly
	 *            initialize it.
	 */
	protected AbstractPerson(final String firstName, final String secondName, final Date dateOfBirth, final int id) {
		this.name = firstName;
		this.surname = secondName;
		this.birthDate = dateOfBirth;
		this.uid = id;
	}

	@Override
	public int compareTo(final IPerson p) {
		return getSurname().compareTo(p.getSurname());
	}

	@Override
	public boolean equals(final Object o) {
		if (o.getClass().equals(this.getClass())) {
			return ((AbstractPerson) o).getCode() == this.getCode();
		}
		return false;
	}

	@Override
	public final Date getBirthDate() {
		return birthDate;
	}

	@Override
	public final int getCode() {
		return uid;
	}

	@Override
	public final String getName() {
		return name;
	}

	@Override
	public final String getSurname() {
		return surname;
	}

	@Override
	public int hashCode() {
		/*
		 * Swap buckets of 8bits, improving the distribution of the ids (hash
		 * sets are more efficient if the values are better distributed).
		 */
		return ((uid >> SHIFT_SIZE) & LOWER_MASK) | ((uid << SHIFT_SIZE) & UPPER_MASK);
	}
	
	@Override
	public String toString() {
		return getCode() + ": " + getSurname() + " " + getName() + " born " + getBirthDate();
	}

}
