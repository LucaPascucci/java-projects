package oop1314.lab02.constructors;

public class Smartphone {

  private static final boolean DEF_HAS_GPS = true;
  private static final boolean DEF_HAS_3G = true;
  private static final boolean DEF_HAS_NFC = true;
  private static final int DEF_SD_SIZE = 8192;
  private static final int DEF_RAM_SIZE = 1024;
  private static final int DEF_N_CPU = 2;
  
  public int nCPU;
  public int ram;
  public int sdSize;
  
  public String brand;
  public String model;
  public boolean hasGPS;
  public boolean has3G;
  public boolean hasNFC;
  
  public Smartphone(String marca, String modello){
	  this(marca, modello,DEF_N_CPU,DEF_RAM_SIZE,DEF_SD_SIZE,DEF_HAS_GPS,DEF_HAS_3G,DEF_HAS_NFC);
  }
  
  public Smartphone(String marca, String modello,int sdSize){
	  this(marca, modello,DEF_N_CPU,DEF_RAM_SIZE,sdSize,DEF_HAS_GPS,DEF_HAS_3G,DEF_HAS_NFC);
  }
  
  public Smartphone(String marca, String modello,boolean gps, boolean treg){
	  this(marca, modello,DEF_N_CPU,DEF_RAM_SIZE,DEF_SD_SIZE,gps,treg,DEF_HAS_NFC);
  }
  
  public Smartphone(String marca, String modello,boolean nfc){
	  this(marca, modello,DEF_N_CPU,DEF_RAM_SIZE,DEF_SD_SIZE,DEF_HAS_GPS,DEF_HAS_3G,nfc);
  }
  
  public Smartphone(String marca, String modello,int ncpu, int ram, int sdsize, boolean gps, boolean treg, boolean nfc){
	  this.brand = marca;
	  this.model = modello;
	  this.nCPU = ncpu;
	  this.ram = ram;
	  this.sdSize = sdsize;
	  this.has3G = treg;
	  this.hasGPS = gps;
	  this.hasNFC = nfc;
  }
  
  public void printStringRep ()
  {
	  System.out.println("Marca: "+this.brand);
	  System.out.println("Modello "+this.model);
	  System.out.println("Numero di CPU: "+this.nCPU);
	  System.out.println("Ram: "+this.ram+" MB");
	  System.out.println("Memoria interna: "+this.sdSize +" MB");
	  System.out.println("GPS: "+this.hasGPS);
	  System.out.println("3G: "+this.has3G);
	  System.out.println("NFC: "+this.hasNFC + '\n');
	  
  }
 
  public static void main(String args[]){
	  
	Smartphone cell1 = new Smartphone("HTC","One");
	Smartphone cell2 = new Smartphone("Samsung","Galaxy Note 3",4,2048,8192,true,true,true);
	Smartphone cell3 = new Smartphone("Apple","iPhone 5s",false);
	Smartphone cell4 = new Smartphone("Google","Nexus 4", true, true);
	
    // 1) Creare lo smarthpone HTC One ram:1024 sdSize
    // 2) Creare lo smarthpone Samsung Galaxy Note 3 ram:2048 sdSize:8192 gps:true nfc:true 3g:true
    // 3) Creare lo smarthpone iPhone 5S nfc:false
    // 4) Creare lo smarthpone Google Nexus 4 gps:true 3g:true
	
	
    // 5) Utilizzare il metodo printStringRep per stampare in standard output le informazioni di ciascun telefono 
	
	cell1.printStringRep();
	cell2.printStringRep();
	cell3.printStringRep();
	cell4.printStringRep();
	
  }
}