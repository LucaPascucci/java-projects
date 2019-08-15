package oop1314.lab07.devices;

/**
 * Base class that represents a command that can be provided to the domotic application
 * @author Mirko Viroli, Andrea Santi
 *
 */
public abstract class Command { 
	
	public boolean isExit(){
		return false;
	}
	
	/**
	 * To be overridden in order to implement the logic related to the execution of the command
	 * @param m
	 * @throws Exception
	 */
	abstract public void internalExec(Model m) throws Exception;
	
	// Pattern method: incapsula la generazione della ExecutionException
	// a partire dall'eccezione del metodo internalExec da realizzare.
	// Serve a evitare la try-catch nelle implementazioni concrete
	public void exec(Model m) throws ExecutionException {
		try{
			internalExec(m);
		} catch (Exception e){
			throw new ExecutionException("Message : " + e.getMessage() + " (Original Exception was " + e.getClass() +")");
		}
	}
	
	/**
	 * Defines a comman with one input parameter
	 * @author Mirko Viroli, Andrea Santi
	 *
	 */
	public static abstract class ParametricCommand extends Command {
		protected int param;
		/**
		 * Constructs the command with the param provided in input
		 * @param param
		 */
		public ParametricCommand(int param){
			this.param = param;
		}
	}
	
	public static class AllOn extends Command {
		public void internalExec(Model m) throws Exception {
			m.getDeviceRow().allOn();
		}
	}
	
	public static class AllOff extends Command {
		public void internalExec(Model m) throws Exception {
			m.getDeviceRow().allOff();
		}
	}
	
	public static class On extends ParametricCommand {
		public On(int param){
			super(param); // index
		}
		public void internalExec(Model m) throws Exception {
			m.getDeviceRow().getDevice(this.param).on();
		}
	}
	
	public static class Off extends ParametricCommand {
		public Off(int param){
			super(param); // index
		}
		public void internalExec(Model m) throws Exception{
			m.getDeviceRow().getDevice(this.param).off();
		}
	}
	
	public static class Add extends ParametricCommand {
		public Add(int param){
			super(param); // countdown
		}		
		public void internalExec(Model m) throws Exception{
			m.getDeviceRow().addDevice(new CountdownDevice(this.param));
		}
	}
	
	/**
	 * Models the exit command
	 * @author Andrea Santi
	 *
	 */

	public static class Exit extends Command{
	  public void internalExec(Model m) throws Exception {
	    throw new ExitCommandException();
	  }
	  public boolean isExit(){
	    return true;
	  }
	}
}