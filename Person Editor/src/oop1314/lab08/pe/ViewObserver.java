package oop1314.lab08.pe;

public interface ViewObserver {
	
	void commandLoad();
	void commandSave();
	void commandAdd(Object[] arg);
	void commandQuit();
	void commandClear();
}
