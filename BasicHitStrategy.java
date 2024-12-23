package model.rules;

import model.Player;

/**
 * Implements the basic hit strategy for the Blackjack dealer.
 * The dealer will continue to draw cards as long as their score is below a
 * certain limit.
 */
class BasicHitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  /**
   * Determines whether the dealer should take another card.
   * According to this strategy, the dealer must draw cards until their score
   * reaches or exceeds 17.
   *
   * @param dealer The dealer whose score is being evaluated.
   * @return True if the dealer's score is less than the hit limit, false
   *         otherwise.
   */
  public boolean doHit(Player dealer) {
    return dealer.calcScore() < hitLimit;
  }
}
