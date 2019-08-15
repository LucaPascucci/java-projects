package it.unibo.apice.oop.p09generics.constrained;
public class UseLampsRow {
    
    public static void main(String[] s){
    	LampsRow<UnlimitedLamp> lr = new LampsRow<>(); // inferenza
    	lr.addLamp(new UnlimitedLamp());
    	lr.addLamp(new UnlimitedLamp());
    	lr.addLamp(new UnlimitedLamp());
    	
    	lr.getLamp(0).switchOn();
    	lr.switchOffAll();
    	
    	System.out.println(lr.getLamp(0).isOver());
    	System.out.println(lr);
    }
}
