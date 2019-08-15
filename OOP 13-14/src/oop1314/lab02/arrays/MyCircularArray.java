package oop1314.lab02.arrays;

public class MyCircularArray {

  private static final int ARRAY_DEF_SIZE = 10;
  private int indice = 0;
  int[] array;
  
  public MyCircularArray(int size){
	  this.array = new int[size];
  }
  
  public MyCircularArray(){
	  this.array = new int[ARRAY_DEF_SIZE];
  }
  
  public void add(int elem){
	if(indice == this.array.length)
	{
		indice = 0;
	}
	this.array[indice] = elem;
	indice++;
  }

  public void reset(){
    for (int i=0;i<this.array.length;i++){
    	this.array[i]=0;
    }
    this.indice = 0;
  }
  
  public void printArray(){
    System.out.print("[");
    for(int i=0; i<array.length-1; i++){
      System.out.print(array[i]+",");
    }
    System.out.print(array[array.length-1]+"]"+'\n');
  }
  
  public static void main(String args[]){
	  
	  MyCircularArray array = new MyCircularArray(10);
	  array.add(1);
	  array.add(2);
	  array.add(3);
	  array.add(4);
	  array.add(5);
	  array.add(6);
	  array.add(7);
	  array.add(8);
	  array.add(9);
	  array.add(10);
	  
	  array.printArray();
	  
	  array.add(11);
	  array.add(12);
	  array.add(13);
	  array.add(14);
	  array.add(15);
	  
	  array.printArray();
	  array.reset();
	  array.printArray();
	  
	  array.add(16);
	  array.add(17);
	  array.add(18);
	  array.add(19);
	  array.add(20);
	  
	  array.printArray();
	  
    //1) Creare un array circolare di dieci elementi
    //2) Aggiugnere gli elementi da 1 a 10 e stampare il contenuto dell'array circolare
    //3) Aggiungere gli elementi da 11 a 15 e stampare il contenuto dell'array circolare
    //4) Invocare il metodo reset
    //5) Stampare il contenuto dell'array circolare
    //6) Aggiungere altri elementi a piacere e stampare il contenuto dell'array circolare
  }
}