package oop1314.lab07.devices;

/**
 * Models the exit command
 * @author Andrea Santi
 *
 */

public class Exit extends Command{
  public void internalExec(Model m) throws Exception {
    throw new ExitCommandException();
  }
  public boolean isExit(){
    return true;
  }
}