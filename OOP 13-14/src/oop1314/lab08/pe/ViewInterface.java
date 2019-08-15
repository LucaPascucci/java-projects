package oop1314.lab08.pe;

public interface ViewInterface {
	
	void clearData();
	void addData(Object[] o);
	void commandFailed(String message);
	void attachViewObserver(ViewObserver listener);

}