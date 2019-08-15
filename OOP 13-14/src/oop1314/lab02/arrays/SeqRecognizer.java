package oop1314.lab02.arrays;

public class SeqRecognizer {

  public static boolean checkSeq1(int[] array){
    int i=0;
    for(; i< array.length && array[i]==1; i++);
    for(; i< array.length && (array[i]==2 || array[i]==3); i++);
    return i==array.length;
  }

  public static boolean checkSeq2(int[] array){
	  int i=0;
	  int nV3 = 0;
	  int nV1 = 0;
	  for(; i< array.length && array[i]==1; i++){
		  nV1++;
		  if (nV1>1){
			  return false;
		  }
	  }
	  if (nV1==0){
		  return false;
	  }
	  for(; i< array.length && array[i]==2; i++);
	  for(; i<array.length && array[i]==3; i++){
		  nV3++;
		  if (nV3>1){
			  return false;
		  }
	  }
	  if (nV3 == 0){
		  return false;
	  }
	  return i==array.length;
  }
  
  public static boolean checkSeq3(int[] array){
	  int i=0;
	  int nV3 = 0;
	  int nV1 = 0;
	  int nV5 = 0;
	  for(; i< array.length && array[i]==1; i++){
		  nV1++;
		  if (nV1>1){
			  return false;
		  }
	  }
	  if (nV1==0){
		  return false;
	  }
	  for(; i< array.length && array[i]==2; i++);
	  for(; i<array.length && array[i]==3; i++){
		  nV3++;
		  if (nV3>1){
			  return false;
		  }
	  }
	  if (nV3 == 0){
		  return false;
	  }
	  for(; i< array.length && array[i]==4; i++);
	  for(; i< array.length && array[i]==5; i++){
		  nV5++;
		  if (nV5>1){
			  return false;
		  }
	  }
	  return i==array.length;
   
  }
  
  public static boolean checkSeq4(int[] array){
	  int i=0;
	  int nV2o3 = 0;
	  int nV5 = 0;
	  if (array[i]==1){
		  return false;
	  }
	  for(; i< array.length && (array[i]==2 || array[i]==3); i++){
		  nV2o3++;
		  if (nV2o3>1){
			  return false;
		  }
	  }
	  for(; i< array.length && array[i]==4; i++);
	  for(; i< array.length && array[i]==5; i++){
		  nV5++;
		  if (nV5>1){
			  return false;
		  }
	  }
	  if (nV5 == 0){
		  return false;
	  }
	  return i==array.length;
   
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
  
  public static boolean testCheckSeq4(){
	    return checkSeq4(new int[]{1,3})==false &&
	    		checkSeq4(new int[]{3,4,4,4,4,5})==true;
	  }

  public static void main(String[] args) {
    System.out.println("testCheckSeq1: " + testCheckSeq1());
    System.out.println("testCheckSeq2: " + testCheckSeq2());
    System.out.println("testCheckSeq3: " + testCheckSeq3());
    System.out.println("testCheckSeq4: " + testCheckSeq4());
  }
}