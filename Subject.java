package model;

/**
 * Subject interface for managing observers.
 */
public interface Subject {

  /**
   * Adds an observer to be notified of changes.
   *
   * @param observer The observer to be added.
   */
  void attach(GameObserver observer);

  /**
   * Removes an observer from notifications.
   *
   * @param observer The observer to be removed.
   */
  void detach(GameObserver observer);

  /**
   * Notifies all observers about a change.
   */
  void notifyObservers();
}
