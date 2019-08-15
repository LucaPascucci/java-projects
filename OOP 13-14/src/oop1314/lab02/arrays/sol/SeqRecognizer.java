package oop1314.lab02.arrays.sol;

public class SeqRecognizer {

  public static boolean checkSeq1(int[] array){
    int i=0;
    for(; i< array.length && array[i]==1; i++);
    for(; i< array.length && (array[i]==2 || array[i]==3); i++);
    return i==array.length;
  }

  public static boolean checkSeq2(int[] array){
    if (array.length >= 2 && array[0]==1 && array[array.length-1]==3){
      int i=1;
      for (; i<array.length-1 && array[i]==2; i++);
      return i == array.length-1;
    } else {
      return false;
    }
  }

  public static boolean checkSeq3(int[] array){
    boolean returnValue = false;
    if (array.length >=2 && array[0]==1){
      int i=1;
      for (; i<array.length-1 && array[i]==2; i++);
      if (array[i]==3 && i==array.length){
        return true;
      } else if (array[i]==3) {
        for (i++; i<array.length && array[i]==4; i++);
        return (i==array.length || (i==array.length-1 && array[array.length-1]==5));
      }
    }
    return returnValue;
  }
  
  public static boolean checkSeq4(int[] array){
    if(array.length>=1){
      int index = 0;
      if (array[0]==2 || array[0]==3){
        index = 1;
      }
      for (; index < array.length-1 && array[index]==4; index++);
      return array[array.length-1] == 5;
    } else {
      return false;
    }
  }

  /** Testing methods **/

  /* Utility method for testing checkSeq1 method */
  public static boolean testCheckSeq1(){
    return checkSeq1(new int[]{1,1})==true &&
        checkSeq1(new int[]{1,1,1,2})==true &&
        checkSeq1(new int[]{1,1,1,2,3,2,3})==true &&
        checkSeq1(new int[]{1,1,1,2,3,1,3})==false &&
        checkSeq1(new int[]{3,2,1,1})==false;
  }

  /* Utility method for testing checkSeq2 method */
  public static boolean testCheckSeq2(){
    return checkSeq2(new int[]{1,3})==true &&
        checkSeq2(new int[]{1,2,3})==true &&
        checkSeq2(new int[]{1,2,2,2,2,2,2,3})==true &&
        checkSeq2(new int[]{1,2,2})==false &&
        checkSeq2(new int[]{2,2,2,2,3})==false;
  }

  /* Utility method for testing checkSeq3 method */
  public static boolean testCheckSeq3(){
    return checkSeq3(new int[]{1,3})==true &&
        checkSeq3(new int[]{1,3,5})==true &&
        checkSeq3(new int[]{1,2,2,2,2,2,2,3})==true &&
        checkSeq3(new int[]{1,2,3,4,5})==true &&
        checkSeq3(new int[]{1,2,2,3,4,4,4,5})==true &&
        checkSeq3(new int[]{2,2,3,4,4,4})==false &&
        checkSeq3(new int[]{1,2,2,3,4,4,4,5,6})==false;
  }

  /* Utility method for testing checkSeq4 method */
  public static boolean testCheckSeq4(){
    return checkSeq4(new int[]{2,4,5})==true &&
        checkSeq4(new int[]{5})==true &&
        checkSeq4(new int[]{4,5})==true &&
        checkSeq4(new int[]{2,4,4,4,4,4,4,4,4,5})==true &&
        checkSeq4(new int[]{3,4,5})==true &&
        checkSeq4(new int[]{2,3,4,4,4,4,5})==true &&
        checkSeq4(new int[]{4,4,4})==false;
  }
  
  public static void main(String[] args) {
    System.out.println("testCheckSeq1: " + testCheckSeq1());
    System.out.println("testCheckSeq2: " + testCheckSeq2());
    System.out.println("testCheckSeq3: " + testCheckSeq3());
    System.out.println("testCheckSeq4: " + testCheckSeq4());
  }
}
