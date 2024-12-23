package model.rules;

import model.Player;

/**
 * Implements a strategy where the player always wins under certain conditions.
 * In this strategy, if the dealer and player have the same score, the player
 * wins.
 * Additionally, if either the dealer or player exceeds the maximum score, the
 * player does not lose.
 */
public class PlayerAlwaysWinsStrategy implements WinStrategy {

  /**
   * Determines if the dealer is the winner based on the current scores of the
   * dealer and player.
   * In this strategy, the player always wins on a tie and also wins if the dealer
   * exceeds the maximum score.
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
      return false; // Player wins on a tie.
    }
    return dealer.calcScore() > player.calcScore();
  }
}