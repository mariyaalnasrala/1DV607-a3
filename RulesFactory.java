package model.rules;

/**
 * Factory class for creating concrete rules used in the game.
 * This class provides methods to instantiate various strategies for hitting,
 * starting a new game, and determining the winner.
 */
public class RulesFactory {

  /**
   * Creates the rule to use for the dealer's hit behavior.
   *
   * @return The HitStrategy rule to use for determining when the dealer should
   *         take additional cards.
   */
  public HitStrategy getHitRule() {
    return new BasicHitStrategy();
  }

  /**
   * Creates the rule to use when starting a new game.
   *
   * @return The NewGameStrategy rule to use for dealing initial cards to the
   *         player and dealer.
   */
  public NewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  /**
   * Creates the rule to use for determining the winner of the game.
   *
   * @return The WinStrategy rule to use for deciding the winner at the end of the
   *         game.
   */
  public WinStrategy getWinRule() {
    // You can return any implementation you prefer.
    return new DealerAlwaysWinsStrategy(); // Or new PlayerAlwaysWinsStrategy();
  }
}