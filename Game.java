package model;

/**
 * Represents the main game logic for a Blackjack game.
 * Manages interactions between a dealer and a player, including game rules
 * such as hitting, standing, and determining the winner.
 */
public class Game {

  private Dealer dealer;
  private Player player;
  private int playerWins;
  private int dealerWins;

  /**
   * Constructor that creates a new game instance with a dealer and player.
   */
  public Game() {
    dealer = new Dealer(new model.rules.RulesFactory());
    player = new Player();
    playerWins = 0;
    dealerWins = 0;
  }

  /**
   * Gets the player in the game.
   *
   * @return The player.
   */
  public Player getPlayer() {
    return player.getCopy();
  }

  /**
   * Gets the dealer in the game.
   *
   * @return The dealer.
   */
  public Dealer getDealer() {
    return dealer.getCopy();
  }

  /**
   * Checks if the game has ended.
   *
   * @return true if the game has ended.
   */
  public boolean isGameOver() {
    return dealer.isGameOver();
  }

  /**
   * Checks if the dealer is the winner.
   *
   * @return True if the dealer has won over the player.
   */
  public boolean isDealerWinner() {
    boolean dealerWon = dealer.isDealerWinner(player);
    if (isGameOver()) {
      if (dealerWon) {
        dealerWins++;
      } else {
        playerWins++;
      }
    }
    return dealerWon;
  }

  /**
   * Starts a new game.
   *
   * @return True if a new game could be started.
   */
  public boolean newGame() {
    return dealer.newGame(player);
  }

  /**
   * Call to let the player get a new card.
   *
   * @return True if the player got a new card.
   */
  public boolean hit() {
    return dealer.hit(player);
  }

  /**
   * Call to let the dealer take cards.
   *
   * @return True if the dealer has the initiative.
   */
  public boolean stand() {
    return dealer.stand();
  }

  /**
   * Gets the cards currently in the dealer's hand.
   *
   * @return The dealer's cards.
   */
  public Iterable<Card> getDealerHand() {
    return dealer.getHand();
  }

  /**
   * Gets the cards currently in the player's hand.
   *
   * @return The player's cards.
   */
  public Iterable<Card> getPlayerHand() {
    return player.getHand();
  }

  /**
   * Returns the score of the dealer's hand.
   *
   * @return the score.
   */
  public int getDealerScore() {
    return dealer.calcScore();
  }

  /**
   * Returns the score of the player's hand.
   *
   * @return the score.
   */
  public int getPlayerScore() {
    return player.calcScore();
  }

  /**
   * Gets the number of wins by the player.
   *
   * @return The number of player wins.
   */
  public int getPlayerWins() {
    return playerWins;
  }

  /**
   * Gets the number of wins by the dealer.
   *
   * @return The number of dealer wins.
   */
  public int getDealerWins() {
    return dealerWins;
  }

  /**
   * register a new card observer for player and dealer.
   */
  public void cardObserver(GameObserver observer) {
  }
}
