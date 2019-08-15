package oop1314.lab07.devices.sol;

/**
 * @author Mirko Viroli
 * 
 * The Controller class as of MVC
 *
 */
public class Controller{

	final private static String START = "Sistema inizializzato";
	final private static String CMD_EXIT = "Comando di uscita... bye bye";
	final private static String CMD_ERROR = "Comando errato";
	private static final String CMD_EXEC_ERROR = "Errore durante l'esecuzione del comando:";
	final private static String CMD_UNKNOWN = "Comando non riconosciuto";
	final private static String CMD_OK = "Comando eseguito";
	final private static String ASK = "Inserisci il comando (exit, on N, off N, onall, offall, add N): ";

	private Model model;
	private View view;
	private CommandExecutor executor;

	public Controller() {
		super();
		this.model = new DeviceRowModel(new DeviceRow());
		this.view = new ConsoleView();
		this.executor = new CommandExecutor(this.model);
	}

	/**
	 * This method implements the main loop of the program 
	 */
	public void start() {
		this.view.setLogString(START);
		while (true) {
			try {
				this.view.setRowStatus(this.model.getDeviceRow().toString());
				this.view.redraw();
				this.executor.exec(this.view.ask(ASK));
				this.view.setLogString(CMD_OK);
			} catch (ExecutionException e) {
				this.view.setLogString(CMD_EXEC_ERROR + ": "+e.getMessage());
			} catch (ExitCommandException e){
				System.out.println(CMD_EXIT);
				System.exit(0);
			} catch (InvalidCommandException e) {
				this.view.setLogString(CMD_ERROR + ": " + e.getMessage());
			} 
		}
	}
	
	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
}
