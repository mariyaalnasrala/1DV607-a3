package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

/**
 * Rule interface for managing the start of a new game, i.e., dealing the cards.
 * This interface defines the contract for how cards should be distributed
 * between the dealer and player at the beginning of a game.
 */
public interface NewGameStrategy {
  
  /**
   * Encapsulates the start of a new game. Deals cards to the dealer and player according to a specific rule.
   *
   * @param deck The deck to use to draw cards from.
   * @param dealer The dealer to deal cards to.
   * @param player The player to deal cards to.
   * @return True if the game could be started, false otherwise.
   */
  boolean newGame(Deck deck, Dealer dealer, Player player);
}
