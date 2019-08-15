package oop1314.lab03.interfaces;

public class ScaleneTriangle implements IShapeWithLimitedEdges{
	
	private double lato1;
	private double lato2;
	private double lato3;
	private double altezzaLato1;
	
	public ScaleneTriangle(double lato1,double lato2, double lato3, double altezza){
		this.lato1 = lato1;
		this.lato2 = lato2;
		this.lato3 = lato3;
		this.altezzaLato1 = altezza;
	}
	public int getNumEdges(){
		return 3;
	}
	public double getArea(){
		return (this.lato1*this.altezzaLato1)/2;
	}
	public double getPerimeter(){
		return this.lato1+this.lato2+this.lato3;
	}

}
