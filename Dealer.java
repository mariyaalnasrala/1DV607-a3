package model;

import java.util.ArrayList;
import java.util.List;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.RulesFactory;
import model.rules.WinStrategy;

/**
 * Represents a dealer player that handles the deck of cards and runs the game
 * using rules.
 */
public class Dealer extends Player {

  private Deck deck;
  private NewGameStrategy newGameRule;
  private HitStrategy hitRule;
  private WinStrategy winStrategy;
  private List<GameObserver> observers = new ArrayList<>();

  /**
   * Initializing constructor.
   * A factory that creates the rules to use.
   *
   * @param rulesFactory The factory that provides the rules.
   */
  public Dealer(RulesFactory rulesFactory) {
    newGameRule = rulesFactory.getNewGameRule();
    hitRule = rulesFactory.getHitRule();
    winStrategy = rulesFactory.getWinRule();
  }

  /**
   * copy dealer.
   */
  public Dealer(Dealer another) {
    // Kopiera Player-delen
    super(another);
    // Ny instans av Deck, om nödvändigt
    this.deck = new Deck();
    // Kopiera reglerna (antag att de är immutabla eller har en djup kopiering)
    this.newGameRule = another.newGameRule;
    this.hitRule = another.hitRule;
    this.winStrategy = another.winStrategy;
    // Kopiera observatörer
    this.observers = new ArrayList<>(another.observers);

  }

  public Dealer getCopy() {
    return new Dealer(this);
  }

  /**
   * Attaches an observer to the dealer.
   *
   * @param observer The observer to be added.
   */
  @Override
  public void attach(GameObserver observer) {
    if (observer != null) {
      observers.add(observer);
    }
  }

  /**
   * Detaches an observer from the dealer.
   *
   * @param observer The observer to be removed.
   */
  @Override
  public void detach(GameObserver observer) {
    observers.remove(observer);
  }

  /**
   * Notifies all observers of a change.
   */
  @Override
  public void notifyObservers() {
    for (GameObserver observer : observers) {
      observer.update();
    }
  }

  /**
   * Starts a new game if the game is not currently underway.
   *
   * @param player The player to play against.
   * @return True if the game could be started.
   */
  public boolean newGame(Player player) {
    if (deck == null || isGameOver()) {
      deck = new Deck();
      clearHand();
      player.clearHand();
      notifyObservers(); // Notify observers about game start
      return newGameRule.newGame(deck, this, player);
    }
    return false;
  }

  /**
   * Gives the player one more card if possible.
   *
   * @param player The player to give a card to.
   * @return True if the player could get a new card, false otherwise.
   */
  public boolean hit(Player player) {
    if (deck != null && player.calcScore() < player.getMaxScore() && !isGameOver()) {
      newCard(player, true);
      
      return true;
    }
    return false;
  }

  /**
   * Checks if the dealer is the winner compared to a player.
   *
   * @param player The player to check against.
   * @return True if the dealer is the winner, false if the player is the winner.
   */
  public boolean isDealerWinner(Player player) {
    return winStrategy.isDealerWinner(this, player);
  }

  /**
   * Checks if the game is over, i.e., the dealer can take no more cards.
   *
   * @return True if the game is over.
   */
  public boolean isGameOver() {
    return deck != null && !hitRule.doHit(this);
  }

  /**
   * The player has chosen to take no more cards, it is the dealer's turn.
   *
   * @return True if the dealer completed their turn, false otherwise.
   */
  public boolean stand() {
    if (deck != null) {
      showHand();
      while (hitRule.doHit(this)) {
        Card.Mutable card = deck.getCard();
        card.show(true);
        dealCard(card);
        notifyObservers(); // Notify observers when a card is dealt
      }
      return true;
    }
    return false;
  }

  /**
   * Returns the dealer's hand.
   *
   * @return The dealer's hand.
   */
  @Override
  public Iterable<Card> getHand() {
    return new ArrayList<>(hand);
  }

  /**
   * Calculates the score of the dealer's hand.
   *
   * @return The score.
   */
  @Override
  public int calcScore() {
    return super.calcScore();
  }

  /**
   * get new card, nd deal it to player.
   */

  public void newCard(Player player, boolean show) {
    Card.Mutable card = deck.getCard();
    player.dealCard(card);
    card.show(show);
  }
}
