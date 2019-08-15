package oop1314.lab02.arrays;

import oop1314.lab02.constructors.Smartphone;

public class PlayWithSmartphoneArrays {

  static int search(Smartphone[] array,String brand){
	  int nOccur = 0;
	    for (Smartphone currElem: array){
	      if (currElem.brand==brand){
	        nOccur++;
	      }
	    }
	 return nOccur;
  }
  
  static int search(Smartphone[] array, boolean hasNFC, boolean hasGPS){
	  int nOccur = 0;
	    for (Smartphone currElem: array){
	      if (currElem.hasNFC==hasNFC && currElem.hasGPS==hasGPS){
	        nOccur++;
	      }
	    }
	 return nOccur;
  }
  static int search(Smartphone[] array, int nCPUs, int sdSize, boolean has3G){
	  int nOccur = 0;
	    for (Smartphone currElem: array){
	      if (currElem.has3G==has3G && currElem.nCPU == nCPUs && currElem.sdSize==sdSize){
	        nOccur++;
	      }
	    }
	 return nOccur;
  }
  
  static void printArraySmartphone (Smartphone[] array){
	  System.out.println("Array di Smartphone\n");
	  for (Smartphone elem: array){
		  elem.printStringRep();
	  }
  }
  
  public static void main(String[] args) {
    // 1) Creare lo smarthpone HTC One ram:1024 sdSize
    // 2) Creare lo smarthpone Samsung Galaxy Note 3 ram:2048 sdSize:8192 gps:true nfc:true 3g:true
    // 3) Creare lo smarthpone iPhone 5S nfc:false
    // 4) Creare lo smarthpone Google Nexus 4 gps:true 3g:true
    // 5) Creare lo smarthpone Acer Liquid cpu:2 ram:512 sdSize:8192 gps: true 3g:true nfc: false
	  Smartphone cell1 = new Smartphone("HTC","One");
	  Smartphone cell2 = new Smartphone("Samsung","Galaxy Note 3",4,2048,8192,true,true,true);
	  Smartphone cell3 = new Smartphone("Apple","iPhone 5s",false);
	  Smartphone cell4 = new Smartphone("Google","Nexus 4", true, true);
	  Smartphone cell5 = new Smartphone("Acer","Liquid",2,512,8192,true,true,false);
	  
	  Smartphone[] arrayCell = new Smartphone[]{cell1,cell2,cell3,cell4,cell5};
	  printArraySmartphone(arrayCell);
	  
	  
    // 6) Eseuguire diverse operazioni di ricerca con i metodi search implementati e controllare la corrispondenza del numero dei telefoni facenti match 
  }
}