package oop1314.lab06.safedevices;

import java.util.*;

public class DeviceRow {

	/**
	 * Default countdown for devices 
	 */
	final private static int COUNTDOWN = 3;

	/**
	 * The row of devices as a java.util.List
	 * Note we defer the choice of the actual implementation 
	 */
	private List<Device> list;  // lista di device

	/**
	 * This constructor creates and initializes a list of CountdownDevice
	 * 
	 * @param size is the number of devices to use
	 *            
	 * @throws an IllegalArgumentException if size < 0
	 *             
	 */
	public DeviceRow(int size) {
		if (size < 0) {	// lancio eccezione in caso di size minore di uno
			throw new IllegalArgumentException();
		}
		this.list = new ArrayList<>();
		for (; size >= 0; size--) {
			this.list.add(new CountdownDevice(COUNTDOWN));
		}
	}
	
	public DeviceRow(){
		this.list = new ArrayList<>();
	}

	/**
	 * @param index is the position of the device to get
	 * @return the device
	 */
	public Device getDevice(int index) {
		return this.list.get(index);
	}

	/**
	 * @return the number of devices
	 */
	public int getSize() {
		return this.list.size();
	}

	/**
	 * Switches all devices off
	 */
	public void allOff() {
		for (Device d : this.list) {
			d.off();
		}
	}

	/**
	 * Switched all devices on, no matter whether one fails.
	 * 
	 * @throws the last DeviceIsOverException raised, if any
	 */
	public void allOn() throws DeviceIsOverException {
		DeviceIsOverException e = null;
		for (Device d : this.list) {
			try {		//prova ad accenderla anche se c'è un'eccezione continua a fare il ciclo per accenderle tutte
				d.on();
			} catch (DeviceIsOverException de) {
				e = de;
			}
		}
		if (e != null) {
			throw e; // lancia l'eccezione
		}
	}

	public String toString() {
		return "DeviceRow " + list;
	}
	
	public void addDevice (CountdownDevice Device){
		this.list.add(Device);
	}
}