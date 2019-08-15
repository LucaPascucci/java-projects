package oop1314.lab06.safedevices;

public class CountdownDevice extends AbstractDevice{
    
    private int countdown; //numero di on() prima di esarimento
    
    public CountdownDevice(int countdown){
    	super();	//opzionale ma meglio indicarlo
    	if (countdown < 1){	//meglio segnalare il problema
    		throw new IllegalArgumentException(); //lancia l'eccezione
    	}
    	this.countdown = countdown;
    }
    
    protected boolean onFails(){
    	if (this.countdown == 0){
    		return true;
    	}
    	this.countdown--;
    	return false;
    }
    
    public String toString(){
    	return super.toString() + "." + this.countdown;
    }
} 