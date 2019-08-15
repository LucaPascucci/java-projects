package oop1314.lab03.encapsulation.sol;

public class Calculator {

  private int nOpDone;
  private double lastRes;
  
  public Calculator(){
    this.nOpDone = 0;
    this.lastRes = 0;
  }

  public int getNOpDone() {
    return this.nOpDone;
  }

  public double getLastRes() {
    return this.lastRes;
  }

  public double add(double n1, double n2){
    this.lastRes = n1+n2;
    this.nOpDone++;
    return this.lastRes;
  }
  
  public double sub(double n1, double n2){
    this.lastRes = n1-n2;
    this.nOpDone++;
    return this.lastRes;
  }
  
  public double mul(double n1, double n2){
    this.lastRes = n1*n2;
    this.nOpDone++;
    return this.lastRes;
  }
  
  public double div(double n1, double n2){
    this.lastRes = n1/n2;
    this.nOpDone++;
    return this.lastRes;
  }
  
  public static void main(String args[]){
    Calculator calc = new Calculator();
    
    System.out.println("1+2=" + calc.add(1, 2));
    System.out.println("nOpDone=" + calc.nOpDone);
    System.out.println("lastRes=" + calc.lastRes +"\n");
    
    System.out.println("-1-(+2)=" + calc.sub(-1, 2));
    System.out.println("nOpDone=" + calc.nOpDone);
    System.out.println("lastRes=" + calc.lastRes +"\n");
    
    System.out.println("6*3=" + calc.mul(6, 3));
    System.out.println("nOpDone=" + calc.nOpDone);
    System.out.println("lastRes=" + calc.lastRes +"\n");
    
    System.out.println("8/4=" + calc.div(8, 4));
    System.out.println("nOpDone=" + calc.nOpDone);
    System.out.println("lastRes=" + calc.lastRes +"\n");
  }
}