package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the Blackjack game. A Player has a hand of cards
 * and can take actions such as hitting, standing, or quitting.
 */
public class Player implements Subject {

  protected List<Card.Mutable> hand;
  protected final int maxScore = 21;
  private List<GameObserver> observers;

  /**
   * Constructor for Player, initializes the player's hand and observer list.
   */
  public Player() {
    hand = new ArrayList<>();
    observers = new ArrayList<>();
  }

  private Player copy;

  /**
   * player copy.
   */
  public Player(Player another) {
    this.copy = another.copy;
    // Make a deep copy of the hand
    this.hand = new ArrayList<>(another.hand);
    // Deep copy observers
    this.observers = new ArrayList<>(another.observers);
  }

  public Player getCopy() {
    return new Player(this);
  }

  /**
   * Adds a card to the Player's hand and notifies observers.
   * The card to add to the hand.
   */
  public void dealCard(Card.Mutable card) {
    hand.add(card);
    notifyObservers(); // Notify observers when a new card is dealt
  }

  /**
   * Attaches an observer to the player.
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
   * Detaches an observer from the player.
   *
   * @param observer The observer to be removed.
   */
  @Override
  public void detach(GameObserver observer) {
    observers.remove(observer);
  }

  /**
   * Notifies all attached observers of a change.
   */
  @Override
  public void notifyObservers() {
    for (GameObserver observer : observers) {
      observer.update();
    }
  }

  /**
   * Returns the player's hand.
   *
   * @return The player's hand.
   */
  public Iterable<Card> getHand() {
    return new ArrayList<>(hand);
  }

  /**
   * Reveals all cards in the player's hand.
   */
  public void showHand() {
    for (Card.Mutable card : hand) {
      card.show(true);
    }
  }

  /**
   * Calculates the score of the player's hand according to Blackjack rules.
   *
   * @return The score.
   */
  public int calcScore() {
    int[] cardScores = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
    assert (cardScores.length == Card.Value.Count.ordinal())
        : "Card Scores array size does not match number of card values";

    int score = 0;

    for (Card c : getHand()) {
      if (c.getValue() != Card.Value.Hidden) {
        score += cardScores[c.getValue().ordinal()];
      }
    }

    // Reduce score by 10 for each Ace if score exceeds maxScore
    if (score > maxScore) {
      for (Card c : getHand()) {
        if (c.getValue() == Card.Value.Ace && score > maxScore) {
          score -= 10;
        }
      }
    }

    return score;
  }

  /**
   * Returns the maximum score for the game.
   *
   * @return The maximum score.
   */
  public int getMaxScore() {
    return maxScore;
  }

  /**
   * Clears the player's hand.
   */
  public void clearHand() {
    hand.clear();
  }
}
