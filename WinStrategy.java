package model.rules;

import model.Player;

/**
 * Interface for defining the strategy to determine the winner of the game.
 * Different implementations can provide different rules for deciding if the
 * dealer or the player wins.
 */
public interface WinStrategy {

  /**
   * Determines whether the dealer wins based on the scores of both players.
   *
   * @param dealer The dealer player whose score is being evaluated.
   * @param player The human player whose score is being evaluated.
   * @return True if the dealer wins, false otherwise.
   */
  boolean isDealerWinner(Player dealer, Player player);
}
