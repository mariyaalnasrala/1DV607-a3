package model.rules;

import model.Player;

/**
 * Implements a strategy where the dealer always wins in certain conditions.
 * In this strategy, the dealer wins on a tie, unless either the player or dealer exceeds the maximum score.
 */
public class DealerAlwaysWinsStrategy implements WinStrategy {

  /**
   * Determines if the dealer is the winner based on the current scores of the dealer and player.
   * In this strategy, the dealer wins on a tie unless any party exceeds the maximum score.
   *
   * @param dealer The dealer whose score is being evaluated.
   * @param player The player whose score is being evaluated.
   * @return True if the dealer is the winner, false otherwise.
   */
  @Override
  public boolean isDealerWinner(Player dealer, Player player) {
    if (player.calcScore() > dealer.getMaxScore()) {
      return false;
    } else if (dealer.calcScore() > dealer.getMaxScore()) {
      return false;
    } else if (dealer.calcScore() == player.calcScore()) {
      return true; // Dealer wins on a tie.
    }
    return dealer.calcScore() >= player.calcScore();
  }
}
