package oop1314.lab03.interfaces.sol;

public class Square implements IShapeWithLimitedEdges {

  private static final int N_EDGES = 4;
  private double edgeLength;
  
  public Square(double edgeLength){
    this.edgeLength = edgeLength;
  }
  
  public double getArea() {
    return this.edgeLength * this.edgeLength;
  }

  public double getPerimeter() {
    return this.edgeLength * N_EDGES;
  }

  public int getNumEdges() {
    return Square.N_EDGES;
  }
}