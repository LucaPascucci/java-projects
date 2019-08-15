package oop1314.lab06.safedevices;


/**
 * @author mirko
 * Implements a CommandExecutor, encapsulating all corresponding design choices  
 */
public class SimpleCommandExecutor implements CommandExecutor{
	
	final private static String ON = "+"; 
	final private static String OFF = "-";
	final private static String EXIT = "exit";
	final private static String OFFALL = "-all";
	final private static String ONALL = "+all";
	final private static String ERROR_UNRECOGNISED = "Unrecognised string";
	final private static String ERROR_OUTOFRANGE = "Out of range";
	final private static String ADD = "add";
	final private static String ERROR_NEGATIVE = "Negative value";
	final private static String FORMAT_ERROR = "Wrong type of input";

	private DeviceRow row;
	
	public SimpleCommandExecutor(){
	}
	
	public void setDeviceRow(DeviceRow row) {
		this.row = row;
	}
	
	/**
	 * @param s is the String command to interpret and execute
	 * @throws ExitCommandException
	 * @throws CommandNotRecognisedException
	 * @throws DeviceIsOverException
	 */
	public void exec(String s) throws ExitCommandException, CommandNotRecognisedException, DeviceIsOverException {
		if (!processExit(s) &&	//controlla se il comando inserito è corretto
				!processOffAll(s) &&
				!processOnAll(s) && 
				!processOn(s) &&
				!processOff(s) &&
				!processAdd(s)){//aggiunto
					throw new CommandNotRecognisedException(ERROR_UNRECOGNISED+" '"+s+"'"); 
		}
	}
	
	private boolean processExit(String s) throws ExitCommandException {
		if (s.equals(EXIT)){
			throw new ExitCommandException();
		}
		return false;
	}
	
	private boolean processOffAll(String s){
		if (s.equals(OFFALL)){
			this.row.allOff();
			return true;
		}
		return false;
	}
	
	private boolean processOnAll(String s) throws DeviceIsOverException {
		if (s.equals(ONALL)){
			this.row.allOn();
			return true;
		}
		return false;
	}
	
	private boolean processAdd(String s) throws CommandNotRecognisedException{ //aggiunge un nuovo device
		if (s.startsWith(ADD)){
			int value = 0;
			try{
				value = Integer.parseInt(s.substring(ADD.length()+1));
			
			} catch (NumberFormatException eccezione){
				throw new CommandNotRecognisedException(FORMAT_ERROR);
			}			
			if (value < 1){
				throw new CommandNotRecognisedException(ERROR_NEGATIVE);
			}
			this.row.addDevice(new CountdownDevice(value));
			return true;
			
		}
		return false;
		
	}
	
	private boolean processOn(String s) throws CommandNotRecognisedException, DeviceIsOverException {
		if (s.startsWith(ON)){//se la stringa incomincia con ON che contiene il +
			int index = -1;
			try {
				index = Integer.parseInt(s.substring(ON.length())); //estrae il numero intero
			} catch (NumberFormatException eccezione){
				throw new CommandNotRecognisedException(FORMAT_ERROR);
			}
			if (index < 0 || index >= this.row.getSize()){
				throw new CommandNotRecognisedException(ERROR_OUTOFRANGE);
			}
			this.row.getDevice(index).on();
			return true;
		}
		return false;
	}
	
	private boolean processOff(String s) throws CommandNotRecognisedException {
		if (s.startsWith(OFF)){
			int index = -1;
			try {
				index = Integer.parseInt(s.substring(OFF.length()));
			} catch (NumberFormatException eccezione){
				throw new CommandNotRecognisedException(FORMAT_ERROR);
			}
			if (index < 0 || index >= this.row.getSize()){
				throw new CommandNotRecognisedException(ERROR_OUTOFRANGE);
			}
			this.row.getDevice(index).off();
			return true;
		}
		return false;
	}
 	
}
