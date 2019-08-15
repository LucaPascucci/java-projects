/**
 * 
 */
package oop1314.lab05.exams.model.sol;

/**
 * @author Danilo Pianini
 * 
 */
public class Grade implements Comparable<Grade> {

	/**
	 * Maximum grade, and minimum acceptable level.
	 */
	public static final byte MAX_GRADE = 30, PASS_MARK = 18;
	private final boolean cumLaude;
	private final byte grade;

	/**
	 * @param g the grade. If higher than MAX_GRADE, then laude is assigned
	 */
	public Grade(final byte g) {
		this.cumLaude = g > MAX_GRADE;
		this.grade = (byte) Math.max(0, Math.min(g, MAX_GRADE));
	}

	@Override
	public int compareTo(final Grade gr) {
		final int compare = this.grade - gr.grade;
		/*
		 * If they are equal, the cum laude grade is higher.
		 */
		if (compare == 0) {
			if (this.isCumLaude() && !gr.isCumLaude()) {
				return 1;
			} else if (!this.isCumLaude() && gr.isCumLaude()) {
				return -1;
			}
		}
		return compare;
	}

	/**
	 * @return the grade
	 */
	public final byte getGrade() {
		return grade;
	}

	/**
	 * @return true if this grade has a laude
	 */
	public boolean isCumLaude() {
		return cumLaude;
	}

	/**
	 * @return true if the grade is above the pass threshold
	 */
	public boolean isPassed() {
		return this.grade >= PASS_MARK;
	}
	
	@Override
	public String toString() {
		return grade + (isCumLaude() ? "L" : "");
	}

}
