package acme.exams.main;

import acme.exams.controller.Controller;
import acme.exams.model.Model;
import acme.exams.views.MainFrame;

/**
 * Main class of the ACME-Exams application.
 * @author Andrea Santi
 *
 */
public class Main {

  public static void main(String[] args) {
      Model m = new Model();
      Controller c = new Controller(m);
      MainFrame v = new MainFrame();
      v.setVisible(true);
      c.setView(v);
    }
}