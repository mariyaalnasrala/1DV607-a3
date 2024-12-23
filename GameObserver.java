package model;

/**
 * interface game observer.
 */
public interface GameObserver {

  // update when game state changes.
  void update();

  /**
   * call when card is dealt in game.
   */

  void cardDealt();

  /**
    * called when came is over(notify).
    */

  void gameOver();
}
