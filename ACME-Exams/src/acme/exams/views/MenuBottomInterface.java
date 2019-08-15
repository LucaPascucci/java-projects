package acme.exams.views;

import acme.exams.views.MenuBottom;

/**
 * Interface fpr the bottom menu of the application
 * @author Andrea Santi
 *
 */
public interface MenuBottomInterface {
  void setUserLogged();
  void setUserNotLogged();
  void attachViewObserver(MenuBottom.MenuBottomViewObserver observer);
}