package oop1314.lab03.interfaces;

public class Circle implements IShape {

  private double radius;
  
  public Circle(double radius){
    this.radius = radius;
  }
  
  public double getArea() {
    return Math.PI * Math.pow(this.radius, 2);
  }

  public double getPerimeter() {
    return (this.radius*2*Math.PI);
  }
}