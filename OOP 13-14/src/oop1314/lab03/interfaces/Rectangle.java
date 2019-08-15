package oop1314.lab03.interfaces;

public class Rectangle implements IShapeWithLimitedEdges{
	
	private double latoMax;
	private double latoMin;
	
	public Rectangle (double latoMin, double latoMax){
		this.latoMax = latoMax;
		this.latoMin = latoMin;
	}
	
	public Rectangle (){
		this.latoMax=2;
		this.latoMin=1;
	}
	
	public int getNumEdges(){
		return 4;
	}
	public double getArea(){
		return this.latoMax*this.latoMin;
	}
	public double getPerimeter(){
		return (this.latoMax*(getNumEdges()/2)+this.latoMin*(getNumEdges()/2));
	}

}
