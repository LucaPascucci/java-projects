package oop1314.lab03.interfaces.sol;

public class Circle implements IShape {

  private double radius;
  
  public Circle(double radius){
    this.radius = radius;
  }
  
  public double getArea() {
    return Math.PI * Math.pow(this.radius, 2);
  }

  public double getPerimeter() {
    return 2 * Math.PI * this.radius;
  }
}