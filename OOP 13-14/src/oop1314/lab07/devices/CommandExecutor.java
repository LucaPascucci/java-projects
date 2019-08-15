package oop1314.lab07.devices;

import static oop1314.lab07.devices.ParserFactory.parseAndBuild;
/**
 * @author Mirko Viroli 
 * Implements a CommandExecutor, encapsulating all corresponding design choices
 */
public class CommandExecutor {

  final private static String ON = "on";
  final private static String OFF = "off";
  final private static String ADD = "add";
  final private static String EXIT = "exit";
  final private static String OFFALL = "offall";
  final private static String ONALL = "onall";
  final private static String ERROR_UNRECOGNISED = "Unrecognised string";

  private Model model;
  private Command command;

  public CommandExecutor(Model model) {
    this.model = model;
  }

  /**
   * Executes the command parsed from the string provided in input
   * 
   * @param s is the String command to interpret and execute
   * @throws ExitCommandException
   * @throws InvalidCommandException
   * @throws DeviceIsOverException
   */
  public void exec(String s) throws ExecutionException, ExitCommandException,	InvalidCommandException {
    Command cmd = build(s);
    if (cmd.isExit()){
      throw new ExitCommandException();
    }
    cmd.exec(this.model);
  }

  // Esegue il primo dei comandi riconosciuti
  private Command build(String s) throws InvalidCommandException {
    this.command = null;
    this.command = parseAndBuild(s, Exit.class, EXIT);
    if (this.command == null){
    	this.command = parseAndBuild(s, Command.AllOn.class, ONALL);
    }
    if (this.command == null){
    	this.command = parseAndBuild(s, Command.AllOff.class, OFFALL);
    }
    if (this.command == null){
    	this.command = parseAndBuild(s, Command.On.class, ON);
    }
    if (this.command == null){
    	this.command = parseAndBuild(s, Command.Off.class, OFF);
    }
    if (this.command == null){
    	this.command = parseAndBuild(s, Command.Add.class, ADD);
    }
    if (this.command != null) {
      return this.command;
    }
    throw new InvalidCommandException(ERROR_UNRECOGNISED);
  }
}