package oop1314.lab03.interfaces;

public class Square implements IShapeWithLimitedEdges{
	
	private double lato;
	
	public Square (double lato){
		this.lato=lato;
	}
	
	public Square (){
		this.lato=1;
	}
	
	public int getNumEdges(){
		return 4;
	}
	public double getArea(){
		return Math.pow(this.lato, 2);
	}
	public double getPerimeter(){
		return this.lato*getNumEdges();
	}
	
}
