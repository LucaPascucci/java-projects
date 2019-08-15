package oop1314.lab07.reflection;

/**
 * A dummy clonable class
 * @author Andrea Santi
 *
 */
public class ClonableClass{

  private String a;
  private String b;
  private Double d;

  public String getA() {
    return a;
  }
  
  public void setA(String a) {
    this.a = a;
  }
  
  public String getB() {
    return b;
  }
  
  public void setB(String b) {
    this.b = b;
  }
  
  public Double getD() {
    return d;
  }
  
  public void setD(Double d) {
    this.d = d;
  }

  public String toString() {
    return "ClonableClass [a=" + a + ", b=" + b + ", d=" + d + "]";
  }
}