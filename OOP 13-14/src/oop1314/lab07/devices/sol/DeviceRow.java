package oop1314.lab07.devices.sol;

import java.util.*;

public class DeviceRow {

	/**
	 * The row of devices as a java.util.List
	 * Note we defer the choice of the actual implementation 
	 */
	private List<Device> list;

	/**
	 * This constructor creates and initializes a list of CountdownDevice
	 *             
	 */
	public DeviceRow() {
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
	
	public void addDevice(Device d){
		this.list.add(d);
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
			try {
				d.on();
			} catch (DeviceIsOverException de) {
				e = de;
			}
		}
		if (e != null) {
			throw e;
		}
	}

	public String toString() {
		return "DeviceRow " + list;
	}

}
