package oop1314.lab03.interfaces.sol;

public class WorkWithShapes {

  public static void main(String[] args) {
    IShape circle = new Circle(3);
    IShapeWithLimitedEdges square = new Square(5);
    IShapeWithLimitedEdges rectangle = new Rectangle(2,4);
    IShapeWithLimitedEdges scaleneTriangle = new ScaleneTriangle(4, 3, 5.2, 3);
    
    System.out.println("Circle with radius = 3. Perimeter = " + circle.getPerimeter() + ", area = " + circle.getArea());
    System.out.println("Square with edge = 3. Perimeter = " + square.getPerimeter() + ", area = " + square.getArea());
    System.out.println("Rectangle with edges = (2,4). Perimeter = " + rectangle.getPerimeter() + ", area = " + rectangle.getArea());
    System.out.println("Scalene triangle with edges = (4,3,5.2). Perimeter = " + scaleneTriangle.getPerimeter() + ", area = " + scaleneTriangle.getArea());
  }
}
