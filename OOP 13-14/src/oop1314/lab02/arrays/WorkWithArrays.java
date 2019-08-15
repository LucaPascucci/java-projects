package oop1314.lab02.arrays;
//import java.util.Arrays;
public class WorkWithArrays {

  public static int countOccurr (int[] array, int elem){ //conta le ripetizioni di un valore dentro un array
    int nOccur = 0;
    for (int currElem: array){
      if (currElem==elem){
        nOccur++;
      }
    }
    return nOccur;
  }
  
  public static int[] evenElems(int[] array){
	  int lunghezzaNuovo = (array.length/2)+(array.length%2);
	  int[] risultato = new int[lunghezzaNuovo];
	  int indiceNuovo = 0;
	  for (int i = 0; i<array.length; i++){
		  if (i%2==0){
			  risultato[indiceNuovo]=array[i];
			  indiceNuovo++;
		  }
	  }
    return risultato;
  }
  
  public static int[] oddElems(int[] array){
	  int lunghezzaNuovo = (array.length/2);
	  int[] risultato = new int[lunghezzaNuovo];
	  int indiceNuovo = 0;
	  for (int i = 0; i<array.length; i++){
		  if (i%2==1){
			  risultato[indiceNuovo]=array[i];
			  indiceNuovo++;
		  }
	  }
    return risultato;
  }
  
  public static int getMostRecurringElem(int[] array){
	int risultato = 0;
	int nOccurMax = 0;
	for (int i = 0; i<array.length; i++){
		int nOccur = countOccurr(array,array[i]);
		if (nOccurMax < nOccur){
			nOccurMax = nOccur;
			risultato = array[i];
		}
	}
    return risultato;
  }
 
  public static void printArray (int[] array){
	  for (int currElem: array){
		  System.out.print(currElem+" ");
	  }
	  System.out.println();
  }
  
  public static int[] sortArray (int[] array, boolean desc){//true= ordinamento crescente; false = ordinamento decrescente BUBBLESORT
	  if (desc==true){
		  for (int j = array.length - 1;j >= 1; j--)
			{
				for (int i = 0; i <= j-1; i++)
				{
					if (array[i] > array[i+1])
					{
						int temp = array[i];
						array[i] = array[i+1];
						array[i+1] = temp;
					}
				}
			}
	  }
	  else{
		  for (int j = array.length - 1;j >= 1; j--)
			{
				for (int i = 0; i <= j-1; i++)
				{
					if (array[i] < array[i+1])
					{
						int temp = array[i];
						array[i] = array[i+1];
						array[i+1] = temp;
					}
				}
			}
	  }
	  return array;
  }
  
  public static double mediaVettore (double[] array){
	  double media = 0;
	  for (double currElem: array){
		  media = media + currElem;
	  }
	  media = media/array.length;
	  return media;
  }
  
  public static double computeVariance ( double[] array){
	  double varianza = 0;
	  double media = mediaVettore(array);
	  for (double currElem: array){
		  varianza = varianza + ((currElem-media)*(currElem-media));
	  }
	  varianza = varianza/array.length;
	  return varianza;
  }
  
  public static int[] dupElems (int[] array, int nTimes){
	  int[] ritorno = new int[nTimes*array.length];
	  int ripetizione = 0;
	  int indiceArrayInizio=0;
	  for (int i = 0; i <(nTimes*array.length); i++){
		  
		  ritorno[i] = array[indiceArrayInizio];
		  ripetizione++;
		  if (ripetizione == nTimes)
		  {
			  ripetizione = 0;
			  indiceArrayInizio++;
		  }
	  }
	  return ritorno;
  }
  
  public static int[] revertUpTo(int[] array,int stopEl){
	  int[] vettAppoggio = new int[array.length];
	  int indCambio = stopEl-2;
	  for (int i=0;i<stopEl-1;i++){
		  vettAppoggio[i]=array[indCambio];
		  indCambio--;
	  }
	  for (int i=stopEl-1;i<array.length;i++){
		  vettAppoggio[i]=array[i];
	  }
	  return vettAppoggio;
  }

  /** Testing methods **/
  
  /* Utility method for testing countOccurr method */
  public static boolean testCountOccurr (){
    return countOccurr(new int[]{1,2,3,4}, 1)==1 &&
        countOccurr(new int[]{0,2,3,4}, 1)==0 &&
        countOccurr(new int[]{7,4,1,9,3,1,5}, 2)==0 &&
        countOccurr(new int[]{1,2,1,3,4,1}, 1)==3 &&
        countOccurr(new int[]{1,4,6,4,8,6},4)==2;
  }
  
  /* Utility method for testing testEvenElems method */
  public static boolean testEvenElems (){
    return arrayEquals(evenElems(new int[]{1,2,3,4}), new int[]{1,3}) &&
        arrayEquals(evenElems(new int[]{1,2,3,4,5,6,7,8,9}), new int[]{1,3,5,7,9}) &&
        arrayEquals(evenElems(new int[]{4,6,7,9,1,5,23,11,73}), new int[]{4,7,1,23,73}) &&
        arrayEquals(evenElems(new int[]{7,5,1,24,12,46,23,11,54,81}), new int[]{7,1,12,23,54});
  }
  
  /* Utility method for testing testOddElems method */
  public static boolean testOddElems (){
    return arrayEquals(oddElems(new int[]{1,2,3,4}), new int[]{2,4}) &&
        arrayEquals(oddElems(new int[]{1,2,3,4,5,6,7,8,9}), new int[]{2,4,6,8}) &&
        arrayEquals(oddElems(new int[]{4,6,7,9,1,5,23,11,73}), new int[]{6,9,5,11}) &&
        arrayEquals(oddElems(new int[]{7,5,1,24,12,46,23,11,54,81}), new int[]{5,24,46,11,81});
  }
  
  /* Utility method for testing testGetMostRecurringElem method */
  public static boolean testGetMostRecurringElem(){
    return getMostRecurringElem(new int[]{1,2,1,3,4})==1 &&
        getMostRecurringElem(new int[]{7,1,5,7,7,9})==7 &&
        getMostRecurringElem(new int[]{1,2,3,1,2,3,3})==3 && 
        getMostRecurringElem(new int[]{5,11,2,11,7,11})==11;
  }
  
  /* Utility method used to check if two int arrays are equals */
  private static boolean arrayEquals(int[] array1, int[] array2){
    if (array1.length==array2.length){
      for (int i=0; i< array1.length; i++){
        if (array1[i]!=array2[i]){
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }
  
  public static void main(String args[]){
    //System.out.println("testCountOccurr: " + testCountOccurr());
    //System.out.println("testEvenElems: " +testEvenElems());
    //System.out.println("testOddElems: " +testOddElems());
    //System.out.println("testGetMostRecurringElem: " + testGetMostRecurringElem());
    int[] vettoreProva = new int[]{3,2,5,6,3,4,1,10,11,15,7,8,9};
    int[] vettoreDuplice = new int[]{1,2,1};
    double[] vettVarianza = new double[]{2.0,2.0,2.0};
    int[] vettRevertUpTo = new int[]{1,2,3,4,5,6,7,8,9};
    double varianza = 0;
    
    printArray(vettoreProva);
    vettoreProva=sortArray(vettoreProva,false);
    printArray(vettoreProva);
    
    printArray(vettoreDuplice);
    vettoreDuplice = dupElems(vettoreDuplice, 5);
    printArray(vettoreDuplice);
    
    varianza = computeVariance (vettVarianza);
    System.out.println("La varianza è: "+varianza);
    
    printArray(vettRevertUpTo);
    vettRevertUpTo = revertUpTo(vettRevertUpTo,5);
    printArray(vettRevertUpTo);
    
  }
}