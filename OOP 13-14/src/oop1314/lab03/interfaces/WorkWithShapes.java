package oop1314.lab03.interfaces;

public class WorkWithShapes {

	public static void main(String[] args) {
		Circle cerchio = new Circle(4);
		System.out.println("Il perimetro del cerchio è: "+cerchio.getPerimeter());
		System.out.println("L'area del cerchio è: "+cerchio.getArea());
		Square quadrato = new Square(3);
		System.out.println("Il perimetro del quadrato è: "+quadrato.getPerimeter());
		System.out.println("L'area del quadrato è: "+quadrato.getArea());
		Rectangle rettangolo = new Rectangle(3,4);
		System.out.println("Il perimetro del rettangolo è: "+rettangolo.getPerimeter());
		System.out.println("L'area del rettangolo è: "+rettangolo.getArea());
		ScaleneTriangle triangolo = new ScaleneTriangle (3,4,5,2);
		System.out.println("Il perimetro del triangolo è: "+triangolo.getPerimeter());
		System.out.println("L'area del triangolo è: "+triangolo.getArea());
	}

}
