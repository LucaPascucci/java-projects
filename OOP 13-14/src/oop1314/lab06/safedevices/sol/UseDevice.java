package oop1314.lab06.safedevices.sol;


public class UseDevice {

	public static void main(String[] args) throws Exception {
		DeviceRow dr = new DeviceRow();
		dr.addDevice(new CountdownDevice(5));
		dr.addDevice(new CountdownDevice(3));
		dr.getDevice(0).on();
		System.out.println(dr);
	}
}
