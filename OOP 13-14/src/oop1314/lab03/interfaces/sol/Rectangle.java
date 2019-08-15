package oop1314.lab03.interfaces.sol;

public class Rectangle implements IShapeWithLimitedEdges {

  private static final int N_EDGES = 4;
  private int l1;
  private int l2;

  public Rectangle(int l1, int l2){
    this.l1 = l1;
    this.l2 = l2;
  }
  
  public double getArea() {
    return this.l1*this.l2;
  }

  public double getPerimeter() {
    return this.l1*2 + this.l2*2;
  }

  public int getNumEdges() {
    return Rectangle.N_EDGES;
   }
}