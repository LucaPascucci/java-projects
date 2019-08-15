package oop1314.lab07.devices.sol;

public abstract class Command { 
	
	public boolean isExit(){
		return false;
	}
	
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
	
	public static abstract class ParametricCommand extends Command {
		protected int param;
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
	
	public static class Exit extends Command{
		public void internalExec(Model m) throws Exception {
			throw new ExitCommandException();
		}
		public boolean isExit(){
			return true;
		}
	}
}