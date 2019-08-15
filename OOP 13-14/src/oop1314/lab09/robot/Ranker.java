package oop1314.lab09.robot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Ranker {

  private Map<Integer, SearchResultInfo> rankings;
  private int position;

  public Ranker (){
    /* Creare una  nuova treemap ordinata rispetto al valore numerico della chiave
     * (indicherà l'ordine con cui sono arrivati i risultati
     * this.rankings = new TreeMap<>(...);*/
    this.position = 1;
  }

  /*
   * Implementare un metodo con signature "simile" a "finish(SearchResultInfo info)".
   * L'idea è che ogni RobotControllerAgent dovrà invocare questo metodo per notificare
   * la sua terminazione delle operazioni di ricerca
   * */
  
  
  public void printRankings(){
    /* Stampa ordinata dei ranking */
  }
  
  /* classe di utilità che memorizza le informazioni relative alla ricerca di uno dei robot*/
  public static class SearchResultInfo {
    private String particpant;
    private long time;
    public SearchResultInfo(String particpant, long time) {
      super();
      this.particpant = particpant;
      this.time = time;
    }
    public String getParticpant() {
      return particpant;
    }
    public long getTime() {
      return time;
    }
  }
}