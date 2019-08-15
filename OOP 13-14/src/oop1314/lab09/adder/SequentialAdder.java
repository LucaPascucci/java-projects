package oop1314.lab09.adder;

public class SequentialAdder {

  public static long computeSum(long[] inputArray){
    long returnValue = 0;
    for (long elem: inputArray){
      returnValue += Math.pow(elem, 3);
    }
    return returnValue;
  }
  
  public static long[] createArray(int n){
    long returnValue[] = new long[n];
    for (int i = 0; i < n; i++){
      returnValue[i] = (long) (Math.random() * 10);
    }
    return returnValue;
  }
  
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println("The sum is: " + 
        computeSum(createArray(Integer.parseInt(args[0]))) + 
        " computing time is (" + (System.currentTimeMillis() - startTime) + " ms)");
  }
}