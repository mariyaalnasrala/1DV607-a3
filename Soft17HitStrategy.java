package model.rules;

import model.Card;
import model.Player;

/**
 * Implements the Soft 17 hit strategy for the dealer in Blackjack.
 * According to this rule, the dealer hits on a soft 17, which is a hand
 * containing an Ace valued as 11 and a six.
 */
public class Soft17HitStrategy implements HitStrategy {
  // Define the hit limit.
  private static final int hitLimit = 17;

  /**
   * Determines if the dealer should take another card based on the Soft 17 rule.
   * The dealer hits on any score below 17 or on a soft 17.
   *
   * @param dealer The dealer whose score is being evaluated.
   * @return True if the dealer should take another card, false otherwise.
   */
  @Override
  public boolean doHit(Player dealer) {
    // Check if dealer's score is below 17; if so, dealer should hit.
    if (dealer.calcScore() < hitLimit) {
      return true;
    }

    // Check for a soft 17 (17 with an Ace counted as 11 and a six).
    if (dealer.calcScore() == hitLimit && isSoft17(dealer)) {
      return true;
    }

    // Dealer should stand on hard 17 or above.
    return false;
  }

  /**
   * Helper method to check if the dealer has a "soft 17" (Ace and six).
   *
   * @param dealer The dealer whose hand is being evaluated.
   * @return True if the dealer has a soft 17, false otherwise.
   */
  private boolean isSoft17(Player dealer) {
    boolean hasAce = false;
    boolean hasSix = false;

    // Iterate through dealer's hand to check for an Ace and a Six.
    for (Card card : dealer.getHand()) {
      if (card.getValue() == Card.Value.Ace) {
        hasAce = true;
      } else if (card.getValue() == Card.Value.Six) {
        hasSix = true;
      }
    }

    // Soft 17 is defined as having both an Ace (valued as 11) and a Six.
    return hasAce && hasSix;
  }
}