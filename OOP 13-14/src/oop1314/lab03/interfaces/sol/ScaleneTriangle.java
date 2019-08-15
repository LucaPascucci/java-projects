package oop1314.lab03.interfaces.sol;

public class ScaleneTriangle implements IShapeWithLimitedEdges {

  private static final int N_EDGES = 3;
  private double l1;
  private double l2;
  private double l3;
  private double h1;
    
  public ScaleneTriangle(double l1, double l2, double l3, double h1) {
    this.l1 = l1;
    this.l2 = l2;
    this.l3 = l3;
    this.h1 = h1;
  }

  public double getArea() {
    return (this.l1*this.h1)/2;
  }

  public double getPerimeter() {
    return this.l1+this.l2+this.l3;
  }

  public int getNumEdges() {
    return ScaleneTriangle.N_EDGES;
  }
}