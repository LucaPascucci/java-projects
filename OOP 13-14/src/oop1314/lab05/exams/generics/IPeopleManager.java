/**
 * 
 */
package oop1314.lab05.exams.generics;

import java.util.Collection;

import oop1314.lab05.exams.model.IPerson;

/**
 * @author Danilo Pianini
 * 
 * @param <PersonType>
 */
public interface IPeopleManager<PersonType extends IPerson> {

	/**
	 * @param newperson
	 *            the person to add
	 */
	void add(PersonType newperson);

	/**
	 * Copies all the content of a collection within this object.
	 * 
	 * @param source
	 *            the collection to copy from
	 */
	void addAllFromCollection(Collection<PersonType> source);

	/**
	 * Puts the whole content of this manager in a given collection.
	 * 
	 * @param destination
	 *            the collection where to put the content of this manager
	 */
	void addAllToCollection(Collection<PersonType> destination);

	/**
	 * @param code
	 *            the id
	 * @return a person matching the id, if any. null if none is matching.
	 */
	PersonType getById(int code);

}
