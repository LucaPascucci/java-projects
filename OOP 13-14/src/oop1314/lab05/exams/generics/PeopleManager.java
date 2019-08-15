/**
 * 
 */
package oop1314.lab05.exams.generics;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import oop1314.lab05.exams.model.IPerson;

/**
 * @author Danilo Pianini
 * 
 * @param <PersonType>
 */
public class PeopleManager<PersonType extends IPerson> implements IPeopleManager<PersonType> {

	private final Set<PersonType> people = new HashSet<>();

	@Override
	public void add(final PersonType newperson) {
		people.add(newperson);
	}

	@Override
	public void addAllFromCollection(final Collection<PersonType> source) {
		for (final PersonType p : source) {
			people.add(p);
		}
	}

	@Override
	public void addAllToCollection(final Collection<PersonType> destination) {
		for (final PersonType p : people) {
			destination.add(p);
		}
	}

	@Override
	public PersonType getById(final int code) {
		for (final PersonType p : people) {
			if (p.getCode() == code) {
				return p;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (final PersonType p : people) {
			sb.append(p);
			sb.append('\n');
		}
		return sb.toString();
	}

}
