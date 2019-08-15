package oop1314.lab03.encapsulation.sol;

public class Smartphone {

  private static final boolean DEF_HAS_GPS = true;
  private static final boolean DEF_HAS_3G = true;
  private static final boolean DEF_HAS_NFC = true;
  private static final int DEF_SD_SIZE = 8192;
  private static final int DEF_RAM_SIZE = 1024;
  private static final int DEF_N_CPU = 2;

  private int nCPU;
  private int ram;
  private int sdSize;

  private String brand;
  private String model;
  private boolean hasGPS;
  private boolean has3G;
  private boolean hasNFC;

  public Smartphone(int nCPU, int ram, int sdSize, String brand, String model,
      boolean hasGPS, boolean has3G, boolean hasNFC) {
    this.nCPU = nCPU;
    this.ram = ram;
    this.sdSize = sdSize;
    this.brand = brand;
    this.model = model;
    this.hasGPS = hasGPS;
    this.has3G = has3G;
    this.hasNFC = hasNFC;
  }

  public Smartphone(String brand, String model) {
    this(DEF_N_CPU, DEF_RAM_SIZE, DEF_SD_SIZE, brand, model, 
        DEF_HAS_GPS, DEF_HAS_3G, DEF_HAS_NFC);
  }

  public Smartphone(String brand, String model, int sdSize) {
    this(brand, model);
    this.sdSize = sdSize;
    this.nCPU = DEF_N_CPU;
    this.ram = DEF_RAM_SIZE;
    this.sdSize = DEF_SD_SIZE;
    this.hasGPS = DEF_HAS_GPS;
    this.has3G = DEF_HAS_3G;
    this.hasNFC = DEF_HAS_NFC;
  }

  public Smartphone(String brand, String model, boolean hasNFC) {
    this(DEF_N_CPU, DEF_RAM_SIZE, DEF_SD_SIZE, brand, model, 
        DEF_HAS_GPS, DEF_HAS_3G, hasNFC);
  }

  public Smartphone(String brand, String model, boolean hasGPS, boolean has3G) {
    this(DEF_N_CPU, DEF_RAM_SIZE, DEF_SD_SIZE, brand, model, hasGPS, has3G, DEF_HAS_NFC);
  }

  public void printStringRep(){
    System.out.println("n CPU(s): " + nCPU);
    System.out.println("RAM amount: " + ram);
    System.out.println("SD size: " + sdSize);
    System.out.println("brand: " + brand);
    System.out.println("model: " + model);
    System.out.println("hasGPS: " + hasGPS);
    System.out.println("has3G: " + has3G);
    System.out.println("hasNFC: " + hasNFC + "\n");
  }

  public int getNCPU() {
    return nCPU;
  }

  public int getRam() {
    return ram;
  }

  public int getSdSize() {
    return sdSize;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public boolean hasGPS() {
    return hasGPS;
  }

  public boolean has3G() {
    return has3G;
  }

  public boolean hasNFC() {
    return hasNFC;
  }

  public static void main(String args[]){
    // 1) Creare lo smarthpone HTC One sdSize:1024 
    Smartphone htcOne = new Smartphone("HTC", "One", 1024);
    // 2) Creare lo smarthpone Samsung Galaxy Note 3 ram:2048 cpu:4 sdSize:8192 gps:true nfc:true 3g:true
    Smartphone note3 = new Smartphone(4, 2048, 8192, "Samsung", "Galaxy Note 3", true, true, true);  
    // 3) Creare lo smarthpone Apple iPhone 5S nfc:false
    Smartphone iPhone5S = new Smartphone("Apple", "iPhone 5S", false);
    // 4) Creare lo smarthpone Google Nexus 4 gps:true 3g:true
    Smartphone nexus4 = new Smartphone("Google", "Nexus 4", true, true);
    // 5) Utilizzare il metodo printStringRep per stampare in standard output le informazioni di ciascun telefono
    htcOne.printStringRep();
    note3.printStringRep();
    iPhone5S.printStringRep();
    nexus4.printStringRep();
  }
}