package oop1314.lab03.acme.sol;

import java.util.Arrays;

public class Exam {

  private int id;
  private int nMaxStudents;
  private int nRegisteredStudents; 
  private String courseName;
  
  private Student[] students;
  private Professor professor;
  private ExamRoom room;
  
  public Exam(int id, int nMaxStudents, String courseName, Professor professor, ExamRoom room) {
    this.id = id;
    this.nMaxStudents = nMaxStudents;
    this.nRegisteredStudents = 0;
    this.courseName = courseName;
    this.professor = professor;
    this.room = room;
    this.students = new Student[nMaxStudents];
  }
 
  public void registerStudent(Student stud){
    if (nRegisteredStudents<nMaxStudents){
      students[nRegisteredStudents] = stud;
      nRegisteredStudents++;
    }
  }
  
  public String toString() {
    return "Exam [id=" + this.id + ", nMaxStudents=" + this.nMaxStudents
        + ", nRegisteredStudents=" + this.nRegisteredStudents + ", courseName="
        + this.courseName + ", students=" + Arrays.toString(this.students)
        + ", professor=" + this.professor + ", room=" + this.room.toString() + "]";
  }

  public int getId() {
    return this.id;
  }
  
  public int getNMaxStudents() {
    return this.nMaxStudents;
  }
  
  public int getnRegisteredStudents() {
    return this.nRegisteredStudents;
  }
  
  public String getCourseName() {
    return this.courseName;
  }
  
  public Student[] getStudents() {
    return this.students;
  }
  
  public Professor getProfessor() {
    return this.professor;
  }
  
  public ExamRoom getRoom() {
    return this.room;
  } 
}