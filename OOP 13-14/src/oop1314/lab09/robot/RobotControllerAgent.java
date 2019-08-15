package oop1314.lab09.robot;


public class RobotControllerAgent /* la classe dovrà essere in esecuzione su un thread separato...*/ {

  private static final int N_DIRECTION = 4;
  private static final int UP_DIRECTION = 0;
  private static final int DOWN_DIRECTION = 1;
  private static final int LEFT_DIRECTION = 2;
  private static final int RIGHT_DIRECTION = 3;
  private Robot r;
  private int nItemsToPick;

  public RobotControllerAgent(Robot r, int nItemsToPick){
    this.r = r;
    this.nItemsToPick = nItemsToPick;
  }

  public void run() {
    long startTime = System.currentTimeMillis();
    int nFoundObjects = 0;
    int nextDirection;
    Position pos;
    while (nFoundObjects<nItemsToPick){
      /**
       * 1) Cercare un oggetto a partire dalla posizione corrente
       * 2) Se l'oggetto è stato individuato, raccoglierlo
       * 3) Calcolare in maniera casuale la prossima direzione in cui muoversi
       *    appoggiandosi a Math.random()
       * 4) Muovere il robot nella nuova direzione calcolata
       * 5) Gestire opportunamente le eccezioni che vengono lanciate:
       *    - il catch di UnknownRobotException, PositionOutOfBoundException e PositionNotFreeException non dovrà fare nulla
       *    - il catch di NotEnoughBatteryException dovrà portare a ricaricare la batteria del robot
       *    - il catch di ObjNotFoundException dovrà lanciare un messaggio di errore personalizzato 
       *
       */
    }
    /** Stampare un messaggio del tipo [FINISHED:] <ROBOT-NAME> <ELAPSED-TIME> con cui indicare la terminazione delle ricerche **/
  }
}