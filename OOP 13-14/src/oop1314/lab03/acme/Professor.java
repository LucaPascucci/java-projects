package oop1314.lab03.acme;
import java.util.Arrays;
public class Professor implements IUser{

	private static final String DOT = ".";
	private String name;
	private String surname;
	private int id;
	private String password;
	private String[] courses;
	
	public Professor (int id, String name, String surname, String password, String[] courses){
	    this.id = id;
	    this.name = name;
	    this.surname = surname;
	    this.courses = courses;
	    this.password = password;
	  }
	
	public String getName() {
	    return this.name;
	}

	public String getSurname() {
		  return this.surname;
	}

	public int getId() {
		  return this.id;
	}
	
	public String getUsername(){
		return this.name + DOT + this.surname;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String[] getCourses(){
		return this.courses;
	}
	
	public void replaceCourse(String course, int idx){
		this.courses[idx]=course;
	}
	public void replaceAllCourses(String[] courses){
		this.courses = courses;
	}
	
	public String getDescription(){
		return this.toString();
	}
	public String toString() {
	    return "Professor [name=" + this.name + ", surname=" + this.surname + ", id=" + this.id
	        + ", N°Courses=" + this.courses.length + "] " + "Courses:" + Arrays.toString(this.courses);
	}
	public void printCourses(){
		System.out.println("Corsi del Professor "+this.surname+" "+this.name);
		for (int i=0;i<this.courses.length;i++){
			System.out.println(""+(i+1)+". "+this.courses[i]);
		}
	}
}
