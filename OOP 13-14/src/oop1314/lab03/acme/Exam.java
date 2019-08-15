package oop1314.lab03.acme;
import java.util.Arrays;
public class Exam {

	private int id;
	private int nMaxStudents;
	private int nRegisteredStudents;
	private String courseName;
	private Student[] students;
	private Professor professor;
	private ExamRoom room;
	
	public Exam(int id, int nMaxStudents, String nameCourse, Professor professor, ExamRoom room){
		this.id = id;
		this.nMaxStudents = nMaxStudents;
		this.courseName = nameCourse;
		this.professor = professor;
		this.room = room;
		this.students = new Student[nMaxStudents];
		this.nRegisteredStudents = 0;
	}
	
	public int getID(){
		return this.id;
	}
	
	public int getNMaxStudents(){
		return this.nMaxStudents;
	}
	
	public String getCourseName(){
		return this.courseName;
	}
	
	public Student[] getStudents(){
		return this.students;
	}
	
	public Professor getProfessor(){
		return this.professor;
	}
	
	public ExamRoom getRoom (){
		return this.room;
	}
	
	public void registerStudent(Student student){
		if (this.nMaxStudents>nRegisteredStudents){
			this.students[nRegisteredStudents]=student;
			this.nRegisteredStudents++;
		}
	}
	
	public String toString() {
		return "Exam [name=" + this.courseName + ", id=" + this.id + ", nMaxStudents=" + this.nMaxStudents + ", nRegisteredStudents=" + this.nRegisteredStudents +"]"+ '\n' + this.professor.getDescription() + '\n' + this.room.toString() + "\nStudents=" + Arrays.toString(this.students);
	}
}
